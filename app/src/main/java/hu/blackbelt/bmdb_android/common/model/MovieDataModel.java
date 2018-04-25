package hu.blackbelt.bmdb_android.common.model;


import android.support.annotation.DrawableRes;

import java.io.Serializable;

public class MovieDataModel implements Serializable {

    private final String title;
    private final int year;
    private final String genre;
    private final String description;

    @DrawableRes
    private final int imageResId;

    public MovieDataModel(String title, int year, String genre, String description, @DrawableRes int imageResId) {
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
