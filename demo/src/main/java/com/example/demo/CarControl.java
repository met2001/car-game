package com.example.demo;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class CarControl implements Initializable {

    AnimationTimer gameLoop;

    Time time = new Time(0);

    @FXML
    private ImageView shape1;

    @FXML
    private TextField timer;

    @FXML
    private AnchorPane plane;

    private ObstacleHandler obstacleHandler;
    private boolean aPressed = false;
    private boolean dPressed = false;
    private int movementVariable = 6;
    private double speedFactor = 4;
    private final double speedIncrement = 2;
    private String score = "0";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        obstacleHandler = new ObstacleHandler(plane);  // Initialize obstacle queue with 10 preloaded obstacles
        Listener();

        // Initialize and start the game loop
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
            }
        };
        gameLoop.start();

        // Start obstacle spawning timer

        timer.setText(time.getCarTime());
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        collision.start();
    }

    private void update() {
        if (speedFactor < 30) {
            speedFactor += speedIncrement / 500;  // Gradual increase in speed
        }

        // Move and remove off-screen obstacles
        obstacleHandler.removeObstacles(speedFactor);

        // Move player car based on user input
        if (dPressed && shape1.getLayoutX() < 365) {
            shape1.setLayoutX(shape1.getLayoutX() + movementVariable);
        }

        if (aPressed && shape1.getLayoutX() > 155) {
            shape1.setLayoutX(shape1.getLayoutX() - movementVariable);
        }
    }

    public void Listener() {
        plane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                aPressed = true;
            }

            if (e.getCode() == KeyCode.D) {
                dPressed = true;
            }
        });

        plane.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.A) {
                aPressed = false;
            }

            if (e.getCode() == KeyCode.D) {
                dPressed = false;
            }
        });
    }

    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1),
                    event -> {
                        time.oneSecondPassed();
                        timer.setText(time.getCarTime());
                        obstacleHandler.spawnObstacle();
                        obstacleHandler.spawnObstacle();
                    })
    );

    AnimationTimer collision = new AnimationTimer() {
        @Override
        public void handle(long b) {
            for (ImageView obstacle : obstacleHandler.getActiveObstacles()) {
                checkCollision(shape1, obstacle);
            }
        }
    };

    public String checkCollision(ImageView shape1, ImageView obstacle) {
        if (shape1.getBoundsInParent().intersects(obstacle.getBoundsInParent())) {
            score = time.getCarTime();
            Player highScore = new Player(Integer.parseInt(String.valueOf(score)),"highscore");
            gameLoop.stop();
            timeline.stop();
            try{
                highScore.createFile();
            } catch (Exception e){
                System.out.println(e);
            }finally {
                if(Integer.parseInt(score) > highScore.getPlayerData()){
                    highScore.saveData();
                    System.out.println("New Highscore!");
                }
                else{
                    System.out.println("Score is less than the highschore");
                }
            }

        }
        return score;
    }

}
