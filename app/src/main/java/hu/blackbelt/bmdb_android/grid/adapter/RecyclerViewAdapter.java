package hu.blackbelt.bmdb_android.grid.adapter;

import android.view.ViewGroup;

import java.util.List;

import hu.blackbelt.bmdb_android.common.adapter.RecyclerViewAdapterBase;
import hu.blackbelt.bmdb_android.common.adapter.ViewWrapper;
import hu.blackbelt.bmdb_android.common.listener.OnItemClickedListener;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public class RecyclerViewAdapter extends RecyclerViewAdapterBase<MovieDataModel, GridItemView> {

    private OnItemClickedListener onItemClickedListener;

    public RecyclerViewAdapter(List<MovieDataModel> items) {
        super(items);
    }

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    @Override
    protected GridItemView onCreateItemView(ViewGroup parent, int viewType) {
        GridItemView rowItemView = GridItemViewImpl.build(parent.getContext());
        rowItemView.setOnItemClickedListener(onItemClickedListener);
        return rowItemView;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<GridItemView> holder, int position) {
        GridItemView view = holder.getView();
        view.bind(items.get(position));
    }

}
