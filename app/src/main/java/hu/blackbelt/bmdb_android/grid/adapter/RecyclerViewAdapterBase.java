package hu.blackbelt.bmdb_android.grid.adapter;

import android.content.Context;

import java.util.List;

import hu.blackbelt.bmdb_android.common.adapter.BaseMovieListRecyclerViewAdapter;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public class RecyclerViewAdapterBase extends BaseMovieListRecyclerViewAdapter<GridItemView> {

    public RecyclerViewAdapterBase(List<MovieDataModel> items) {
        super(items);
    }

    @Override
    protected GridItemView getItemView(Context context) {
        return GridItemViewImpl.build(context);
    }
}
