module com.mahaney.cis296project3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cis296project3 to javafx.fxml;
    exports com.example.cis296project3;
}