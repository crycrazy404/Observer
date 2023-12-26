module com.example.smuliknulik {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.smuliknulik to javafx.fxml;
    exports com.example.smuliknulik;
}