package ru.mirea.fedulova.movies;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface MoviesService {
    @GET("/prust/wikipedia-movie-data/master/movies.json")
    Call<List<Movie>> getMovies();
}
