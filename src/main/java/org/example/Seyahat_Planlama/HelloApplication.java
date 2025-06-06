package org.example.Seyahat_Planlama;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800,600);
        WebView webView = (WebView) scene.lookup("#webView");
        webView.getEngine().load(getClass().getResource("/org/example/Seyahat_Planlama/map.html").toExternalForm());

        stage.setTitle("Seyahat Uygulaması");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}