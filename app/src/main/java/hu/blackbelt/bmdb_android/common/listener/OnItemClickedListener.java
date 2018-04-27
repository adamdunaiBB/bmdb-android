package hu.blackbelt.bmdb_android.common.listener;


import android.support.annotation.NonNull;

import hu.blackbelt.bmdb_android.common.model.MovieDataModel;

public interface OnItemClickedListener {
    void onItemClicked(@NonNull MovieDataModel item);

    void onItemLongClicked(@NonNull MovieDataModel item);
}
