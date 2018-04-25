package hu.blackbelt.bmdb_android.main;


import java.util.Arrays;
import java.util.List;

import hu.blackbelt.bmdb_android.R;
import hu.blackbelt.bmdb_android.model.Movie;

public class MoviesInteractorImpl implements MoviesInteractor{

    @Override
    public void getItems(OnFinishedListener listener) {
        listener.onFinished(createArrayList());
    }

    private List<Movie> createArrayList() {
        return Arrays.asList(
                new Movie("The Shawshank Redemption", 1994, "Crime, Drama", R.drawable.the_shawshank_redemption),
                new Movie("The Godfather", 1972, "Crime, Drama",  R.drawable.the_shawshank_redemption),
                new Movie("The Godfather: Part II", 1974, "Crime, Drama", R.drawable.the_shawshank_redemption),
                new Movie("The Dark Knight", 2008, "Action, Crime, Drama", R.drawable.the_shawshank_redemption),
                new Movie("12 Angry Men", 1957, "Crime, Drama", R.drawable.the_shawshank_redemption));
    }
}
