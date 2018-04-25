package hu.blackbelt.bmdb_android.main;


import java.util.List;

import hu.blackbelt.bmdb_android.model.Movie;

public interface MoviesInteractor {

    interface OnFinishedListener {
        void onFinished(List<Movie> movies);
    }

    void getItems(OnFinishedListener listener);
}
