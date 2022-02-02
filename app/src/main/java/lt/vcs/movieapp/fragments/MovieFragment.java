package lt.vcs.movieapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import lt.vcs.movieapp.R;
import lt.vcs.movieapp.api.apimodels.responses.TitleResponse;
import lt.vcs.movieapp.viewmodels.MovieFragmentViewModel;

public class MovieFragment extends Fragment {

    private TextView movieTitleTextView;
    private TextView movieYearTextView;
    private TextView movieRuntimeTextView;
    private TextView movieScoreTextView;
    private TextView moviePlotTextView;
    private ImageView imageView;
    private MovieFragmentViewModel viewModel;
    private FloatingActionButton fab;


    public MovieFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        viewModel = new ViewModelProvider(this).get(MovieFragmentViewModel.class);
        viewModel.deleteAllItems();
        setView(view);
        setViewValues();
        setFloatingActionButton();
        return view;
    }

    private void setFloatingActionButton() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewModel.getAllIMDBIds().contains(viewModel.getTitle().getImDBid())) {
                    Snackbar.make(view, "The title already exists in favorites", Snackbar.LENGTH_SHORT)
                            .show();
                } else {
                    Snackbar.make(view, "Title added to favorites", Snackbar.LENGTH_SHORT)
                            .show();
                    viewModel.insertItem();
                }
            }
        });
    }

    private void setViewValues() {
        viewModel.getTitle("tt0372784").observe(getViewLifecycleOwner(), new Observer<TitleResponse>() {
            @Override
            public void onChanged(TitleResponse titleResponse) {
                movieTitleTextView.setText(titleResponse.getTitle());
                movieYearTextView.setText(String.valueOf(titleResponse.getYear()));
                movieRuntimeTextView.setText(String.valueOf(titleResponse.getRuntimeMins()));
                movieScoreTextView.setText("IMDB Score: " + titleResponse.getImDBRating());
                moviePlotTextView.setText(titleResponse.getPlot());
                Picasso.with(getContext())
                        .load(titleResponse.getImage())
                        .into(imageView);
                viewModel.fetchTitle(titleResponse);
            }
        });

    }

    private void setView(View view) {
        movieTitleTextView = view.findViewById(R.id.movieTitleTextView);
        movieYearTextView = view.findViewById(R.id.movieYearTextView);
        movieRuntimeTextView = view.findViewById(R.id.movieRunTimeTextView);
        movieScoreTextView = view.findViewById(R.id.movieIMDBScoreTextView);
        moviePlotTextView = view.findViewById(R.id.moviePlotTextView);
        imageView = view.findViewById(R.id.movieImageView);
        fab = view.findViewById(R.id.floatingButtonMovieFragment);
    }

}