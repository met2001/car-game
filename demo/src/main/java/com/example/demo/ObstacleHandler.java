package com.example.demo;

import javafx.scene.layout.AnchorPane;
import java.util.*;

public class ObstacleHandler {
    private AnchorPane plane;
    private Queue<Obstacles> obstacleQueue = new LinkedList<>();
    private ArrayList<Obstacles> activeObstacles = new ArrayList<>();

    public ObstacleHandler(AnchorPane plane) {
        this.plane = plane;
        loadObstacles();
    }

    public void loadObstacles() {
        for (int i = 0; i < 10; i++) {
            Obstacles obstacles = new Obstacles(42, 78, -71);
            obstacleQueue.add(obstacles);
        }
    }

    public void spawnObstacle() {

        if (obstacleQueue.isEmpty()) {
            loadObstacles();
        }
        else {
            Obstacles obstacle = obstacleQueue.poll();
            plane.getChildren().add(obstacle);
            activeObstacles.add(obstacle);
        }
    }

    public void removeObstacles(double speedFactor) {
        Iterator<Obstacles> iterator = activeObstacles.iterator();

        while (iterator.hasNext()) {
            Obstacles obstacle = iterator.next();
            obstacle.setLayoutY(obstacle.getLayoutY() + speedFactor);

            if (obstacle.getLayoutY() > plane.getHeight()) {
                plane.getChildren().remove(obstacle);
                obstacle.setLayoutY(-71);
                obstacleQueue.add(obstacle);
                iterator.remove();
            }
        }
    }

    public ArrayList<Obstacles> getActiveObstacles() {
        return activeObstacles;
    }
}
