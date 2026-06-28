package org.example.flappybird;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;
public class Pipe {
    private ImageView topPipe;
    private ImageView bottomPipe;
    private boolean passed;
    public Pipe() {
        Image image = new Image (
                getClass ().getResourceAsStream ("/Images/pipe.png"));
        topPipe = new ImageView (image);
        bottomPipe = new ImageView (image);
        topPipe.setFitWidth (80);
        topPipe.setFitHeight (300);
        bottomPipe.setFitWidth (80);
        bottomPipe.setFitHeight (300);
        randomize ();
        passed = false;
    }
    public void randomize() {
        Random random = new Random ();
        int gapY = 180 + random.nextInt (140);
        topPipe.setLayoutY (gapY - 450);
        bottomPipe.setLayoutY (gapY + 170);
        passed = false;
    }
    public void move(double speed) {
        topPipe.setLayoutX (topPipe.getLayoutX () - speed);
        bottomPipe.setLayoutX (bottomPipe.getLayoutX () - speed );
    }
    public ImageView getTopPipe() {
        return topPipe;
    }
    public ImageView getBottomPipe() {
        return bottomPipe;
    }
    public boolean isPassed() {
        return passed;
    }
    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}