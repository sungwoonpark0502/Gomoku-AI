module com.example.omok {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.omok to javafx.fxml;
    exports com.example.omok;
    exports com.example.omok.Omok;
    opens com.example.omok.Omok to javafx.fxml;
}