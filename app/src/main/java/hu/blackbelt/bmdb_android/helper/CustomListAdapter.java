package hu.blackbelt.bmdb_android.helper;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.ViewById;

import java.util.List;

import hu.blackbelt.bmdb_android.R;
import hu.blackbelt.bmdb_android.model.Movie;

public class CustomListAdapter extends BaseAdapter {

//    @ViewById(R.id.row_item_image)
//    ImageView imageView;
//
//    @ViewById(R.id.row_item_title)
//    TextView title;
//
//    @ViewById(R.id.row_item_year)
//    TextView year;
//
//    @ViewById(R.id.row_item_genre)
//    TextView genre;

    private Activity activity;
    private LayoutInflater layoutInflater;
    private List<Movie> movieList;

    public CustomListAdapter(Activity activity, List<Movie> movieList) {
        this.activity = activity;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.row_item_image);
        TextView title = convertView.findViewById(R.id.row_item_title);
        TextView year = convertView.findViewById(R.id.row_item_year);
        TextView genre = convertView.findViewById(R.id.row_item_genre);

        Movie movie = movieList.get(position);

        imageView.setImageResource(movie.getImageResId());
        title.setText(movie.getTitle());
        year.setText(Integer.toString(movie.getYear()));
        genre.setText(movie.getDescription());

        return convertView;
    }
}
