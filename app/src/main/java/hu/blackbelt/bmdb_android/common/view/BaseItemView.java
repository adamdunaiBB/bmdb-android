package hu.blackbelt.bmdb_android.common.view;


import hu.blackbelt.bmdb_android.common.listener.OnItemClickedListener;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public interface BaseItemView {
    void setOnItemClickedListener(OnItemClickedListener onItemClickedListener);

    void bind(MovieDataModel model);

}
