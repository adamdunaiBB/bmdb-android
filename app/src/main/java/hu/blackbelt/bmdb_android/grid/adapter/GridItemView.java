package hu.blackbelt.bmdb_android.grid.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.DimensionPixelSizeRes;

import hu.blackbelt.bmdb_android.R;
import hu.blackbelt.bmdb_android.common.listener.OnItemClickedListener;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;
import hu.blackbelt.bmdb_android.common.view.BaseItemView;

@EViewGroup(R.layout.view_grid_item)
public class GridItemView extends RelativeLayout implements BaseItemView {

    @ViewById(R.id.grid_item_image)
    ImageView imageView;

    @ViewById(R.id.grid_item_title)
    TextView title;

    @DimensionPixelSizeRes(R.dimen.padding_row_item)
    int padding;

    private MovieDataModel movieDataModel;

    private OnItemClickedListener onItemClickedListener;

    public GridItemView(Context context) {
        super(context);

        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickedListener.onItemClicked(movieDataModel, imageView);
            }
        });

        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemClickedListener.onItemLongClicked(movieDataModel);
                return true;
            }
        });
    }

    public GridItemView(Context context, @Nullable AttributeSet attrs) {
        this(context);
    }

    public GridItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, null);
    }

    @AfterViews
    void afterViews() {
        setPadding(padding, padding, padding, padding);
    }

    @Override
    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    @Override
    public void bind(MovieDataModel model) {
        movieDataModel = model;

        imageView.setImageResource(movieDataModel.getImageResId());
        title.setText(movieDataModel.getTitle());
    }

    @Override
    public ImageView getCoverImageView() {
        return imageView;
    }

    public MovieDataModel getMovieDataModel() {
        return movieDataModel;
    }
}
