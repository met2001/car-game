package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Parent startMenu = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));

        Scene menu = new Scene(startMenu);

        stage.setTitle("Start");
        stage.setScene(menu);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
