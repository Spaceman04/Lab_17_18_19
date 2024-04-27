module com.example.lab_17_14 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.lab_17_14 to javafx.fxml;
    exports com.example.lab_17_14;
}