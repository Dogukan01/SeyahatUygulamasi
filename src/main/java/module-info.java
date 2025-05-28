module org.example.Seyahat_Planlama {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires jdk.jsobject;
    requires com.fasterxml.jackson.databind;


    opens org.example.Seyahat_Planlama to javafx.fxml;
    exports org.example.Seyahat_Planlama;
}