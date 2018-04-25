package hu.blackbelt.bmdb_android.mock;


import java.util.Arrays;
import java.util.List;

import hu.blackbelt.bmdb_android.R;
import hu.blackbelt.bmdb_android.model.Movie;

public class MockData {

    public MockData() {
    }

    public List<Movie> createArrayList() {
        return Arrays.asList(
                new Movie("The Shawshank Redemption", 1994, "Crime, Drama", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", R.drawable.the_shawshank_redemption),
                new Movie("The Godfather", 1972, "Crime, Drama", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", R.drawable.godfather),
                new Movie("The Godfather: Part II", 1974, "Crime, Drama", "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.", R.drawable.godfather2),
                new Movie("The Dark Knight", 2008, "Action, Crime, Drama", "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham, the Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.", R.drawable.dark_knight),
                new Movie("12 Angry Men", 1957, "Crime, Drama", "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.", R.drawable.twelve_angry_men));
    }
}
