package com.example.lab_17;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Primer1 extends Application {
    @Override
    public void start(Stage stage){
        Text text = new Text("Hello from JavaFX!");
        text.setLayoutY(80);
        text.setLayoutX(100);

        Group group = new Group(text);

        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("First Application");
        stage.setWidth(300);
        stage.setHeight(250);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}