module com.example.lab_17 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_17 to javafx.fxml;
    exports com.example.lab_17;
}