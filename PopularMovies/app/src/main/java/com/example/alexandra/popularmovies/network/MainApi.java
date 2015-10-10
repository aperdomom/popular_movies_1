package com.example.alexandra.popularmovies.network;

import com.example.alexandra.popularmovies.network.responses.MoviesListResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Alexandra on 29-09-2015.
 */
public interface MainApi {

    @GET("/movie/popular")
    void getMoviesPopular(@Query("api_key")String apiKey,
                          Callback<MoviesListResponse> callback);

    @GET("/movie/{ID}/images")
    void getMovieImages(@Path("ID")String showId,
                        Callback<MoviesListResponse> callback);

}
