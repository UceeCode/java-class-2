module com.example.xmldoccreatorr {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.xmldoccreatorr to javafx.fxml;
    exports com.example.xmldoccreatorr;
}