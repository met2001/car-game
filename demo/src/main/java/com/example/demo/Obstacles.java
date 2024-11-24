package com.example.demo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Obstacles extends ImageView {

    public Obstacles(int width, int height, int yPos) {
        // Set a random image
        this.setImage(setImage());
        // Set dimensions
        this.setFitWidth(width);
        this.setFitHeight(height);
        // Set position
        this.setLayoutX(getXPos());
        this.setLayoutY(yPos);
    }


    public int getXPos() {
        int[] xPos = new int[3];
        xPos[0] = 176;
        xPos[1] = 259;
        xPos[2] = 340;

        int randInt = (int)(Math.random() * 3);

        return xPos[randInt];
    }

    public Image setImage() {
        Image[] carImage = new Image[4];
        carImage[0]= (new Image(String.valueOf(getClass().getResource("/com/example/demo/blueCar.png"))));
        carImage[1] = (new Image(String.valueOf(getClass().getResource("/com/example/demo/greenCar.png"))));
        carImage[2] = (new Image(String.valueOf(getClass().getResource("/com/example/demo/whiteCar.png"))));
        carImage[3] = (new Image(String.valueOf(getClass().getResource("/com/example/demo/redCar.png"))));

        int randInt = (int)(Math.random() * 4);

        return carImage[randInt];
    }
}

