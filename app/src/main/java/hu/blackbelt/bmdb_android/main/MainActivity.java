package hu.blackbelt.bmdb_android.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import hu.blackbelt.bmdb_android.R;
import hu.blackbelt.bmdb_android.about.AboutActivityImpl;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;
import hu.blackbelt.bmdb_android.main.adapter.MainRowItemView;
import hu.blackbelt.bmdb_android.main.adapter.RecyclerViewAdapter;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements MainView {

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void setMovies(List<MovieDataModel> movies) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(movies);

        recyclerViewAdapter.setOnItemClickedListener(new MainRowItemView.OnItemClickedListener() {
            @Override
            public void onItemClicked(@NonNull MovieDataModel item) {
                AboutActivityImpl
                        .intent(getApplicationContext())
                        .movieId(item.getId())
                        .start();
            }

            @Override
            public void onItemLongClicked(@NonNull MovieDataModel item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
