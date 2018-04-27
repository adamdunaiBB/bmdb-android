package hu.blackbelt.bmdb_android.grid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import hu.blackbelt.bmdb_android.R;
import hu.blackbelt.bmdb_android.about.AboutActivityImpl;
import hu.blackbelt.bmdb_android.common.listener.OnItemClickedListener;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;
import hu.blackbelt.bmdb_android.grid.adapter.RecyclerViewAdapterBase;

@EActivity(R.layout.activity_main)
public class GridActivity extends AppCompatActivity implements GridView {

    @ViewById(R.id.main_toolbar)
    Toolbar toolbar;

    @ViewById(R.id.recycler_view)
    RecyclerView recyclerView;

    private GridPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void afterViews() {
        mPresenter = new GridPresenterImpl(this, new MoviesInteractorImpl());

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
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
        RecyclerViewAdapterBase recyclerViewAdapter = new RecyclerViewAdapterBase(movies);

        recyclerViewAdapter.setOnItemClickedListener(new OnItemClickedListener() {
            @Override
            public void onItemClicked(@NonNull MovieDataModel item) {
                AboutActivityImpl
                        .intent(getApplicationContext())
                        .movieId(item.getId())
                        .start();
            }

            @Override
            public void onItemLongClicked(@NonNull MovieDataModel item) {
                Toast.makeText(GridActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_grid, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_list_view) {
            this.finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
