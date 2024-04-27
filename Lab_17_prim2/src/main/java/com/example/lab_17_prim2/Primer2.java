package com.example.lab_17_prim2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Primer2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root,300,275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}