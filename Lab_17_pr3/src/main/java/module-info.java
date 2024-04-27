module com.example.lab_17_pr3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_17_pr3 to javafx.fxml;
    exports com.example.lab_17_pr3;
}