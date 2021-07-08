package com.example.finaltestnewhorizon.model.home;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finaltestnewhorizon.api.ApiStateListener;
import com.example.finaltestnewhorizon.databinding.ActivityMainBinding;
import com.example.finaltestnewhorizon.model.home.adapter.MovieItemAdapter;
import com.example.finaltestnewhorizon.model.home.caller.MovieCaller;
import com.example.finaltestnewhorizon.model.home.model.ImageModel;
import com.example.finaltestnewhorizon.model.home.model.MovieModel;
import com.example.finaltestnewhorizon.model.home.response.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieItemAdapter.OnFeedItemListeners {

    //region Variables
    ActivityMainBinding binding;
    List<MovieModel> movieModelList;
//    MovieItemAdapter movieItemAdapter;
    MovieCaller movieCaller;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        movieModelList = new ArrayList<>();
        setupFeedRecycler();

        movieCaller = new MovieCaller();
        movieCaller.connectToGetAllMoviesApi(new ApiStateListener() {
            @Override
            public void onSuccess(Object... params) {

            }

            @Override
            public void onFailure(Object... params) {

            }
        });

    }
    //endregion

    //region Setups
    void setupFeedRecycler() {
//        movieItemAdapter = new MovieItemAdapter(movieModelList ,this);
//        binding.mainRecycler.setLayoutManager(new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false));
//        binding.mainRecycler.setAdapter(movieItemAdapter);
    }

    //endregion

    //region Adapter Listeners
    @Override
    public void onFeedListItemLinearLayoutMainContainerClickListener(MovieModel movieModel, int position) {

    }
    //endregion
}