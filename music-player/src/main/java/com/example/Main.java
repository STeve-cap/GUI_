package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Music Player");

        // Simple UI for now
        Button loginButton = new Button("Login to Spotify");
        Button fetchMusicButton = new Button("Fetch Music");

        // Layout
        VBox layout = new VBox(20);
        layout.getChildren().addAll(loginButton, fetchMusicButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

