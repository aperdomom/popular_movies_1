package com.example.alexandra.popularmovies.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexandra.popularmovies.R;
import com.example.alexandra.popularmovies.models.Movie;
import com.example.alexandra.popularmovies.utils.Constants;
import com.squareup.picasso.Picasso;

import roboguice.fragment.RoboFragment;

public class MovieDetailFragment extends RoboFragment {

    public static final String ARG_ITEM_ID = "item_id";
    private Movie    movie;


    public MovieDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            movie = getArguments().getParcelable(ARG_ITEM_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_movie_detail,
                container,
                false);
        TextView valueMovieName = (TextView) rootView.findViewById(R.id.valueMovieName);
        TextView  valueMovieRelease = (TextView) rootView.findViewById(R.id.valueMovieRelease);
        TextView  valueMovieRanting = (TextView) rootView.findViewById(R.id.valueMovieRanting);
        TextView  textViewMovieSynopsis = (TextView)rootView.findViewById(R.id.textViewMovieSynopsis);
        ImageView imageViewMoviePoster = (ImageView) rootView.findViewById(R.id.imageViewMoviePoster);
        if (movie != null) {
            valueMovieName.setText(movie.getTitle());
            valueMovieRelease.setText(movie.getReleaseDate());
            valueMovieRanting.setText(String.valueOf(movie.getVoteAverage()));
            textViewMovieSynopsis.setText(movie.getOverview());
        }
        Picasso.with(getActivity())
                .load(Constants.URL_BASE_POSTER + movie.getPosterPath())
                .into(imageViewMoviePoster);

        return rootView;
    }
}
