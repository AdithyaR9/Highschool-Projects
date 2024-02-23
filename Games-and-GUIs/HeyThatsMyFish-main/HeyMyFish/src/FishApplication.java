

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FishApplication extends Application {


    private ArrayList<FishPenguin> orangePlayer = new ArrayList<FishPenguin>();
    private ArrayList<FishPenguin> yellowPlayer = new ArrayList<FishPenguin>();
    private FishMap map;
    private GraphicsContext gc;
    private Image iceFLowThree = new Image("three_fish.png");
    private Image iceFlowTwo = new Image("two_fish.png");
    private Image iceFlowOne = new Image("one_fish.png");
    private Image orangePl = new Image("orange.png");
    private Image yellowPl = new Image("yellow.png");
    private boolean orangeTurn = true;
    private static final int PLACING = 0;
    private static final int PLAYING = 1;
    private static final int GAMEOVER = 2;
    private int status;
    private int placingCounter = 0;
    private int oldR = -1, oldC = -1, selectedR = -1, selectedC = -1;
    private boolean anySelected = false;
    private int orangeScore = 0;
    private int yellowScore = 0;
    private boolean yellowWins = false;
    private boolean orangeWins = false;
    private boolean orangeTieYellow = false;
    private boolean orangeEliminated = false;
    private boolean yellowEliminated = false;
    private int X;
    private int Y;
    private Canvas canvas;


    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        map = new FishMap();
        System.out.print(map);

        primaryStage.setTitle("Hey My Fish");

        Group group = new Group();

        canvas = new Canvas(800, 800);

        gc = canvas.getGraphicsContext2D();
        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                X = (int) event.getX();
                Y = (int) event.getY();

                int c = (X - 25) / 75;
                int r = (Y - 50) / 75;

                if ((c > 9 || c < 0)) {
                    return;
                }
                if ((r > 5 || r < 0)) {
                    return;
                }
                System.out.println(r);
                System.out.println(c);
                System.out.println("selected" + selectedR);
                System.out.println("selected" + selectedC);

                if (status == PLACING) {
                    penguinPlacement(c, r);
                } else if (status == PLAYING) {
                    penguinsPlay(c, r);
                }

                paint(canvas.getGraphicsContext2D());
            }

        });

        canvas.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                String keypress = event.getCharacter();

                if (status == GAMEOVER) {

                    if (keypress.equals("n")) {
                        reset();
                    }
                }

                paint(canvas.getGraphicsContext2D());

            }
        });

        group.getChildren().add(canvas);

        Scene scene = new Scene(group);

        primaryStage.setScene(scene);

        paint(canvas.getGraphicsContext2D());

        canvas.requestFocus();
        primaryStage.show();
    }

    public void reset() {

        map = new FishMap();
        System.out.print(map);
        status = PLACING;
        orangeTurn = true;
        orangeScore = 0;
        yellowScore = 0;
        placingCounter = 0;
        yellowWins = false;
        orangeWins = false;
        orangeEliminated = false;
        yellowEliminated = false;
        orangeTieYellow = false;
        anySelected = false;
        orangePlayer.clear();
        yellowPlayer.clear();

    }


    public void paint(GraphicsContext gc) {

        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, 800, 800);

        //messages
        gc.setFill(Color.GRAY);
        gc.fillRect(50, 525, 350, 250);
        gc.setFont(Font.font(20));
        gc.setFill(Color.GREEN);
        gc.fillText("Messages", 175, 560);

        gc.setFill(Color.WHITE);
        gc.fillOval(450, 575, 50, 50);
        gc.drawImage(orangePl, 455, 577, 40, 40);
        gc.fillOval(450, 675, 50, 50);
        gc.drawImage(yellowPl, 455, 677, 40, 40);

        //Score
        gc.setFill(Color.BLACK);
        gc.fillText(":" + orangeScore, 500, 600);

        gc.setFill(Color.BLACK);
        gc.fillText(":" + yellowScore, 500, 700);

        gc.setFill(Color.WHITE);
        if (status == PLACING && orangeTurn) {
            gc.fillText("Orange Player: Place Your Penguin \n on a One-Fish Ice Flow.", 60, 600);
        } else if (status == PLACING && !orangeTurn) {
            gc.fillText("Yellow Player: Place Your Penguin \n on a One-Fish Ice Flow.", 60, 650);
        }

        if (status == PLAYING && orangeTurn) {
            gc.fillText("Orange turn to Move", 60, 600);
        } else if (status == PLAYING && !orangeTurn) {
            gc.fillText("Yellow turn to Move", 60, 650);
        }


        for (int y = 0; y < FishMap.NUM_ROWS; y++) {
            for (int x = 0; x < FishMap.NUM_COLUMNS; x++) {

                //one fish
                if (map.getSquare(x, y).getOneFish() && !map.getSquare(x, y).getCollected()) {
                    gc.drawImage(iceFlowOne, (x * 75) + 25, (y * 75) + 50, 75, 75);
                }
                //two fish
                if (map.getSquare(x, y).getTwoFish() && !map.getSquare(x, y).getCollected()) {
                    gc.drawImage(iceFlowTwo, (x * 75) + 25, (y * 75) + 50, 75, 75);
                }
                //three fish
                if (map.getSquare(x, y).getThreeFish() && !map.getSquare(x, y).getCollected()) {
                    gc.drawImage(iceFLowThree, (x * 75) + 25, (y * 75) + 50, 75, 75);
                }

                //draw penguins
                if (map.getSquare(x, y).getOrangePenguin()) {
                    gc.drawImage(orangePl, (x * 75) + 30, (y * 75) + 50, 50, 50);
                }

                if (map.getSquare(x, y).getYellowPenguin()) {
                    gc.drawImage(yellowPl, (x * 75) + 30, (y * 75) + 50, 50, 50);
                }

                //selected
                if (anySelected && status == PLAYING && orangeTurn && map.getSquare(x, y).getOrangePenguin()) {


                    if (map.getSquare(x, y).getSelected()) {
                        gc.setStroke(Color.STEELBLUE);
                        gc.strokeOval((x * 75) + 20, (y * 75) + 45, 75, 75);

                    }

                } else if (anySelected && status == PLAYING && !orangeTurn && map.getSquare(x, y).getYellowPenguin()) {

                    if (map.getSquare(x, y).getSelected()) {
                        gc.setStroke(Color.STEELBLUE);
                        gc.strokeOval((x * 75) + 20, (y * 75) + 45, 75, 75);

                    }


                }

            }
        }

        if (status == GAMEOVER) {

            gc.setFill(Color.BLACK);
            gc.fillRect(0,0,800,800);

            gc.setFill(Color.LIGHTPINK);

            if (orangeTieYellow) {
                gc.fillText("The Game is a Tie at: " + orangeScore, 350, 350);
            }
            if (orangeWins) {
                gc.fillText("Orange Player Won with: " + orangeScore, 350, 350);
            }
            if (yellowWins) {
                gc.fillText("Yellow Player Won with: " + yellowScore, 350, 350);
            }

            gc.fillText("Press N to restart Game", 500, 500);
        }

    }

    public void penguinPlacement(int col, int row) {

        //placing penguins
        if (status == PLACING) {
            if (orangeTurn && !map.getSquare(col, row).getOrangePenguin() && !map.getSquare(col, row).getYellowPenguin() && !map.getSquare(col, row).getTwoFish() && !map.getSquare(col, row).getThreeFish() && orangePlayer.size() < 4) {
                orangePlayer.add(new FishPenguin(row, col));
                map.getSquare(col, row).setOrangePenguin(true);
                placingCounter++;
                orangeTurn = false;
            } else if (!orangeTurn && !map.getSquare(col, row).getOrangePenguin() && !map.getSquare(col, row).getYellowPenguin() && !map.getSquare(col, row).getTwoFish() && !map.getSquare(col, row).getThreeFish() && yellowPlayer.size() < 4) {
                yellowPlayer.add(new FishPenguin(row, col));
                map.getSquare(col, row).setYellowPenguin(true);
                placingCounter++;
                orangeTurn = true;
            }
        }

        if (placingCounter == 8) {
            status = PLAYING;
        }

    }

    public boolean validMove(int row, int col, int selectedR, int selectedC) {
        boolean goodMove = true;
        boolean validDirection = false;

        //Diagonals

        //NE
        if ((row - selectedR) * -1 == (col - selectedC) && (row < selectedR && col > selectedC)) {
            System.out.println("Checking for NE");
            validDirection = true;

            if (map.getSquare(col, row).getOrangePenguin() || map.getSquare(col, row).getYellowPenguin() || map.getSquare(col, row).getCollected()) {
                goodMove = false;
            }
            for (int m = 1; m <= (col - selectedC); m++) {
                System.out.println("Accessed row = " + selectedR + "-" + m);
                System.out.println("Accessed col = " + selectedC + "+" + m);
                if (map.getSquare(selectedC + m, selectedR - m).getCollected() || map.getSquare(selectedC + m, selectedR - m).getOrangePenguin() || map.getSquare(selectedC + m, selectedR - m).getYellowPenguin()) {
                    goodMove = false;
                }
            }
            System.out.println(goodMove);
        }

        //NW
        if ((row - selectedR) == (col - selectedC) && (row < selectedR && col < selectedC)) {
            System.out.println("Checking for NW");
            validDirection = true;

            if (map.getSquare(col, row).getOrangePenguin() || map.getSquare(col, row).getYellowPenguin() || map.getSquare(col, row).getCollected()) {
                goodMove = false;
            }
            for (int m = 1; m <= (selectedC - col); m++) {
                System.out.println("Accessed row = " + selectedR + "-" + m);
                System.out.println("Accessed col = " + selectedC + "-" + m);
                if (map.getSquare(selectedC - m, selectedR - m).getCollected() || map.getSquare(selectedC - m, selectedR - m).getOrangePenguin() || map.getSquare(selectedC - m, selectedR - m).getYellowPenguin()) {
                    goodMove = false;
                }
            }
            System.out.println(goodMove);
        }

        //SE
        if ((row - selectedR) == (col - selectedC) && (row > selectedR && col > selectedC)) {
            System.out.println("Checking for SE");
            validDirection = true;

            if (map.getSquare(col, row).getOrangePenguin() || map.getSquare(col, row).getYellowPenguin() || map.getSquare(col, row).getCollected()) {
                goodMove = false;
            }
            for (int m = 1; m <= (col - selectedC); m++) {
                System.out.println("Accessed row = " + selectedR + "+" + m);
                System.out.println("Accessed col = " + selectedC + "+" + m);
                if (map.getSquare(selectedC + m, selectedR + m).getCollected() || map.getSquare(selectedC + m, selectedR + m).getOrangePenguin() || map.getSquare(selectedC + m, selectedR + m).getYellowPenguin()) {
                    goodMove = false;
                }
            }
            System.out.println(goodMove);
        }

        //SW
        if ((row - selectedR) * -1 == (col - selectedC) && (row > selectedR && col < selectedC)) {
            System.out.println("Checking for SW");
            validDirection = true;

            if (map.getSquare(col, row).getOrangePenguin() || map.getSquare(col, row).getYellowPenguin() || map.getSquare(col, row).getCollected()) {
                goodMove = false;
            }
            for (int m = 1; m <= (selectedC - col); m++) {
                System.out.println("Accessed row = " + selectedR + "+" + m);
                System.out.println("Accessed col = " + selectedC + "-" + m);
                if (map.getSquare(selectedC - m, selectedR + m).getCollected() || map.getSquare(selectedC - m, selectedR + m).getOrangePenguin() || map.getSquare(selectedC - m, selectedR + m).getYellowPenguin()) {
                    goodMove = false;
                }
            }
            System.out.println(goodMove);
        }

        //Cardinal| Orthagonal

        //N
        if ((row - selectedR) * -1 > 0 && (col == selectedC) && (row < selectedR)) {
            System.out.println("Checking for N");
            validDirection = true;

            if (map.getSquare(col, row).getOrangePenguin() || map.getSquare(col, row).getYellowPenguin() || map.getSquare(col, row).getCollected()) {
                goodMove = false;
            }
            for (int m = 1; m <= (selectedR - row); m++) {
                System.out.println("Accessed row = " + selectedR + "-" + m);
                System.out.println("Accessed col = " + selectedC);
                if (map.getSquare(selectedC, selectedR - m).getCollected() || map.getSquare(selectedC, selectedR - m).getOrangePenguin() || map.getSquare(selectedC, selectedR - m).getYellowPenguin()) {
                    goodMove = false;
                }
            }
            System.out.println(goodMove);
        }

        //S
        if ((row - selectedR) > 0 && (col == selectedC) && (row > selectedR)) {
            System.out.println("Checking for S");
            validDirection = true;

            if (map.getSquare(col, row).getOrangePenguin() || map.getSquare(col, row).getYellowPenguin() || map.getSquare(col, row).getCollected()) {
                goodMove = false;
            }
            for (int m = 1; m <= (row - selectedR); m++) {
                System.out.println("Accessed row = " + selectedR + "+" + m);
                System.out.println("Accessed col = " + selectedC);
                if (map.getSquare(selectedC, selectedR + m).getCollected() || map.getSquare(selectedC, selectedR + m).getOrangePenguin() || map.getSquare(selectedC, selectedR + m).getYellowPenguin()) {
                    goodMove = false;
                }
            }
            System.out.println(goodMove);
        }

        //E
        if ((col - selectedC) > 0 && (row == selectedR) && (col > selectedC)) {
            System.out.println("Checking for E");
            validDirection = true;

            if (map.getSquare(col, row).getOrangePenguin() || map.getSquare(col, row).getYellowPenguin() || map.getSquare(col, row).getCollected()) {
                goodMove = false;
            }
            for (int m = 1; m <= (col - selectedC); m++) {
                System.out.println("Accessed row = " + selectedR);
                System.out.println("Accessed col = " + selectedC + "+" + m);
                if (map.getSquare(selectedC + m, selectedR).getCollected() || map.getSquare(selectedC + m, selectedR).getOrangePenguin() || map.getSquare(selectedC + m, selectedR).getYellowPenguin()) {
                    goodMove = false;
                }
            }
            System.out.println(goodMove);
        }

        //W
        if ((col - selectedC) * -1 > 0 && (row == selectedR) && (col < selectedC)) {
            System.out.println("Checking for W");
            validDirection = true;

            if (map.getSquare(col, row).getOrangePenguin() || map.getSquare(col, row).getYellowPenguin() || map.getSquare(col, row).getCollected()) {
                goodMove = false;
            }
            for (int m = 1; m <= (selectedC - col); m++) {
                System.out.println("Accessed row = " + selectedR);
                System.out.println("Accessed col = " + selectedC + "-" + m);
                if (map.getSquare(selectedC - m, selectedR).getCollected() || map.getSquare(selectedC - m, selectedR).getOrangePenguin() || map.getSquare(selectedC - m, selectedR).getYellowPenguin()) {
                    goodMove = false;
                }
            }
            System.out.println(goodMove);
        }


        if (!goodMove) {
            validDirection = false;
        }
        return validDirection;
    }

    public void penguinsPlay(int col, int row) {

        if (status == PLAYING) {

            if (selectedR == -1 && selectedC == -1) {
                if ((map.getSquare(col, row).getYellowPenguin() && !orangeTurn) || (map.getSquare(col, row).getOrangePenguin() && orangeTurn)) {

                    map.getSquare(col, row).setSelected(true);

                    selectedR = row;
                    selectedC = col;
                    anySelected = true;
                }
            } else if (selectedR == row && selectedC == col) {

                if (orangeTurn) {
                    map.getSquare(col, row).setSelected(false);

                } else if (!orangeTurn) {
                    map.getSquare(col, row).setSelected(false);

                }
                selectedR = -1;
                selectedC = -1;
                anySelected = false;

            } else if (!map.getSquare(col, row).getCollected() && (selectedR != -1 && selectedC != -1)) {

                if (validMove(row, col, selectedR, selectedC)) {


                    System.out.println("Valid Move!");
                    if (orangeTurn) {
                        System.out.println("Entered orange");
                        for (int x = 0; x < orangePlayer.size(); x++) {

                            System.out.println("Entered Loop For orange");

                            if ((orangePlayer.get(x).getRowPos() == selectedR && orangePlayer.get(x).getColPos() == selectedC)) {

                                System.out.println("Penguin" + x + "worked");

                                System.out.println("Old Orange Player row" + orangePlayer.get(x).getRowPos());
                                System.out.println("Old Orange Player col" + orangePlayer.get(x).getColPos());

                                //score add
                                if (map.getSquare(selectedC, selectedR).getThreeFish()) {
                                    orangeScore += 3;
                                }
                                if (map.getSquare(selectedC, selectedR).getTwoFish()) {
                                    orangeScore += 2;
                                }
                                if (map.getSquare(selectedC, selectedR).getOneFish()) {
                                    orangeScore += 1;
                                }

                                orangePlayer.get(x).setRowPos(row);
                                orangePlayer.get(x).setColPos(col);

                                map.getSquare(selectedC, selectedR).setOrangePenguin(false);
                                map.getSquare(selectedC, selectedR).setCollected(true);
                                map.getSquare(selectedC, selectedR).setSelected(false);
                                map.getSquare(col, row).setOrangePenguin(true);

                                System.out.println("New Orange Player row" + orangePlayer.get(x).getRowPos());
                                System.out.println("New Orange Player col" + orangePlayer.get(x).getColPos());

                            }
                        }
                    } else if (!orangeTurn) {
                        System.out.println("Entered yellow");
                        for (int x = 0; x < yellowPlayer.size(); x++) {

                            System.out.println("Entered loop for yellow");

                            if (yellowPlayer.get(x).getRowPos() == selectedR && yellowPlayer.get(x).getColPos() == selectedC) {

                                System.out.println("Penguin" + x + "worked");

                                System.out.println("Old Yellow Player row" + yellowPlayer.get(x).getRowPos());
                                System.out.println("Old Yellow Player col" + yellowPlayer.get(x).getColPos());

                                //score add
                                if (map.getSquare(selectedC, selectedR).getThreeFish()) {
                                    yellowScore += 3;
                                }
                                if (map.getSquare(selectedC, selectedR).getTwoFish()) {
                                    yellowScore += 2;
                                }
                                if (map.getSquare(selectedC, selectedR).getOneFish()) {
                                    yellowScore += 1;
                                }

                                yellowPlayer.get(x).setRowPos(row);
                                yellowPlayer.get(x).setColPos(col);

                                map.getSquare(selectedC, selectedR).setYellowPenguin(false);
                                map.getSquare(selectedC, selectedR).setCollected(true);
                                map.getSquare(selectedC, selectedR).setSelected(false);
                                map.getSquare(col, row).setYellowPenguin(true);

                                System.out.println("New Yellow Player row" + yellowPlayer.get(x).getRowPos());
                                System.out.println("New Yellow Player col" + yellowPlayer.get(x).getColPos());

                            }
                        }
                    }
                    orangeTurn = !orangeTurn;
                    selectedR = -1;
                    selectedC = -1;
                }
            }

            removeStuckPenguins();

            if (orangeEliminated && yellowEliminated) {
                status = GAMEOVER;
                gameIsOver();
            } else if (orangeEliminated) {
                orangeTurn = false;
                System.out.println("Orange Eliminated, his turn skipped");
            } else if (yellowEliminated) {
                orangeTurn = true;
                System.out.println("Yellow Eliminated, his turn skipped");
            }

        }

        paint(canvas.getGraphicsContext2D());

    }

    public void removeStuckPenguins() {

        // if I need to remove a penguin after the next turn surround the for loops with an if statement that does it by the players turn

        for (int a = orangePlayer.size() - 1; a >= 0; a--) {
            int moves = 0;

            System.out.println("Orange Row " + orangePlayer.get(a).getRowPos());
            System.out.println("Orange Col " + orangePlayer.get(a).getColPos());

            moves = anyMoves(orangePlayer.get(a).getRowPos(), orangePlayer.get(a).getColPos());

            if (moves == 0 || moves < 0) {

                //collects isolated square
                map.getSquare(orangePlayer.get(a).getColPos(), orangePlayer.get(a).getRowPos()).setCollected(true);

                //adds score for isolated square
                if (map.getSquare(orangePlayer.get(a).getColPos(), orangePlayer.get(a).getRowPos()).getThreeFish()) {
                    orangeScore += 3;
                }
                if (map.getSquare(orangePlayer.get(a).getColPos(), orangePlayer.get(a).getRowPos()).getTwoFish()) {
                    orangeScore += 2;
                }
                if (map.getSquare(orangePlayer.get(a).getColPos(), orangePlayer.get(a).getRowPos()).getOneFish()) {
                    orangeScore += 1;
                }

                map.getSquare(orangePlayer.get(a).getColPos(), orangePlayer.get(a).getRowPos()).setOrangePenguin(false);
                orangePlayer.remove(a);
            }
        }

        for (int a = yellowPlayer.size() - 1; a >= 0; a--) {
            int moves = 0;

            System.out.println("Yellow Row" + yellowPlayer.get(a).getRowPos());
            System.out.println("Yellow Col" + yellowPlayer.get(a).getColPos());

            moves = anyMoves(yellowPlayer.get(a).getRowPos(), yellowPlayer.get(a).getColPos());

            if (moves == 0 || moves < 0) {

                //collects isolated square
                map.getSquare(yellowPlayer.get(a).getColPos(), yellowPlayer.get(a).getRowPos()).setCollected(true);

                //adds score for isolated square
                if (map.getSquare(yellowPlayer.get(a).getColPos(), yellowPlayer.get(a).getRowPos()).getThreeFish()) {
                    yellowScore += 3;
                }
                if (map.getSquare(yellowPlayer.get(a).getColPos(), yellowPlayer.get(a).getRowPos()).getTwoFish()) {
                    yellowScore += 2;
                }
                if (map.getSquare(yellowPlayer.get(a).getColPos(), yellowPlayer.get(a).getRowPos()).getOneFish()) {
                    yellowScore += 1;
                }

                map.getSquare(yellowPlayer.get(a).getColPos(), yellowPlayer.get(a).getRowPos()).setYellowPenguin(false);
                yellowPlayer.remove(a);
            }
        }

        if (orangePlayer.size() == 0) {
            orangeEliminated = true;
            System.out.println("Orange Has been eliminated");
        }
        if (yellowPlayer.size() == 0) {
            yellowEliminated = true;
            System.out.println("Yellow Has been Eliminated");
        }

    }

    public int anyMoves(int penguinRow, int penguinCol) {
        int anyMovesCanBeDone = 0;
        System.out.println("penguinRow " + penguinRow);
        System.out.println("penguinCol " + penguinCol);

        if ((penguinCol + 1 <= 9 && penguinCol - 1 >= 0) && (penguinRow + 1 <= 5 && penguinRow - 1 >= 0)) {
            //NE
            if (!map.getSquare(penguinCol + 1, penguinRow - 1).getCollected() && !map.getSquare(penguinCol + 1, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //NW
            if (!map.getSquare(penguinCol - 1, penguinRow - 1).getCollected() && !map.getSquare(penguinCol - 1, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //SE
            if (!map.getSquare(penguinCol + 1, penguinRow + 1).getCollected() && !map.getSquare(penguinCol + 1, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //SW
            if (!map.getSquare(penguinCol - 1, penguinRow + 1).getCollected() && !map.getSquare(penguinCol - 1, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //N
            if (!map.getSquare(penguinCol, penguinRow - 1).getCollected() && !map.getSquare(penguinCol, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //S
            if (!map.getSquare(penguinCol, penguinRow + 1).getCollected() && !map.getSquare(penguinCol, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //E
            if (!map.getSquare(penguinCol + 1, penguinRow).getCollected() && !map.getSquare(penguinCol + 1, penguinRow).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //W
            if (!map.getSquare(penguinCol - 1, penguinRow).getCollected() && !map.getSquare(penguinCol - 1, penguinRow).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
        } else if (penguinCol == 0 && penguinRow == 0) {

            //SE
            if (!map.getSquare(penguinCol + 1, penguinRow + 1).getCollected() && !map.getSquare(penguinCol + 1, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //E
            if (!map.getSquare(penguinCol + 1, penguinRow).getCollected() && !map.getSquare(penguinCol + 1, penguinRow).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //S
            if (!map.getSquare(penguinCol, penguinRow + 1).getCollected() && !map.getSquare(penguinCol, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }

        } else if (penguinCol == 9 && penguinRow == 0) {

            //SW
            if (!map.getSquare(penguinCol - 1, penguinRow + 1).getCollected() && !map.getSquare(penguinCol - 1, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //S
            if (!map.getSquare(penguinCol, penguinRow + 1).getCollected() && !map.getSquare(penguinCol, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //W
            if (!map.getSquare(penguinCol - 1, penguinRow).getCollected() && !map.getSquare(penguinCol - 1, penguinRow).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
        } else if (penguinCol == 0 && penguinRow == 5) {

            //NE
            if (!map.getSquare(penguinCol + 1, penguinRow - 1).getCollected() && !map.getSquare(penguinCol + 1, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //N
            if (!map.getSquare(penguinCol, penguinRow - 1).getCollected() && !map.getSquare(penguinCol, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //E
            if (!map.getSquare(penguinCol + 1, penguinRow).getCollected() && !map.getSquare(penguinCol + 1, penguinRow).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
        } else if (penguinCol == 9 && penguinRow == 5) {

            //NW
            if (!map.getSquare(penguinCol - 1, penguinRow - 1).getCollected() && !map.getSquare(penguinCol - 1, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //N
            if (!map.getSquare(penguinCol, penguinRow - 1).getCollected() && !map.getSquare(penguinCol, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //W
            if (!map.getSquare(penguinCol - 1, penguinRow).getCollected() && !map.getSquare(penguinCol - 1, penguinRow).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
        } else if (penguinCol == 0) {

            //NE
            if (!map.getSquare(penguinCol + 1, penguinRow - 1).getCollected() && !map.getSquare(penguinCol + 1, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //SE
            if (!map.getSquare(penguinCol + 1, penguinRow + 1).getCollected() && !map.getSquare(penguinCol + 1, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //N
            if (!map.getSquare(penguinCol, penguinRow - 1).getCollected() && !map.getSquare(penguinCol, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //S
            if (!map.getSquare(penguinCol, penguinRow + 1).getCollected() && !map.getSquare(penguinCol, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //E
            if (!map.getSquare(penguinCol + 1, penguinRow).getCollected() && !map.getSquare(penguinCol + 1, penguinRow).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }

        } else if (penguinCol == 9) {

            //NW
            if (!map.getSquare(penguinCol - 1, penguinRow - 1).getCollected() && !map.getSquare(penguinCol - 1, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //SW
            if (!map.getSquare(penguinCol - 1, penguinRow + 1).getCollected() && !map.getSquare(penguinCol - 1, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //N
            if (!map.getSquare(penguinCol, penguinRow - 1).getCollected() && !map.getSquare(penguinCol, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //S
            if (!map.getSquare(penguinCol, penguinRow + 1).getCollected() && !map.getSquare(penguinCol, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //W
            if (!map.getSquare(penguinCol - 1, penguinRow).getCollected() && !map.getSquare(penguinCol - 1, penguinRow).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
        } else if (penguinRow == 0) {

            //SE
            if (!map.getSquare(penguinCol + 1, penguinRow + 1).getCollected() && !map.getSquare(penguinCol + 1, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //SW
            if (!map.getSquare(penguinCol - 1, penguinRow + 1).getCollected() && !map.getSquare(penguinCol - 1, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //S
            if (!map.getSquare(penguinCol, penguinRow + 1).getCollected() && !map.getSquare(penguinCol, penguinRow + 1).getOrangePenguin() && !map.getSquare(penguinCol, penguinRow + 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //E
            if (!map.getSquare(penguinCol + 1, penguinRow).getCollected() && !map.getSquare(penguinCol + 1, penguinRow).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //W
            if (!map.getSquare(penguinCol - 1, penguinRow).getCollected() && !map.getSquare(penguinCol - 1, penguinRow).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
        } else if (penguinRow == 5) {

            //NE
            if (!map.getSquare(penguinCol + 1, penguinRow - 1).getCollected() && !map.getSquare(penguinCol + 1, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //NW
            if (!map.getSquare(penguinCol - 1, penguinRow - 1).getCollected() && !map.getSquare(penguinCol - 1, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //N
            if (!map.getSquare(penguinCol, penguinRow - 1).getCollected() && !map.getSquare(penguinCol, penguinRow - 1).getOrangePenguin() && !map.getSquare(penguinCol, penguinRow - 1).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //E
            if (!map.getSquare(penguinCol + 1, penguinRow).getCollected() && !map.getSquare(penguinCol + 1, penguinRow).getOrangePenguin() && !map.getSquare(penguinCol + 1, penguinRow).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
            //W
            if (!map.getSquare(penguinCol - 1, penguinRow).getCollected() && !map.getSquare(penguinCol - 1, penguinRow).getOrangePenguin() && !map.getSquare(penguinCol - 1, penguinRow).getYellowPenguin()) {
                anyMovesCanBeDone++;
            }
        }

        return anyMovesCanBeDone;
    }

    public void gameIsOver() {

        if (orangeScore > yellowScore) {
            orangeWins = true;
        } else if (orangeScore < yellowScore) {
            yellowWins = true;
        } else if (orangeScore == yellowScore) {
            orangeTieYellow = true;
        }

    }

}

