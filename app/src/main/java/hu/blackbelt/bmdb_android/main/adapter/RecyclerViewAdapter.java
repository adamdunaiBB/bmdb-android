package hu.blackbelt.bmdb_android.main.adapter;


import android.view.ViewGroup;

import java.util.List;

import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public class RecyclerViewAdapter extends RecyclerViewAdapterBase<MovieDataModel, MainRowItemView> {

    public RecyclerViewAdapter(List<MovieDataModel> items) {
        super(items);
    }

    @Override
    protected MainRowItemView onCreateItemView(ViewGroup parent, int viewType) {
        return MainRowItemViewImpl.build(parent.getContext());
    }

    @Override
    public void onBindViewHolder(ViewWrapper<MainRowItemView> holder, int position) {
        MainRowItemView view = holder.getView();
        view.bind(items.get(position));
    }

}
