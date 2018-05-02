package hu.blackbelt.bmdb_android.common.view;

import android.widget.ImageView;

import hu.blackbelt.bmdb_android.common.listener.OnItemClickedListener;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public interface BaseItemView {
    void setOnItemClickedListener(OnItemClickedListener onItemClickedListener);

    void bind(MovieDataModel model);

    ImageView getCoverImageView();
}
