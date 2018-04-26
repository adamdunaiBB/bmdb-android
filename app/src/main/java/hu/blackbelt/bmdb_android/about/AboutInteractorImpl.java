package hu.blackbelt.bmdb_android.about;


import hu.blackbelt.bmdb_android.common.DataPresenter;

public class AboutInteractorImpl implements AboutInteractor{

    @Override
    public void getItems(OnFinishedListener listener, long id) {
        //Should use Dagger here, I suppose
        DataPresenter dataPresenter = new DataPresenter();
        listener.onFinished(dataPresenter.getMovie(id));
    }
}
