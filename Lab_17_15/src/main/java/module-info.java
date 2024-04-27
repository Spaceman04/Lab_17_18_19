module com.example.lab_17_15 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_17_15 to javafx.fxml;
    exports com.example.lab_17_15;
}