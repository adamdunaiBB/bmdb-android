package hu.blackbelt.bmdb_android.about;


import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public class AboutPresenterImpl implements AboutPresenter, AboutInteractor.OnFinishedListener {

    private AboutView aboutView;
    private AboutInteractor aboutInteractor;
    private long movieId;

    public AboutPresenterImpl(AboutView aboutView, AboutInteractor aboutInteractor, long movieId) {
        this.aboutView = aboutView;
        this.aboutInteractor = aboutInteractor;
        this.movieId = movieId;
    }

    @Override
    public void onResume() {
        aboutInteractor.getItems(this, movieId);
    }

    @Override
    public void onDestroy() {
        aboutView = null;
    }

    @Override
    public void onFinished(MovieDataModel movie) {
        if (aboutView != null) {
            aboutView.setMovie(movie);
        }
    }

    public AboutView getAboutView() { return aboutView; }
}
