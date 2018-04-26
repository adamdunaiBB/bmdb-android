package hu.blackbelt.bmdb_android.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import hu.blackbelt.bmdb_android.R;
import hu.blackbelt.bmdb_android.about.AboutActivityImpl;
import hu.blackbelt.bmdb_android.common.model.MovieDataModel;
import hu.blackbelt.bmdb_android.main.adapter.MainRowItemView;
import hu.blackbelt.bmdb_android.main.adapter.RecyclerTouchListener;
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
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                MovieDataModel selectedMovieDataModel = ((MainRowItemView) view).getMovieDataModel();
                AboutActivityImpl
                        .intent(getApplicationContext())
                        .movieId(selectedMovieDataModel.getId())
                        .start();
                mPresenter.onItemClicked(position);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void setMovies(List<MovieDataModel> movies) {
        recyclerView.setAdapter(new RecyclerViewAdapter(movies));
    }
}
