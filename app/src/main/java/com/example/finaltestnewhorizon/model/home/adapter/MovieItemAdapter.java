package com.example.finaltestnewhorizon.model.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.finaltestnewhorizon.R;
import com.example.finaltestnewhorizon.model.home.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieItemAdapter extends RecyclerView.Adapter<MovieItemAdapter.MovieItemViewHolder> {

    //region Variables
    List<MovieModel> movieModelList;
    Context context;
    OnFeedItemListeners onFeedItemListeners;
    //endregion

    //region Constructor

    public MovieItemAdapter(List<MovieModel> movieModelList, OnFeedItemListeners onFeedItemListeners) {
        this.movieModelList = movieModelList;
        this.onFeedItemListeners = onFeedItemListeners;
    }


    //endregion

    //region Adapter
    public MovieItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        context = parent.getContext();
        return new MovieItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieItemViewHolder holder, int position) {
        holder.movieListItemTextName.setText(movieModelList.get(position).getName());
        holder.movieListItemTextDescription.setText(movieModelList.get(position).getSummary());
        Glide.with(context).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_baseline_downloading).error(R.drawable.ic_baseline_error))
                .load(movieModelList.get(position).getImage().getMedium()).thumbnail(0.3f)
                .into(holder.movieListItemImage);
    }

    @Override
    public int getItemCount() {
        return movieModelList.size();
    }

    public void updateList(List<MovieModel> movieModelList) {
        this.movieModelList = movieModelList;
        notifyDataSetChanged();
    }

    //endregion

    //region Interface
    public interface OnFeedItemListeners {
        void onFeedListItemLinearLayoutMainContainerClickListener(MovieModel movieModel, int position);
    }
    //endregion

    //region View holder
    public class MovieItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //region Components
        ConstraintLayout movieListItemLinearLayoutMainContainer;
        TextView movieListItemTextName;
        TextView movieListItemTextDescription;
        ImageView movieListItemImage;
        View itemView;
        //endregion

        public MovieItemViewHolder(@NonNull View itemView) {
            super(itemView);
            movieListItemLinearLayoutMainContainer = itemView.findViewById(R.id.movie_list_item_linear_layout_main_container);
            movieListItemTextName = itemView.findViewById(R.id.movie_list_item_text_name);
            movieListItemTextDescription = itemView.findViewById(R.id.movie_list_item_text_description);
            movieListItemImage = itemView.findViewById(R.id.movie_list_item_image);
            this.itemView = itemView;
            movieListItemLinearLayoutMainContainer.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onFeedItemListeners.onFeedListItemLinearLayoutMainContainerClickListener(movieModelList.get(getAdapterPosition()), getAdapterPosition());
        }
    }
    //endregion

}
