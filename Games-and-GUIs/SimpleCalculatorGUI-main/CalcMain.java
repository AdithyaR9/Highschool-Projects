

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.lang.Double.parseDouble;

public class CalcMain extends Application {

    Button btn_zero = new Button("0");
    Button btn_one = new Button("1");
    Button btn_two = new Button("2");
    Button btn_three = new Button("3");
    Button btn_four = new Button("4");
    Button btn_five = new Button("5");
    Button btn_six = new Button("6");
    Button btn_seven = new Button("7");
    Button btn_eight = new Button("8");
    Button btn_nine = new Button("9");
    Button btn_equal = new Button("=");
    Button btn_plus = new Button("+");
    Button btn_minus = new Button("-");
    Button btn_multiply = new Button("*");
    Button btn_divide = new Button("/");
    Button btn_negativepositive = new Button("-/+");
    Button btn_clear = new Button("C");
    Button btn_decimal = new Button(". ");
    TextField textField = new TextField();
    TextField textField2 = new TextField();
    TextField textField3 = new TextField();
    String usingnumeral = "";
    double firstNum = -1;
    double secondNum = -1;
    String firstVal = "";
    String secondVal = "";
    String operation = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();

        Scene scene = new Scene(group, 350, 350);

        VBox vBoxA = new VBox();
        VBox vBoxB = new VBox();
        VBox vBoxC = new VBox();
        VBox vBoxD = new VBox();
        VBox vBoxE = new VBox();
        HBox hBoxA = new HBox();
        VBox vBoxBigBox = new VBox();
        HBox hBoxT = new HBox();
        HBox hBoxT2 = new HBox();

        btn_zero.setPrefSize(40, 40);
        btn_one.setPrefSize(40, 40);
        btn_two.setPrefSize(40, 40);
        btn_three.setPrefSize(40, 40);
        btn_four.setPrefSize(40, 40);
        btn_five.setPrefSize(40, 40);
        btn_six.setPrefSize(40, 40);
        btn_seven.setPrefSize(40, 40);
        btn_eight.setPrefSize(40, 40);
        btn_nine.setPrefSize(40, 40);
        btn_plus.setPrefSize(40, 40);
        btn_minus.setPrefSize(40, 40);
        btn_multiply.setPrefSize(40, 40);
        btn_divide.setPrefSize(40, 40);
        btn_equal.setPrefSize(40, 40);
        btn_clear.setPrefSize(40, 40);
        btn_negativepositive.setPrefSize(40, 40);
        btn_decimal.setPrefSize(40, 40);


        Canvas canvas = new Canvas(350, 350);

        vBoxA.getChildren().addAll(btn_equal, btn_one, btn_four, btn_seven);
        vBoxA.setPrefWidth(50);
        vBoxA.setSpacing(10);

        vBoxB.getChildren().addAll(btn_negativepositive, btn_two, btn_five, btn_eight);
        vBoxB.setPrefWidth(50);
        vBoxB.setSpacing(10);

        vBoxC.getChildren().addAll(btn_decimal, btn_three, btn_six, btn_nine);
        vBoxC.setPrefWidth(50);
        vBoxC.setSpacing(10);

        vBoxD.getChildren().addAll(btn_clear, btn_zero);
        vBoxD.setPrefWidth(50);
        vBoxD.setSpacing(10);

        vBoxE.getChildren().addAll(btn_plus, btn_minus, btn_multiply, btn_divide);
        vBoxE.setPrefWidth(50);
        vBoxE.setSpacing(10);

        hBoxT.getChildren().addAll(textField);
        hBoxT.setAlignment(Pos.TOP_CENTER);
        //hBoxT.setPrefSize(300,40);
        hBoxT.setPadding(new Insets(20, 20, 20, 20));

        hBoxT2.getChildren().addAll(textField2, textField3);
        hBoxT2.setAlignment(Pos.TOP_RIGHT);
        //hBoxT.setPrefSize(300,40);
        hBoxT2.setPadding(new Insets(20, 20, 10, 30));

        hBoxA.getChildren().addAll(vBoxA, vBoxB, vBoxC, vBoxD, vBoxE);
        hBoxA.setSpacing(10);
        vBoxA.setSpacing(10);

        vBoxBigBox.getChildren().addAll(hBoxT2, hBoxT, hBoxA);
        vBoxBigBox.setPrefWidth(scene.getWidth());
        vBoxBigBox.setPrefHeight(scene.getHeight());
        vBoxBigBox.setAlignment(Pos.BOTTOM_LEFT);
        vBoxBigBox.setPadding(new Insets(40, 40, 40, 40));

        group.getChildren().add(vBoxBigBox);

        primaryStage.setScene(scene);

        btn_clear.setOnAction(event -> {
            textField.setText("");
            textField2.setText("");
            textField3.setText("");
            firstVal = "";
            secondVal = "";
            usingnumeral = "";
        });
        btn_equal.setOnAction(event -> {
            if (textField.getText().length() == 1 && textField.getText().contains(".")) {

            } else {
                secondVal = textField.getText();
                if (operation.equals("add")) {
                    firstNum = parseDouble(firstVal);
                    secondNum = parseDouble(secondVal);
                    System.out.print("first =" + firstNum);
                    System.out.print("Second = " + secondNum);
                    firstNum = firstNum + secondNum;
                    firstVal = firstNum + "";
                    System.out.print("Solution =" + firstNum);
                    textField.setText("");
                    textField2.setText(firstVal);
                } else if (operation.equals("subtract")) {
                    firstNum = parseDouble(firstVal);
                    secondNum = parseDouble(secondVal);
                    System.out.print("first =" + firstNum);
                    System.out.print("Second = " + secondNum);
                    firstNum = firstNum - secondNum;
                    firstVal = firstNum + "";
                    System.out.print("Solution =" + firstNum);
                    textField.setText("");
                    textField2.setText(firstVal);
                } else if (operation.equals("multiply")) {
                    firstNum = parseDouble(firstVal);
                    secondNum = parseDouble(secondVal);
                    System.out.print("first =" + firstNum);
                    System.out.print("Second = " + secondNum);
                    firstNum = firstNum * secondNum;
                    firstVal = firstNum + "";
                    System.out.print("Solution =" + firstNum);
                    textField.setText("");
                    textField2.setText(firstVal);
                } else if (operation.equals("divide")) {
                    firstNum = parseDouble(firstVal);
                    secondNum = parseDouble(secondVal);
                    System.out.print("first =" + firstNum);
                    System.out.print("Second = " + secondNum);
                    firstNum = firstNum / secondNum;
                    firstVal = firstNum + "";
                    System.out.print("Solution =" + firstNum);
                    textField.setText("");
                    textField2.setText(firstVal);
                }
            }
        });
        btn_minus.setOnAction(event -> {
            if (textField.getText().length() == 1 && textField.getText().contains(".")) {

            } else {
                secondVal = textField.getText();
                if (firstVal.equals("") && !textField.getText().equals("")) {
                    firstVal = textField.getText();
                    textField3.setText("-");
                    operation = "subtract";
                    textField.setText("");
                    textField2.setText(firstVal);
                } else if (!firstVal.equals("") && operation != "" && !secondVal.equals("")) {
                    if (operation.equals("add")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum + secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    } else if (operation.equals("subtract")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum - secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    } else if (operation.equals("multiply")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum * secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    } else if (operation.equals("divide")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum / secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    }
                } else if (!firstVal.equals("") && operation != "") {
                    textField3.setText("-");
                    operation = "subtract";
                }
            }
        });
        btn_plus.setOnAction(event -> {
            if (textField.getText().length() == 1 && textField.getText().contains(".")) {

            } else {
                secondVal = textField.getText();
                if (firstVal.equals("") && !textField.getText().equals("")) {
                    firstVal = textField.getText();
                    textField3.setText("+");
                    operation = "add";
                    textField.setText("");
                    textField2.setText(firstVal);
                } else if (!firstVal.equals("") && operation != "" && !secondVal.equals("")) {
                    if (operation.equals("add")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum + secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    } else if (operation.equals("subtract")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum - secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    } else if (operation.equals("multiply")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum * secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    } else if (operation.equals("divide")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum / secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    }
                } else if (!firstVal.equals("") && operation != "") {
                    textField3.setText("+");
                    operation = "add";
                }
            }
        });
        btn_divide.setOnAction(event -> {
            if (textField.getText().length() == 1 && textField.getText().contains(".")) {

            } else {
                secondVal = textField.getText();
                if (firstVal.equals("") && !textField.getText().equals("")) {
                    firstVal = textField.getText();
                    textField3.setText("/");
                    operation = "divide";
                    textField.setText("");
                    textField2.setText(firstVal);
                } else if (!firstVal.equals("") && operation != "" && !secondVal.equals("")) {
                    if (operation.equals("add")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum + secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    } else if (operation.equals("subtract")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum - secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    } else if (operation.equals("multiply")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum * secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    } else if (operation.equals("divide")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum / secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    }
                } else if (!firstVal.equals("") && operation != "") {
                    textField3.setText("/");
                    operation = "divide";
                }
            }
        });
        btn_multiply.setOnAction(event -> {
            if (textField.getText().length() == 1 && textField.getText().contains(".")) {

            } else {
                secondVal = textField.getText();
                if (firstVal.equals("") && !textField.getText().equals("")) {
                    firstVal = textField.getText();
                    textField3.setText("*");
                    operation = "multiply";
                    textField.setText("");
                    textField2.setText(firstVal);
                } else if (!firstVal.equals("") && operation != "" && !secondVal.equals("")) {
                    if (operation.equals("add")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum + secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    } else if (operation.equals("subtract")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum - secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    } else if (operation.equals("multiply")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum * secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    } else if (operation.equals("divide")) {
                        firstNum = parseDouble(firstVal);
                        secondNum = parseDouble(secondVal);
                        firstNum = firstNum / secondNum;
                        firstVal = firstNum + "";
                        textField.setText("");
                        textField2.setText(firstVal);
                    }
                } else if (!firstVal.equals("") && operation != "") {
                    textField3.setText("*");
                    operation = "multiply";
                }
            }
        });
        btn_negativepositive.setOnAction(event -> {
            if (textField.getText().substring(0, 1).equals("-")) {
                textField.setText(textField.getText().substring(1));
            } else {
                textField.setText("-" + textField.getText());
            }
        });
        btn_decimal.setOnAction(event -> {
            if (!textField.getText().contains("."))
                textField.setText(textField.getText() + ".");
        });
        btn_zero.setOnAction(event -> {
            textField.setText(textField.getText() + "0");
        });
        btn_one.setOnAction(event -> {
            textField.setText(textField.getText() + "1");
        });
        btn_two.setOnAction(event -> {
            textField.setText(textField.getText() + "2");
        });
        btn_three.setOnAction(event -> {
            textField.setText(textField.getText() + "3");
        });
        btn_four.setOnAction(event -> {
            textField.setText(textField.getText() + "4");
        });
        btn_five.setOnAction(event -> {
            textField.setText(textField.getText() + "5");
        });
        btn_six.setOnAction(event -> {
            textField.setText(textField.getText() + "6");
        });
        btn_seven.setOnAction(event -> {
            textField.setText(textField.getText() + "7");
        });
        btn_eight.setOnAction(event -> {
            textField.setText(textField.getText() + "8");
        });
        btn_nine.setOnAction(event -> {
            textField.setText(textField.getText() + "9");
        });

        primaryStage.show();

    }
}








