package hu.blackbelt.bmdb_android.model;


import android.content.res.Resources;

import java.io.Serializable;

public class Movie implements Serializable {

    private String title;
    private int year;
    private String description;
    private Resources image;

    public Movie(String title, int year, String description, Resources image) {
        this.title = title;
        this.year = year;
        this.description = description;
        this.image = image;
    }
}
