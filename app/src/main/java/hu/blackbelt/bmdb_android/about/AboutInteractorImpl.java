package hu.blackbelt.bmdb_android.about;


import hu.blackbelt.bmdb_android.mock.MockData;

public class AboutInteractorImpl implements AboutInteractor{

    @Override
    public void getItems(OnFinishedListener listener, int i) {
        //Should use Dagger here, I suppose
        MockData mockData = new MockData();
        listener.onFinished(mockData.createArrayList().get(i));
    }
}
