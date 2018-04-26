package hu.blackbelt.bmdb_android.about;

import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public interface AboutInteractor {

    interface OnFinishedListener {
        void onFinished(MovieDataModel movie);
    }

    void getItems(OnFinishedListener listener, long id);
}
