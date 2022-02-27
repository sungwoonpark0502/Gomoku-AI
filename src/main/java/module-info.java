module com.example.omok {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens com.example.omok to javafx.fxml;
    exports com.example.omok;
}