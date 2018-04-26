package hu.blackbelt.bmdb_android.main.adapter;


import android.view.ViewGroup;

import java.util.List;

import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public class RecyclerViewAdapter extends RecyclerViewAdapterBase<MovieDataModel, MainRowItemView> {

    private MainRowItemView.OnItemClickedListener onItemClickedListener;

    private MainRowItemView.OnItemLongClickedListener onItemLongClickedListener;

    public RecyclerViewAdapter(List<MovieDataModel> items) {
        super(items);
    }

    public void setOnItemClickedListener(MainRowItemView.OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    public void setOnItemLongClickedListener(MainRowItemView.OnItemLongClickedListener onItemLongClickedListener) {
        this.onItemLongClickedListener = onItemLongClickedListener;
    }

    @Override
    protected MainRowItemView onCreateItemView(ViewGroup parent, int viewType) {
        MainRowItemView rowItemView = MainRowItemViewImpl.build(parent.getContext());
        rowItemView.setOnItemClickedListener(onItemClickedListener);
        rowItemView.setOnItemLongClickedListener(onItemLongClickedListener);
        return rowItemView;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<MainRowItemView> holder, int position) {
        MainRowItemView view = holder.getView();
        view.bind(items.get(position));
    }

}
