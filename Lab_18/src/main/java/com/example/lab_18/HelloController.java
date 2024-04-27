package com.example.lab_18;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private Button button1;
    @FXML
    private TextArea textA;
    @FXML
    private TextField text1;
    @FXML
    protected void initialize(){
        button1.setDefaultButton(true);
    }
    @FXML
    protected void clickSend() {
        text1.requestFocus();
        textA.setText(textA.getText() + "Your message: " + text1.getText() + "\n");
        text1.setText("");
    }
}