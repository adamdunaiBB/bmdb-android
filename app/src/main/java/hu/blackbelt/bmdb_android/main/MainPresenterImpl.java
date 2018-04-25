package hu.blackbelt.bmdb_android.main;


import android.util.Log;

import java.util.List;

import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public class MainPresenterImpl implements MainPresenter, MoviesInteractor.OnFinishedListener {

    private MainView mainView;
    private MoviesInteractor moviesInteractor;

    public MainPresenterImpl(MainView mainView, MoviesInteractor moviesInteractor) {
        this.mainView = mainView;
        this.moviesInteractor = moviesInteractor;
    }

    @Override
    public void onResume() {
        moviesInteractor.getItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        Log.d("MainPresenterImpl", "onItemClicked: " + position);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinished(List<MovieDataModel> movies) {
        if (mainView != null) {
            mainView.setMovies(movies);
        }
    }

    public MainView getMainView() {return mainView;}
}
