package hu.blackbelt.bmdb_android.grid;

import java.util.List;

import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public class GridPresenterImpl implements GridPresenter, MoviesInteractor.OnFinishedListener {

    private GridView gridView;
    private MoviesInteractor moviesInteractor;

    public GridPresenterImpl(GridView gridView, MoviesInteractor moviesInteractor) {
        this.gridView = gridView;
        this.moviesInteractor = moviesInteractor;
    }

    @Override
    public void onResume() {
        moviesInteractor.getItems(this);
    }

    @Override
    public void onDestroy() {
        gridView = null;
    }

    @Override
    public void onFinished(List<MovieDataModel> movies) {
        if (gridView != null) {
            gridView.setMovies(movies);
        }
    }

    public GridView getGridView() {return gridView;}
}
