package org.example.flappybird;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public class GameController {

    @FXML
    private AnchorPane root;

    @FXML
    private Label scoreLabel;

    private Bird bird;

    private Pipe pipe1;
    private Pipe pipe2;
    private Pipe pipe3;

    private int score;

    private int highScore;

    private boolean gameEnded = false;

    private AnimationTimer timer;

    @FXML
    public void initialize() {

        Image backgroundImage = new Image (
                getClass ().getResourceAsStream (
                        "/Images/background1.png"
                )
        );

        ImageView background = new ImageView (backgroundImage);

        background.setFitWidth (800);
        background.setFitHeight (600);

        root.getChildren ().add (0, background);

        bird = new Bird ();

        highScore = HighScore.load ();

        pipe1 = new Pipe ();
        pipe2 = new Pipe ();
        pipe3 = new Pipe ();

        pipe1.getTopPipe ().setLayoutX (900);
        pipe1.getBottomPipe ().setLayoutX (900);

        pipe2.getTopPipe ().setLayoutX (1300);
        pipe2.getBottomPipe ().setLayoutX (1300);

        pipe3.getTopPipe ().setLayoutX (1700);
        pipe3.getBottomPipe ().setLayoutX (1700);

        pipe1.getTopPipe ().setRotate (180);
        pipe2.getTopPipe ().setRotate (180);
        pipe3.getTopPipe ().setRotate (180);

        root.getChildren ().addAll (pipe1.getTopPipe (), pipe1.getBottomPipe (), pipe2.getTopPipe (), pipe2.getBottomPipe (),pipe3.getTopPipe (), pipe3.getBottomPipe (), bird.getImageView ());
        root.setOnMouseClicked (e -> {
            bird.jump ();});
        Platform.runLater (() -> {
            root.getScene ().setOnKeyPressed (e -> {
                if (e.getCode () == KeyCode.SPACE) {
                    bird.jump ();
                }
            });
        });

        timer = new AnimationTimer () {

            @Override
            public void handle(long now) {

                bird.update ();

                updatePipe (pipe1);
                updatePipe (pipe2);
                updatePipe (pipe3);

                checkCollision (pipe1);
                checkCollision (pipe2);
                checkCollision (pipe3);

                scoreLabel.setText ("Рахунок: " + score);}};

        timer.start ();
    }

    private void updatePipe(Pipe pipe) {

        pipe.move (GameSettings.pipeSpeed);

        if (pipe.getTopPipe ().getLayoutX () < -100) {

            pipe.getTopPipe ().setLayoutX (900);
            pipe.getBottomPipe ().setLayoutX (900);

            pipe.randomize ();
        }

        if (!pipe.isPassed () && pipe.getTopPipe ().getLayoutX () < 200) {

            score++;

            pipe.setPassed (true);
        }
    }
    private void checkCollision(Pipe pipe) {
        if (bird.getImageView ().getBoundsInParent ().intersects (
                pipe.getTopPipe ().getBoundsInParent ())) {
            gameOver ();
        }
        if (bird.getImageView ().getBoundsInParent ().intersects (pipe.getBottomPipe ().getBoundsInParent ())) {
            gameOver ();
        } //перевіряє, чи пташка зіткнулася з трубою
    }
    private void gameOver() {
        if (gameEnded) {
            return;
        }
        gameEnded = true;
        timer.stop ();
        if (score > highScore) {
            highScore = score;
            HighScore.save (highScore);
        }
        Platform.runLater (() -> { //Після закінчення гри гра зупиняєтся
            // та виводе результат пройдених труб
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setHeaderText ("Гру завершено!");
            alert.setContentText ("Ваш результат: " + score + "\nРекорд: " + highScore);
            alert.showAndWait ();});
    }
}