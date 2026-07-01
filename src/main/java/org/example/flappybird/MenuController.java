package org.example.flappybird;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class MenuController {
    @FXML
    private void startGame() throws Exception {
        FXMLLoader loader = new FXMLLoader (
                HelloApplication.class.getResource ("game-view.fxml"));
        Scene scene = new Scene (loader.load (), 800, 600);
        Stage stage = (Stage) Stage.getWindows ().get (0);
        stage.setScene (scene);
    }
    @FXML
    private void openSettings() throws Exception {
        FXMLLoader loader = new FXMLLoader (
                HelloApplication.class.getResource ("settings-view.fxml"));
        Scene scene = new Scene (
                loader.load (), 800, 600);
        Stage stage = (Stage) Stage.getWindows ().get (0);
        stage.setScene (scene);
    }
    @FXML
    private void exitGame() {
        Stage stage = (Stage) Stage.getWindows ().get (0);
        stage.close ();
    }
} //тут реалізованні усі кнопки, коли користувач нажимае на одну, то викликается метод