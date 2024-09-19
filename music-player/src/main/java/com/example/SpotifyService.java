package com.example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface SpotifyService {
    @GET("v1/me/playlists")
    Call<PlaylistResponse> getUserPlaylists(@Header("Authorization") String token);
}