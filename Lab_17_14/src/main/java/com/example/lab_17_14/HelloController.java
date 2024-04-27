package com.example.lab_17_14;

import java.math.BigInteger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;

public class HelloController {
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private TextField sumText;
    @FXML
    private Label label1;
    @FXML
    protected void clickCalculate(ActionEvent button1) {
        try {

            int num1;
            int num2;
            int sum1;
            num1 = Integer.parseInt(text1.getText());
            num2 = Integer.parseInt(text2.getText());
            sum1 = num1 + num2;
            sumText.setText(String.valueOf(sum1));
            label1.setText("");
        }catch (NumberFormatException ex){
            label1.setText("Invalid Number");
        }
    }
    @FXML
    protected void clickClear(ActionEvent button2) {
        text1.setText("");
        text2.setText("");
        sumText.setText("");
        label1.setText("");
    }
}