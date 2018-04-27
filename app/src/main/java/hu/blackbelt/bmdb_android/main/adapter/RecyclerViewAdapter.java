package hu.blackbelt.bmdb_android.main.adapter;

import android.view.ViewGroup;

import java.util.List;

import hu.blackbelt.bmdb_android.common.adapter.RecyclerViewAdapterBase;
import hu.blackbelt.bmdb_android.common.adapter.ViewWrapper;
import hu.blackbelt.bmdb_android.common.listener.OnItemClickedListener;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public class RecyclerViewAdapter extends RecyclerViewAdapterBase<MovieDataModel, MainRowItemView> {

    private OnItemClickedListener onItemClickedListener;

    public RecyclerViewAdapter(List<MovieDataModel> items) {
        super(items);
    }

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    @Override
    protected MainRowItemView onCreateItemView(ViewGroup parent, int viewType) {
        MainRowItemView rowItemView = MainRowItemViewImpl.build(parent.getContext());
        rowItemView.setOnItemClickedListener(onItemClickedListener);
        return rowItemView;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<MainRowItemView> holder, int position) {
        MainRowItemView view = holder.getView();
        view.bind(items.get(position));
    }

}
