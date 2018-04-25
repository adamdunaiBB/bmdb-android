package hu.blackbelt.bmdb_android.model;


import org.androidannotations.annotations.res.DrawableRes;

import java.io.Serializable;

public class Movie implements Serializable {

    private String title;
    private int year;
    private String description;

    //@DrawableRes
    private int imageResId;

    public Movie(String title, int year, String description, int imageResId) {
        this.title = title;
        this.year = year;
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }
}
