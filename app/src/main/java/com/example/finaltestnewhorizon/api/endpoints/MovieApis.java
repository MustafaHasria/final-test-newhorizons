package com.example.finaltestnewhorizon.api.endpoints;


import com.example.finaltestnewhorizon.model.home.response.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApis {
    String SHOW_ALL = "shows";
    

    @GET(SHOW_ALL)
    Call<List<MovieResponse>> getMovies();
}
