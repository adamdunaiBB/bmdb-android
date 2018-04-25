package hu.blackbelt.bmdb_android.main;


public interface MainPresenter {

    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}
