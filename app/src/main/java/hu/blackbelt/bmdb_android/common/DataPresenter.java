package hu.blackbelt.bmdb_android.common;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hu.blackbelt.bmdb_android.common.mock.MockData;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public class DataPresenter {

    private final Map<Long, MovieDataModel> map;

    public DataPresenter() {
        this.map = MockData.createHashMap();
    }

    public MovieDataModel getMovie(long id) {
        return map.get(id);
    }

    public List<MovieDataModel> getMovies() {
        return new ArrayList<>(map.values());
    }
}
