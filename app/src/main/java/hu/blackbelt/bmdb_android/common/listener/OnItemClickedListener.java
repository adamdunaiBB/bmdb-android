package hu.blackbelt.bmdb_android.common.listener;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public interface OnItemClickedListener {
    void onItemClicked(@NonNull MovieDataModel item, ImageView coverImageView);

    void onItemLongClicked(@NonNull MovieDataModel item);
}
