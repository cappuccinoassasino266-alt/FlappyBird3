package org.example.flappybird;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader (
                HelloApplication.class.getResource ("menu-view.fxml"));
        Scene scene = new Scene (loader.load (), 800, 600);
        stage.setTitle ("Flappy Bird");
        stage.setScene (scene);
        stage.show ();
    }
    public static void main(String[] args) {
        launch ();
    }
}