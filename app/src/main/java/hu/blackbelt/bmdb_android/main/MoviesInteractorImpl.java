package hu.blackbelt.bmdb_android.main;


import hu.blackbelt.bmdb_android.common.DataPresenter;

public class MoviesInteractorImpl implements MoviesInteractor{

    @Override
    public void getItems(OnFinishedListener listener) {
        //Should use Dagger here, I suppose
        DataPresenter dataPresenter = new DataPresenter();
        listener.onFinished(dataPresenter.getMovies());
    }
}
