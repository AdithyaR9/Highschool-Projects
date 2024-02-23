

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//username: joejoe
//password: password123

public class LoginExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group = new Group();

        Scene scene = new Scene(group, 300, 300);

        Label lbl_userName = new Label("Username");
        TextField txt_username = new TextField();

        Label lbl_password = new Label("Password");
        TextField txt_password = new TextField();

        Button btn_login = new Button("Login");
        Button btn_close = new Button("Close");

        HBox hb_username = new HBox();
        hb_username.getChildren().addAll(lbl_userName, txt_username);
        hb_username.setSpacing(10);
        // hb_username.setPrefHeight(300);
        hb_username.setAlignment(Pos.CENTER);

        HBox hb_password = new HBox();
        hb_password.getChildren().addAll(lbl_password, txt_password);
        hb_password.setSpacing(10);
        //hb_password.setPrefWidth(300);
        hb_password.setAlignment(Pos.CENTER);


        VBox vb_rows = new VBox();
        vb_rows.getChildren().addAll(hb_username, hb_password, btn_login, btn_close);
        vb_rows.setSpacing(10);
        vb_rows.setAlignment(Pos.CENTER);
        vb_rows.setPrefHeight(scene.getHeight());


        group.getChildren().addAll(vb_rows);

        primaryStage.setScene(scene);

        btn_login.setOnAction(event -> {
            if (txt_username.getText().equals("joejoe") && txt_password.getText().equals("password123")) {
                new Alert(Alert.AlertType.INFORMATION, "Success").showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed Login").showAndWait();
            }
        });

        btn_close.setOnAction(event -> {
            primaryStage.close();
        });
        primaryStage.show();

    }
}
