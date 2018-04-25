package hu.blackbelt.bmdb_android.main;


import hu.blackbelt.bmdb_android.common.mock.MockData;

public class MoviesInteractorImpl implements MoviesInteractor{

    @Override
    public void getItems(OnFinishedListener listener) {
        //Should use Dagger here, I suppose
        MockData mockData = new MockData();
        listener.onFinished(mockData.createArrayList());
    }
}
