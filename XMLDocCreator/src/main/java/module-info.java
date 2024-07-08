module com.example.xmldoccreator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.xmldoccreator to javafx.fxml;
    exports com.example.xmldoccreator;
}