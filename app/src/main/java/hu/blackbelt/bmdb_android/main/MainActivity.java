package hu.blackbelt.bmdb_android.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import hu.blackbelt.bmdb_android.R;
import hu.blackbelt.bmdb_android.about.AboutActivityImpl;
import hu.blackbelt.bmdb_android.helper.CustomListAdapter;
import hu.blackbelt.bmdb_android.model.Movie;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener {

    @ViewById(R.id.list_view)
    ListView listView;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void afterViews() {
        listView.setOnItemClickListener(this);
        mPresenter = new MainPresenterImpl(this, new MoviesInteractorImpl());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void setMovies(List<Movie> movies) {
        listView.setAdapter(new CustomListAdapter(this, movies));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AboutActivityImpl.intent(getApplicationContext()).clickPosition(position).start();
        mPresenter.onItemClicked(position);
    }
}
