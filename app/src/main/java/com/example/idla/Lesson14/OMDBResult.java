package com.example.idla.Lesson14;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OMDBResult
{
    @SerializedName("Search")
    public List<Movie> movieList;
    public String totalResults;
    public String Response;
}
