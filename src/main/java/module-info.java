module com.example.omok {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.omok to javafx.fxml;
    exports com.example.omok;
}