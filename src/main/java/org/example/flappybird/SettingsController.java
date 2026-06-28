package org.example.flappybird;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class SettingsController {

    @FXML
    private ComboBox<String> difficultyBox;

    @FXML
    public void initialize() {

        difficultyBox.getItems ().addAll (
                "Easy",
                "Normal",
                "Hard"
        );

        difficultyBox.setValue (
                GameSettings.difficulty
        );
    }

    @FXML
    private void saveSettings() {

        GameSettings.difficulty =
                difficultyBox.getValue ();

        switch (GameSettings.difficulty) {

            case "Easy":
                GameSettings.pipeSpeed = 2;
                break;

            case "Hard":
                GameSettings.pipeSpeed = 5;
                break;

            default:
                GameSettings.pipeSpeed = 3;
                break;
        }
    }

    @FXML
    private void backToMenu() throws Exception {

        FXMLLoader loader = new FXMLLoader (
                HelloApplication.class.getResource (
                        "menu-view.fxml"
                )
        );

        Scene scene = new Scene (
                loader.load (),
                800,
                600
        );

        Stage stage =
                (Stage) Stage.getWindows ().get (0);

        stage.setScene (scene);
    }
}