package hu.blackbelt.bmdb_android.common.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hu.blackbelt.bmdb_android.common.listener.OnItemClickedListener;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;
import hu.blackbelt.bmdb_android.common.view.BaseItemView;

public abstract class BaseMovieListRecyclerViewAdapter<V extends View & BaseItemView> extends RecyclerViewAdapterBase<MovieDataModel, V> {

    private OnItemClickedListener onItemClickedListener;

    public BaseMovieListRecyclerViewAdapter(List<MovieDataModel> items) {
        super(items);
    }

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    @Override
    protected V onCreateItemView(ViewGroup parent, int viewType)  {
        V itemView = getItemView(parent.getContext());
        itemView.setOnItemClickedListener(onItemClickedListener);
        return itemView;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<V> holder, int position) {
        V view = holder.getView();
        view.bind(items.get(position));
    }

    protected abstract V getItemView(Context context);
}
