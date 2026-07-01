package org.example.flappybird;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Bird {
    private ImageView imageView;
    private double velocityY;
    public Bird() {
        Image image = new Image(
                getClass().getResourceAsStream("/Images/bird1.png"));
        imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setLayoutX(200);
        imageView.setLayoutY(250);
        velocityY = 0; // Писав Костя.
        // Це швидкість руху пташки по вертикалі,
        // якщо число відємне, то вона летить вгору, а якщо додатнє вниз
    }
    public void jump() {
        velocityY = -4.5;
    }
    public void update() {
        velocityY += 0.18;
        if (velocityY > 4) {
            velocityY = 4;
        }
        imageView.setLayoutY(
                imageView.getLayoutY() + velocityY);
        if (imageView.getLayoutY() < 0) {
            imageView.setLayoutY(0);
            velocityY = 0;
        }
        if (imageView.getLayoutY() > 550) {
            imageView.setLayoutY(550);
            velocityY = 0;
        }
    }
    public ImageView getImageView() {
        return imageView;
    }
    public double getY() {
        return imageView.getLayoutY();
    }
    public double getVelocityY() {
        return velocityY;
    }
    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }
}