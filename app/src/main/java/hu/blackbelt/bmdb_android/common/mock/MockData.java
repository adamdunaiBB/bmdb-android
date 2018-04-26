package hu.blackbelt.bmdb_android.common.mock;

import java.util.Map;
import java.util.TreeMap;

import hu.blackbelt.bmdb_android.R;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public class MockData {

    public MockData() {
    }

    public static Map<Long, MovieDataModel> createHashMap() {
        Map<Long, MovieDataModel> map = new TreeMap<>();

        MovieDataModel model1 = new MovieDataModel(1,
                "The Shawshank Redemption",
                1994, "Crime, Drama",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                R.drawable.the_shawshank_redemption);
        map.put(model1.getId(), model1);

        MovieDataModel model2 = new MovieDataModel(2,
                "The Godfather", 1972,
                "Crime, Drama",
                "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                R.drawable.godfather);
        map.put(model2.getId(), model2);

        MovieDataModel model3 = new MovieDataModel(3,
                "The Godfather: Part II",
                1974, "Crime, Drama",
                "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.",
                R.drawable.godfather2);
        map.put(model3.getId(), model3);

        MovieDataModel model4 = new MovieDataModel(4,
                "The Dark Knight",
                2008,
                "Action, Crime, Drama",
                "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham, the Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                R.drawable.dark_knight);
        map.put(model4.getId(), model4);

        MovieDataModel model5 = new MovieDataModel(5,
                "12 Angry Men",
                1957,
                "Crime, Drama",
                "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.",
                R.drawable.twelve_angry_men);
        map.put(model5.getId(), model5);

        return map;
    }
}
