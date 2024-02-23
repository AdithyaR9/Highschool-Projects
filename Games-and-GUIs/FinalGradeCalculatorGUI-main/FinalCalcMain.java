

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class FinalCalcMain extends Application {

    int terms;
    double gradeWanted;
    double finalWeight;
    double totalTermWeight;
    double totalGrade;
    double term1;
    double term2;
    double term3;
    double term4;
    double term5;
    boolean calculationPossible = true;
    double finalExamGradeNeeded;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 400, 800);

        Canvas c = new Canvas(400, 800);

        Label lbl_TotalTermWeight = new Label("Total Term Weight");
        TextField txt_TotalTermWeight = new TextField();

        Label lbl_FinalWeight = new Label("Final Weight");
        TextField txt_FinalWeight = new TextField();

        Label lbl_GradeWanted = new Label("Grade Wanted");
        TextField txt_GradeWanted = new TextField();

        Label lbl_Term1Grade = new Label("Term 1 Grade");
        TextField txt_Term1Grade = new TextField();

        Label lbl_Term2Grade = new Label("Term 2 Grade");
        TextField txt_Term2Grade = new TextField();

        Label lbl_Term3Grade = new Label("Term 3 Grade");
        TextField txt_Term3Grade = new TextField();

        Label lbl_Term4Grade = new Label("Term 4 Grade");
        TextField txt_Term4Grade = new TextField();

        Label lbl_Term5Grade = new Label("Term 5 Grade");
        TextField txt_Term5Grade = new TextField();

        Label lbl_numberTerms = new Label("Number of Terms");
        //ListView<Integer> lv_numberTerms = new ListView<>();
        TextField txt_numberTerms = new TextField();

        Button calculate = new Button("Calculate");
        Button clear = new Button("Clear");

        Label lbl_finalGradeNeeded = new Label("Grade Required on Final");
        TextField txt_finalGradeNeeded = new TextField();

        /////////////////////////////////////////////////////////////////////////////////////

        HBox hb_TotalTermWeight = new HBox();
        hb_TotalTermWeight.getChildren().addAll(lbl_TotalTermWeight, txt_TotalTermWeight);

        HBox hb_FinalWeight = new HBox();
        hb_FinalWeight.getChildren().addAll(lbl_FinalWeight, txt_FinalWeight);

        HBox hb_numberTerms = new HBox();
        hb_numberTerms.getChildren().addAll(lbl_numberTerms, txt_numberTerms);

        HBox hb_GradeWanted = new HBox();
        hb_GradeWanted.getChildren().addAll(lbl_GradeWanted, txt_GradeWanted);

        HBox hb_Term1Grade = new HBox();
        hb_Term1Grade.getChildren().addAll(lbl_Term1Grade, txt_Term1Grade);

        HBox hb_Term2Grade = new HBox();
        hb_Term2Grade.getChildren().addAll(lbl_Term2Grade, txt_Term2Grade);

        HBox hb_Term3Grade = new HBox();
        hb_Term3Grade.getChildren().addAll(lbl_Term3Grade, txt_Term3Grade);

        HBox hb_Term4Grade = new HBox();
        hb_Term4Grade.getChildren().addAll(lbl_Term4Grade, txt_Term4Grade);

        HBox hb_Term5Grade = new HBox();
        hb_Term5Grade.getChildren().addAll(lbl_Term5Grade, txt_Term5Grade);

        HBox hb_calculate = new HBox();
        hb_calculate.getChildren().addAll(calculate);

        HBox hb_clear = new HBox();
        hb_clear.getChildren().addAll(clear);

        HBox hb_finalGradeNeeded = new HBox();
        hb_clear.getChildren().addAll(lbl_finalGradeNeeded, txt_finalGradeNeeded);

        VBox vb_AllHBoxes = new VBox();
        vb_AllHBoxes.getChildren().addAll(hb_TotalTermWeight, hb_FinalWeight, hb_numberTerms, hb_GradeWanted, hb_Term1Grade, hb_Term2Grade, hb_Term3Grade, hb_Term4Grade, hb_Term5Grade, hb_calculate, hb_clear, hb_finalGradeNeeded);
        vb_AllHBoxes.setSpacing(30);
        vb_AllHBoxes.setPadding(new Insets(20, 30, 50, 30));


        group.getChildren().addAll(vb_AllHBoxes);

        primaryStage.setScene(scene);

        calculate.setOnAction(event -> {
            if (!txt_TotalTermWeight.getText().equals("") && !txt_FinalWeight.getText().equals("") &&
                    (parseInt(txt_numberTerms.getText()) > 0 && parseInt(txt_numberTerms.getText()) < 6) && !txt_GradeWanted.getText().equals("")) {

                terms = parseInt(txt_numberTerms.getText());
                totalTermWeight = (parseDouble(txt_TotalTermWeight.getText())) / 100;
                finalWeight = (parseDouble(txt_FinalWeight.getText())) / 100;
                gradeWanted = (parseDouble(txt_GradeWanted.getText())) / 100;

                if (!txt_Term1Grade.getText().equals("") && parseInt(txt_numberTerms.getText()) == 1) {
                    term1 = parseDouble(txt_Term1Grade.getText());
                    totalGrade = term1 / 100;
                } else if (!txt_Term1Grade.getText().equals("") && !txt_Term2Grade.getText().equals("") && parseInt(txt_numberTerms.getText()) == 2) {
                    term1 = parseDouble(txt_Term1Grade.getText());
                    term2 = parseDouble(txt_Term2Grade.getText());
                    totalGrade = ((term1 + term2) / 2) / 100;
                } else if (!txt_Term1Grade.getText().equals("") && !txt_Term2Grade.getText().equals("") && !txt_Term3Grade.getText().equals("") && parseInt(txt_numberTerms.getText()) == 3) {
                    term1 = parseDouble(txt_Term1Grade.getText());
                    term2 = parseDouble(txt_Term2Grade.getText());
                    term3 = parseDouble(txt_Term3Grade.getText());
                    totalGrade = ((term1 + term2 + term3) / 3) / 100;
                } else if (!txt_Term1Grade.getText().equals("") && !txt_Term2Grade.getText().equals("") && !txt_Term3Grade.getText().equals("") && !txt_Term4Grade.getText().equals("") && parseInt(txt_numberTerms.getText()) == 4) {
                    term1 = parseDouble(txt_Term1Grade.getText());
                    term2 = parseDouble(txt_Term2Grade.getText());
                    term3 = parseDouble(txt_Term3Grade.getText());
                    term4 = parseDouble(txt_Term4Grade.getText());
                    totalGrade = ((term1 + term2 + term3 + term4) / 4) / 100;
                } else if (!txt_Term1Grade.getText().equals("") && !txt_Term2Grade.getText().equals("") && !txt_Term3Grade.getText().equals("") && !txt_Term4Grade.getText().equals("") && !txt_Term5Grade.getText().equals("") && parseInt(txt_numberTerms.getText()) == 5) {
                    term1 = parseDouble(txt_Term1Grade.getText());
                    term2 = parseDouble(txt_Term2Grade.getText());
                    term3 = parseDouble(txt_Term3Grade.getText());
                    term4 = parseDouble(txt_Term4Grade.getText());
                    term5 = parseDouble(txt_Term5Grade.getText());
                    totalGrade = ((term1 + term2 + term3 + term4 + term5) / 5) / 100;
                } else {
                    calculationPossible = false;
                }


                if (calculationPossible) {
                    finalExamGradeNeeded = ((1 * gradeWanted - (totalTermWeight) * totalGrade) / finalWeight) * 100;
                    txt_TotalTermWeight.setText("");
                    txt_FinalWeight.setText("");
                    txt_GradeWanted.setText("");
                    txt_numberTerms.setText("");
                    txt_Term1Grade.setText("");
                    txt_Term2Grade.setText("");
                    txt_Term3Grade.setText("");
                    txt_Term4Grade.setText("");
                    txt_Term5Grade.setText("");
                    txt_finalGradeNeeded.setText("" + finalExamGradeNeeded);
                }

            }

        });

        clear.setOnAction(event -> {
            txt_TotalTermWeight.setText("");
            txt_FinalWeight.setText("");
            txt_GradeWanted.setText("");
            txt_numberTerms.setText("");
            txt_Term1Grade.setText("");
            txt_Term2Grade.setText("");
            txt_Term3Grade.setText("");
            txt_Term4Grade.setText("");
            txt_Term5Grade.setText("");
            txt_finalGradeNeeded.setText("");
            totalTermWeight = 0;
            finalWeight = 0;
            gradeWanted = 0;
            terms = 0;
            term5 = 0;
            term4 = 0;
            term3 = 0;
            term2 = 0;
            term1 = 0;
            finalExamGradeNeeded = 0;
        });

        primaryStage.show();
    }

}

