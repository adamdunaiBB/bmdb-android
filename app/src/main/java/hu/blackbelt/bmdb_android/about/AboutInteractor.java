package hu.blackbelt.bmdb_android.about;



import hu.blackbelt.bmdb_android.model.Movie;

public interface AboutInteractor {

    interface OnFinishedListener {
        void onFinished(Movie movie);
    }

    void getItems(OnFinishedListener listener, int i);
}
