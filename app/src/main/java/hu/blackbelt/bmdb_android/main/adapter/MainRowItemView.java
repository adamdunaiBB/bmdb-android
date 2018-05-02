package hu.blackbelt.bmdb_android.main.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.DimensionPixelSizeRes;

import hu.blackbelt.bmdb_android.R;
import hu.blackbelt.bmdb_android.common.listener.OnItemClickedListener;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;
import hu.blackbelt.bmdb_android.common.view.BaseItemView;

@EViewGroup(R.layout.view_main_row_item)
public class MainRowItemView extends LinearLayout implements BaseItemView {

    @ViewById(R.id.row_item_image)
    ImageView imageView;

    @ViewById(R.id.row_item_title)
    TextView title;

    @ViewById(R.id.row_item_year)
    TextView year;

    @ViewById(R.id.row_item_genre)
    TextView genre;

    @DimensionPixelSizeRes(R.dimen.padding_row_item)
    int padding;

    private MovieDataModel movieDataModel;

    private OnItemClickedListener onItemClickedListener;

    public MainRowItemView(Context context) {
        super(context);

        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        setOrientation(LinearLayout.HORIZONTAL);

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

    public MainRowItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MainRowItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, null);
    }

    @AfterViews
    void afterViews() {
        TypedValue outValue = new TypedValue();
        getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
        setBackgroundResource(outValue.resourceId);
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
        year.setText(Integer.toString(movieDataModel.getYear()));
        genre.setText(movieDataModel.getGenre());
    }

    @Override
    public ImageView getCoverImageView() {
        return imageView;
    }

    public MovieDataModel getMovieDataModel() {
        return movieDataModel;
    }
}
