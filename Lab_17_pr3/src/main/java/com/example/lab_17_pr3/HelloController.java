package com.example.lab_17_pr3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Label labelForButtons;

    @FXML
    protected void clickButton1(ActionEvent eventOne) {
        labelForButtons.setText("Clicked Button1");
    }
    @FXML
    protected void clickButton2(ActionEvent eventTwo) {
        labelForButtons.setText("Clicked Button2");
    }
    @FXML
    protected void clickButton3(ActionEvent eventThree) {
        labelForButtons.setText("Clicked Button3");
    }

}