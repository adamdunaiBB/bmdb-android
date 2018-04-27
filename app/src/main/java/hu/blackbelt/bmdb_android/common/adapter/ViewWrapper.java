package hu.blackbelt.bmdb_android.common.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

    private final V view;

    ViewWrapper(V itemView) {
        super(itemView);
        this.view = itemView;
    }

    public V getView() {
        return view;
    }
}
