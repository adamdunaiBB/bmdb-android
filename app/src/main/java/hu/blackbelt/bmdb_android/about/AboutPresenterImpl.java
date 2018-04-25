package hu.blackbelt.bmdb_android.about;


import hu.blackbelt.bmdb_android.model.Movie;

public class AboutPresenterImpl implements AboutPresenter, AboutInteractor.OnFinishedListener {

    private AboutView aboutView;
    private AboutInteractor aboutInteractor;
    private int i;

    public AboutPresenterImpl(AboutView aboutView, AboutInteractor aboutInteractor, int i) {
        this.aboutView = aboutView;
        this.aboutInteractor = aboutInteractor;
        this.i = i;
    }

    @Override
    public void onResume() {
        aboutInteractor.getItems(this, i);
    }

    @Override
    public void onDestroy() {
        aboutView = null;
    }

    @Override
    public void onFinished(Movie movie) {
        if (aboutView != null) {
            aboutView.setMovie(movie);
        }
    }

    public AboutView getAboutView() { return aboutView; }
}
