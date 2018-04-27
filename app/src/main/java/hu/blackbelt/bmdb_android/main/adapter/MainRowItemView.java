package hu.blackbelt.bmdb_android.main.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
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

@EViewGroup(R.layout.view_main_row_item)
public class MainRowItemView extends LinearLayout {

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
                onItemClickedListener.onItemClicked(movieDataModel);
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
        this(context);
    }

    public MainRowItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, null);
    }

    @AfterViews
    void afterViews() {
        setPadding(padding, padding, padding, padding);
    }

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    public void bind(MovieDataModel model) {
        movieDataModel = model;

        imageView.setImageResource(movieDataModel.getImageResId());
        title.setText(movieDataModel.getTitle());
        year.setText(Integer.toString(movieDataModel.getYear()));
        genre.setText(movieDataModel.getGenre());
    }

    public MovieDataModel getMovieDataModel() {
        return movieDataModel;
    }
}
