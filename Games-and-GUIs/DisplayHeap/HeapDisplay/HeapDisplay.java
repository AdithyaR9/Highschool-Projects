package HeapDisplay;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HeapDisplay extends Application {

    Canvas canvas;
    MaxHeap<Integer> heap = new MaxHeap<Integer>();
    double X;
    double Y;


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Adithya's Heap Display");

        Group group = new Group();

        canvas = new Canvas(1000, 600);

        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                X = event.getX();
                Y = event.getY();

                if (heap.size() < 15) {
                    //selected 1
                    if ((X > 40 && X < 70) && (Y > 40 && Y < 70)) {
                        heap.add(1);
                    }
                    //selected 2
                    if ((X > 80 && X < 110) && (Y > 40 && Y < 70)) {
                        heap.add(2);
                    }
                    //selected 3
                    if ((X > 120 && X < 150) && (Y > 40 && Y < 70)) {
                        heap.add(3);
                    }
                    //selected 4
                    if ((X > 160 && X < 190) && (Y > 40 && Y < 70)) {
                        heap.add(4);
                    }
                    //selected 5
                    if ((X > 200 && X < 230) && (Y > 40 && Y < 70)) {
                        heap.add(5);
                    }
                    //selected 6
                    if ((X > 40 && X < 70) && (Y > 80 && Y < 110)) {
                        heap.add(6);
                    }
                    //selected 7
                    if ((X > 80 && X < 110) && (Y > 80 && Y < 110)) {
                        heap.add(7);
                    }
                    //selected 8
                    if ((X > 120 && X < 150) && (Y > 80 && Y < 110)) {
                        heap.add(8);
                    }
                    //selected 9
                    if ((X > 160 && X < 190) && (Y > 80 && Y < 110)) {
                        heap.add(9);
                    }
                    //selected 10
                    if ((X > 200 && X < 230) && (Y > 80 && Y < 110)) {
                        heap.add(10);
                    }
                    //selected 11
                    if ((X > 40 && X < 70) && (Y > 120 && Y < 150)) {
                        heap.add(11);
                    }
                    //selected 12
                    if ((X > 80 && X < 110) && (Y > 120 && Y < 150)) {
                        heap.add(12);
                    }
                    //selected 13
                    if ((X > 120 && X < 150) && (Y > 120 && Y < 150)) {
                        heap.add(13);
                    }
                    //selected 14
                    if ((X > 160 && X < 190) && (Y > 120 && Y < 150)) {
                        heap.add(14);
                    }
                    //selected 15
                    if ((X > 200 && X < 230) && (Y > 120 && Y < 150)) {
                        heap.add(15);
                    }
                    //selected 16
                    if ((X > 40 && X < 70) && (Y > 160 && Y < 190)) {
                        heap.add(16);
                    }
                    //selected 17
                    if ((X > 80 && X < 110) && (Y > 160 && Y < 190)) {
                        heap.add(17);
                    }
                    //selected 18
                    if ((X > 120 && X < 150) && (Y > 160 && Y < 190)) {
                        heap.add(18);
                    }
                    //selected 19
                    if ((X > 160 && X < 190) && (Y > 160 && Y < 190)) {
                        heap.add(19);
                    }
                    //selected 20
                    if ((X > 200 && X < 230) && (Y > 160 && Y < 190)) {
                        heap.add(20);
                    }
                }
                //remove
                if ((X > 750 && X < 950) && (Y > 20 && Y < 95)) {
                    heap.remove();
                }

                System.out.println(X);
                System.out.println(Y);

                //print heap
                System.out.println(heap.toString());

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

    private void paint(GraphicsContext gc) {

        //background
        gc.setFill(Color.GRAY);
        gc.fillRect(0, 0, 1000, 600);

        //remove
        gc.setLineWidth(3);
        gc.setFill(Color.RED);
        gc.fillRect(750, 20, 200, 75);
        gc.strokeRect(750, 20, 200, 75);
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial", 40));
        gc.fillText("Remove", 775, 67.5);

        gc.setFont(new Font("Arial", 15));
        //1
        gc.strokeOval(40, 40, 30, 30);
        gc.fillText("1", 50, 60);
        //2
        gc.strokeOval(80, 40, 30, 30);
        gc.fillText("2", 90, 60);
        //3
        gc.strokeOval(120, 40, 30, 30);
        gc.fillText("3", 130, 60);
        //4
        gc.strokeOval(160, 40, 30, 30);
        gc.fillText("4", 170, 60);
        //5
        gc.strokeOval(200, 40, 30, 30);
        gc.fillText("5", 210, 60);
        //6
        gc.strokeOval(40, 80, 30, 30);
        gc.fillText("6", 50, 100);
        //7
        gc.strokeOval(80, 80, 30, 30);
        gc.fillText("7", 90, 100);
        //8
        gc.strokeOval(120, 80, 30, 30);
        gc.fillText("8", 130, 100);
        //9
        gc.strokeOval(160, 80, 30, 30);
        gc.fillText("9", 170, 100);
        //10
        gc.strokeOval(200, 80, 30, 30);
        gc.fillText("10", 205, 100);
        //11
        gc.strokeOval(40, 120, 30, 30);
        gc.fillText("11", 45, 140);
        //12
        gc.strokeOval(80, 120, 30, 30);
        gc.fillText("12", 85, 140);
        //13
        gc.strokeOval(120, 120, 30, 30);
        gc.fillText("13", 125, 140);
        //14
        gc.strokeOval(160, 120, 30, 30);
        gc.fillText("14", 165, 140);
        //15
        gc.strokeOval(200, 120, 30, 30);
        gc.fillText("15", 205, 140);
        //16
        gc.strokeOval(40, 160, 30, 30);
        gc.fillText("16", 45, 180);
        //17
        gc.strokeOval(80, 160, 30, 30);
        gc.fillText("17", 85, 180);
        //18
        gc.strokeOval(120, 160, 30, 30);
        gc.fillText("18", 125, 180);
        //19
        gc.strokeOval(160, 160, 30, 30);
        gc.fillText("19", 165, 180);
        //20
        gc.strokeOval(200, 160, 30, 30);
        gc.fillText("20", 205, 180);

        gc.setFont(new Font("Arial", 20));
        //tree
        if (heap.size() > 0) {
            if (0 < heap.size()) {
                gc.strokeRect(400, 50, 100, 45);
                gc.fillText(heap.get(0) + "", 440, 80);
            }
            if (14 < heap.size()) {
                gc.strokeRect(613, 325, 30, 30);
                gc.strokeLine(600,295,637,325);
                gc.fillText(heap.get(14) + "", 620, 347);
            }
            if (13 < heap.size()) {
                gc.strokeRect(553, 325, 30, 30);
                gc.strokeLine(600,295,560,325);
                gc.fillText(heap.get(13) + "", 560, 347);
            }
            if (12 < heap.size()) {
                gc.strokeRect(513, 325, 30, 30);
                gc.strokeLine(500,295,537,325);
                gc.fillText(heap.get(12) + "", 520, 347);
            }
            if (11 < heap.size()) {
                gc.strokeRect(453, 325, 30, 30);
                gc.strokeLine(500,295,460,325);
                gc.fillText(heap.get(11) + "", 460, 347);
            }
            if (10 < heap.size()) {
                gc.strokeRect(413, 325, 30, 30);
                gc.strokeLine(400,295,437,325);
                gc.fillText(heap.get(10) + "", 420, 347);
            }
            if (9 < heap.size()) {
                gc.strokeRect(353, 325, 30, 30);
                gc.strokeLine(400,295,360,325);
                gc.fillText(heap.get(9) + "", 360, 347);
            }
            if (8 < heap.size()) {
                gc.strokeRect(313, 325, 30, 30);
                gc.strokeLine(300,295,337,325);
                gc.fillText(heap.get(8) + "", 320, 347);
            }
            if (7 < heap.size()) {
                gc.strokeRect(253, 325, 30, 30);
                gc.strokeLine(300,295,260,325);
                gc.fillText(heap.get(7) + "", 260, 347);
            }
            if (6 < heap.size()) {
                gc.strokeRect(575, 250, 50, 45);
                gc.strokeLine(575,195,600,250);
                gc.fillText(heap.get(6) + "", 590, 280);
            }
            if (5 < heap.size()) {
                gc.strokeRect(475, 250, 50, 45);
                gc.strokeLine(525,195,500,250);
                gc.fillText(heap.get(5) + "", 490, 280);
            }
            if (4 < heap.size()) {
                gc.strokeRect(375, 250, 50, 45);
                gc.strokeLine(375,195,400,250);
                gc.fillText(heap.get(4) + "", 390, 280);
            }
            if (3 < heap.size()) {
                gc.strokeRect(275, 250, 50, 45);
                gc.strokeLine(325,195,300,250);
                gc.fillText(heap.get(3) + "", 290, 280);
            }
            if (2 < heap.size()) {
                gc.strokeRect(500, 150, 100, 45);
                gc.strokeLine(500,95,550,150);
                gc.fillText(heap.get(2) + "", 540, 180);
            }
            if (1 < heap.size()) {
                gc.strokeRect(300, 150, 100, 45);
                gc.strokeLine(400,95,350,150);
                gc.fillText(heap.get(1) + "", 340, 180);
            }

        }

    }

}





