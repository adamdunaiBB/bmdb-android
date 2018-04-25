package hu.blackbelt.bmdb_android.about;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import hu.blackbelt.bmdb_android.R;
import hu.blackbelt.bmdb_android.model.Movie;

@EActivity(R.layout.activity_about)
public class AboutActivity extends AppCompatActivity implements AboutView{

    @ViewById(R.id.about_title)
    TextView title;

    @ViewById(R.id.about_image)
    ImageView imageView;

    @ViewById(R.id.about_year)
    TextView year;

    @ViewById(R.id.about_genre)
    TextView genre;

    @ViewById(R.id.about_description)
    TextView description;

    @Extra("clickPosition")
    void clickPosition(int position) { this.i = position; }

    private AboutPresenter aboutPresenter;
    private int i;

    @AfterViews
    void afterViews() {
        aboutPresenter = new AboutPresenterImpl(this, new AboutInteractorImpl(), i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        aboutPresenter.onResume();
    }

    @Override
    public void setMovie(Movie movie) {
        title.setText(movie.getTitle());
        imageView.setImageResource(movie.getImageResId());
        year.setText(String.format("Year: %s", Integer.toString(movie.getYear())));
        genre.setText(String.format("Genre: %s", movie.getGenre()));
        description.setText(movie.getDescription());
    }
}
