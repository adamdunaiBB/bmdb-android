package hu.blackbelt.bmdb_android.model;


import java.io.Serializable;

public class Movie implements Serializable {

    private String title;
    private int year;
    private String genre;
    private String description;

    //@DrawableRes
    private int imageResId;

    public Movie(String title, int year, String genre, String description, int imageResId) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getDescription() {
        return description;
    }
}
