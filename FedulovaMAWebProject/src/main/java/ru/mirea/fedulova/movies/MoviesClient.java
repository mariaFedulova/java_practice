package ru.mirea.fedulova.movies;

import com.fasterxml.jackson.databind.json.JsonMapper;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MoviesClient {
    static int MAX_YEAR = 2000;
    public static void main(String[] args) throws IOException, SQLException {
        Retrofit client = new Retrofit
                .Builder()
                .baseUrl("https://raw.githubusercontent.com")
                .addConverterFactory(JacksonConverterFactory.create(new JsonMapper()))
                .build();

        MoviesService moviesService = client.create(MoviesService.class);

        Response<List<Movie>> response = moviesService.getMovies().execute();

        List<Movie> movies= response.body();
        Optional<Movie> maxCastMovie = movies.stream()
                .filter(movie -> movie.getYear() < MAX_YEAR)
                .max(Comparator.comparingInt(Movie::getCastSize));

        if(maxCastMovie.isPresent()){
            System.out.println("Фильм с самым большим кастом:");
            System.out.printf("\tНазвание: %s \n", maxCastMovie.get().getTitle());
            System.out.printf("\tГод выпуска: %d\n", maxCastMovie.get().getYear());
            System.out.printf("\tКоличество актеров: %d\n", maxCastMovie.get().getCastSize());
            System.out.printf("\tКаст: %s", maxCastMovie.get().getCast());
        }
    }
}
