package hu.blackbelt.bmdb_android.main.adapter;


import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public class CustomListAdapter extends BaseAdapter {

    private final List<MovieDataModel> movieList;

    public CustomListAdapter(List<MovieDataModel> movieList) {
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public MovieDataModel getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MainRowItemView rowItemView;

        if (convertView == null) {
            rowItemView = MainRowItemViewImpl.build(parent.getContext());
        } else {
            rowItemView = (MainRowItemView) convertView;
        }

        rowItemView.bind(movieList.get(position));

        return rowItemView;
    }
}
