package hu.blackbelt.bmdb_android.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import hu.blackbelt.bmdb_android.R;
import hu.blackbelt.bmdb_android.about.AboutActivityImpl;
import hu.blackbelt.bmdb_android.common.listener.OnItemClickedListener;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;
import hu.blackbelt.bmdb_android.grid.GridActivityImpl;
import hu.blackbelt.bmdb_android.main.adapter.RecyclerViewAdapterBase;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements MainView {

    @ViewById(R.id.main_toolbar)
    Toolbar toolbar;

    @ViewById(R.id.recycler_view)
    RecyclerView recyclerView;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void afterViews() {
        mPresenter = new MainPresenterImpl(this, new MoviesInteractorImpl());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void setMovies(List<MovieDataModel> movies) {
        final RecyclerViewAdapterBase recyclerViewAdapter = new RecyclerViewAdapterBase(movies);

        recyclerViewAdapter.setOnItemClickedListener(new OnItemClickedListener() {
            @Override
            public void onItemClicked(@NonNull MovieDataModel item, ImageView coverImageView) {

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        MainActivity.this,
                        coverImageView,
                        ViewCompat.getTransitionName(coverImageView)
                );

                AboutActivityImpl
                        .intent(MainActivity.this)
                        .movieId(item.getId())
                        .withOptions(options.toBundle())
                        .start();
            }

            @Override
            public void onItemLongClicked(@NonNull MovieDataModel item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.menu_grid_view == item.getItemId()) {
            GridActivityImpl.intent(getApplicationContext()).start();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
