package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Music Player");

        // Simple UI for now
        Button loginButton = new Button("Login to Spotify");
        Button fetchMusicButton = new Button("Fetch Music");

        loginButton.setOnAction(e -> {
         // Implement OAuth2 flow to get Spotify token
         String accessToken = getAccessToken(); // Replace with real token fetching
         SpotifyService spotifyService = SpotifyClient.getSpotifyService();
         
         spotifyService.getUserPlaylists("Bearer " + accessToken).enqueue(new Callback<PlaylistResponse>() {
             @Override
             public void onResponse(Call<PlaylistResponse> call, Response<PlaylistResponse> response) {
                 if (response.isSuccessful()) {
                     PlaylistResponse playlists = response.body();
                     System.out.println("Fetched playlists: " + playlists.getItems().size());
                 }
             }
     
             @Override
             public void onFailure(Call<PlaylistResponse> call, Throwable t) {
                 t.printStackTrace();
             }
         });
      });

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

