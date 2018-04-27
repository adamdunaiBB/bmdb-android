package hu.blackbelt.bmdb_android.grid;

import java.util.List;

import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public interface GridView {

    void setMovies(List<MovieDataModel> movies);
}
