module com.mahaney.cis296project3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mahaney.cis296project3 to javafx.fxml;
    exports com.mahaney.cis296project3;
}