package ru.mirea.fedulova.movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    @JsonProperty("title")
    private String title;

    @JsonProperty("year")
    private int year;

    @JsonProperty("cast")
    private List<String> cast;

    public Movie(){}

    public Movie(String title, int year, List<String> cast){
        this.title = title;
        this.year = year;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getCast(){
        return cast;
    }

    public int getCastSize() {
        return cast.size();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title=" + title +
                ", year='" + year + '\'' +
                ", cast=" + cast +
                '}';
    }

}
