module com.example.lab_17_prim2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_17_prim2 to javafx.fxml;
    exports com.example.lab_17_prim2;
}