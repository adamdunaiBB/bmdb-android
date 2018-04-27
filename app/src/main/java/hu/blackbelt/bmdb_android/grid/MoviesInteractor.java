package hu.blackbelt.bmdb_android.grid;

import java.util.List;

import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public interface MoviesInteractor {

    interface OnFinishedListener {
        void onFinished(List<MovieDataModel> movies);
    }

    void getItems(OnFinishedListener listener);
}
