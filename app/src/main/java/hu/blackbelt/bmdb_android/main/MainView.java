package hu.blackbelt.bmdb_android.main;


import java.util.List;

import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public interface MainView {

    void setMovies(List<MovieDataModel> movies);
}
