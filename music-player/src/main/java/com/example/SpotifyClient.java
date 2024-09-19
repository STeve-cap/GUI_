package com.example;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SpotifyClient {
    private static final String BASE_URL = "https://api.spotify.com/";
    private static SpotifyService spotifyService;

    public static SpotifyService getSpotifyService() {
        if (spotifyService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            spotifyService = retrofit.create(SpotifyService.class);
        }
        return spotifyService;
    }
}


