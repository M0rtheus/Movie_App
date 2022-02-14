package lt.vcs.movieapp.movie.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import lt.vcs.movieapp.R;
import lt.vcs.movieapp.movie.model.TitleResponse;
import lt.vcs.movieapp.movie.viewmodel.MovieFragmentViewModel;

public class MovieFragment extends Fragment {

    private TextView movieTitleTextView;
    private TextView movieYearTextView;
    private TextView movieRuntimeTextView;
    private TextView movieGenresTextView;
    private TextView movieAwardsTextView;
    private TextView movieMetascoreTextView;
    private TextView movieScoreTextView;
    private TextView moviePlotTextView;
    private TextView movieDirectorsTextView;
    private TextView movieWritersTextView;
    private TextView movieStarsTextView;
    private TextView movieVotesTextView;
    private ImageView imageView;
    private MovieFragmentViewModel viewModel;
    private FloatingActionButton fab;
    private String titleId;

    public MovieFragment(String titleId) {
        this.titleId = titleId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        viewModel = new ViewModelProvider(this).get(MovieFragmentViewModel.class);
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
        viewModel.getTitle(titleId).observe(getViewLifecycleOwner(), new Observer<TitleResponse>() {
            @Override
            public void onChanged(TitleResponse titleResponse) {
                movieTitleTextView.setText(titleResponse.getTitle());
                movieYearTextView.setText(String.valueOf(titleResponse.getYear()));
                movieRuntimeTextView.setText(String.valueOf(titleResponse.getRuntimeMins()) + "min");
                movieGenresTextView.setText(titleResponse.getGenres());
                movieAwardsTextView.setText(titleResponse.getAwards());
                movieScoreTextView.setText(titleResponse.getImDBRating());
                movieMetascoreTextView.setText(titleResponse.getMetacriticRating());
                movieDirectorsTextView.setText(titleResponse.getDirectors());
                movieWritersTextView.setText(titleResponse.getWriters());
                movieStarsTextView.setText(titleResponse.getStars());
                moviePlotTextView.setText(titleResponse.getPlot());
                movieVotesTextView.setText(titleResponse.getImDBRatingVotes());
                Picasso.with(getContext())
                        .load(titleResponse.getImage())
                        .into(imageView);
                viewModel.setTitle(titleResponse);
            }
        });

    }

    private void setView(View view) {
        movieTitleTextView = view.findViewById(R.id.movieTitleTextView);
        movieYearTextView = view.findViewById(R.id.movieYearTextView);
        movieRuntimeTextView = view.findViewById(R.id.movieRunTimeTextView);
        movieScoreTextView = view.findViewById(R.id.movieIMDBScoreTextView);
        moviePlotTextView = view.findViewById(R.id.moviePlotEntryTextView);
        movieGenresTextView = view.findViewById(R.id.movieGenreTextView);
        movieAwardsTextView = view.findViewById(R.id.movieAwardsTextView);
        movieMetascoreTextView = view.findViewById(R.id.movieMetaScoreTextView);
        movieDirectorsTextView = view.findViewById(R.id.movieDirectorsListTextView);
        movieWritersTextView = view.findViewById(R.id.movieWritersListTextView);
        movieStarsTextView = view.findViewById(R.id.movieStarListTextView);
        movieVotesTextView = view.findViewById(R.id.movieIMDBVotesTextView);
        imageView = view.findViewById(R.id.movieImageView);
        fab = view.findViewById(R.id.floatingButtonMovieFragment);
    }

}