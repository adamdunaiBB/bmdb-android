package hu.blackbelt.bmdb_android.main.adapter;

import android.content.Context;

import java.util.List;

import hu.blackbelt.bmdb_android.common.adapter.BaseMovieListRecyclerViewAdapter;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public class RecyclerViewAdapterBase extends BaseMovieListRecyclerViewAdapter<MainRowItemView> {

    public RecyclerViewAdapterBase(List<MovieDataModel> items) {
        super(items);
    }

    @Override
    protected MainRowItemView getItemView(Context context) {
        return MainRowItemViewImpl.build(context);
    }
}
