package com.example.idla.Lesson14;

import com.google.gson.annotations.SerializedName;

public class Movie
{
    @SerializedName("Title")
    public String title;
    @SerializedName("Year")
    public String year;
    public String imdbID;
    @SerializedName("Poster")
    public String poster;

    public String getTotalInfo()
    {
        return  "imdbID: " + imdbID + "\n" +
                "Title: " + title + "\n" +
                "Year: " + year + "\n" +
                "Poster: " + poster + "\n\n\n";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
