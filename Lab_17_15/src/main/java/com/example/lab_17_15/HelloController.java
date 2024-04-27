package com.example.lab_17_15;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private TextField text1;
    @FXML
    private Label label1;

    @FXML
    protected void clickPlus() {
        if(Integer.parseInt(text1.getText())==3){
            text1.setText(String.valueOf(3));
        }else {
            int plus;
            plus = Integer.parseInt(text1.getText()) + 1;
            text1.setText(String.valueOf(plus));
        }
    }
    @FXML
    protected void clickMinus(){
        if(Integer.parseInt(text1.getText())==-5){
            text1.setText(String.valueOf(-5));
        }else {
            int minus;
            minus = Integer.parseInt(text1.getText()) - 1;
            text1.setText(String.valueOf(minus));
        }
    }
}