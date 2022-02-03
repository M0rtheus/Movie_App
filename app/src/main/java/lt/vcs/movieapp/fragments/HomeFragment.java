package lt.vcs.movieapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lt.vcs.movieapp.R;
import lt.vcs.movieapp.adapters.ComingSoonAdapter;
import lt.vcs.movieapp.adapters.InTheatersAdapter;
import lt.vcs.movieapp.adapters.MostPopularAdapter;
import lt.vcs.movieapp.adapters.TopMovieAdapter;
import lt.vcs.movieapp.api.apimodels.items.ItemComingSoon;
import lt.vcs.movieapp.api.apimodels.items.ItemInTheaters;
import lt.vcs.movieapp.api.apimodels.items.ItemMostPopular;
import lt.vcs.movieapp.api.apimodels.items.ItemTopMovies;
import lt.vcs.movieapp.viewmodels.HomeFragmentViewModel;

public class HomeFragment extends Fragment {

    private RecyclerView topMoviesRecyclerView;
    private RecyclerView mostPopularRecyclerView;
    private RecyclerView inTheatersRecyclerView;
    private RecyclerView comingSoonRecyclerView;
    private HomeFragmentViewModel viewModel;
    private LiveData<List<ItemTopMovies>> topMoviesList;
    private LiveData<List<ItemMostPopular>> mostPopularList;
    private LiveData<List<ItemInTheaters>> inTheatersList;
    private LiveData<List<ItemComingSoon>> comingSoonList;
    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewModel = new ViewModelProvider(this).get(HomeFragmentViewModel.class);
        setTopMoviesRecyclerView(view);
//        setMostPopularRecyclerView(view);
//        setInTheatersRecyclerView(view);
//        setComingSoonRecyclerView(view);
        return view;
    }

    private void setComingSoonRecyclerView(View view) {
        comingSoonRecyclerView = view.findViewById(R.id.comingSoonRecyclerView);
        comingSoonRecyclerView.setHasFixedSize(true);
        comingSoonRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        comingSoonList = viewModel.getComingSoonList();
        comingSoonList.observe(getViewLifecycleOwner(), new Observer<List<ItemComingSoon>>() {
            @Override
            public void onChanged(List<ItemComingSoon> itemComingSoons) {
                comingSoonRecyclerView.setAdapter(new ComingSoonAdapter(itemComingSoons, getActivity()));
            }
        });
    }

    private void setInTheatersRecyclerView(View view) {
        inTheatersRecyclerView = view.findViewById(R.id.inTheatersRecyclerView);
        inTheatersRecyclerView.setHasFixedSize(true);
        inTheatersRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        inTheatersList = viewModel.getInTheatersList();
        inTheatersList.observe(getViewLifecycleOwner(), new Observer<List<ItemInTheaters>>() {
            @Override
            public void onChanged(List<ItemInTheaters> itemInTheaters) {
                inTheatersRecyclerView.setAdapter(new InTheatersAdapter(itemInTheaters, getActivity()));
            }
        });
    }

    private void setTopMoviesRecyclerView(View view) {
        topMoviesRecyclerView = view.findViewById(R.id.topMoviesRecyclerView);
        topMoviesRecyclerView.setHasFixedSize(true);
        topMoviesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        topMoviesList = viewModel.getTopMoviesList();
        topMoviesList.observe(getViewLifecycleOwner(), new Observer<List<ItemTopMovies>>() {
            @Override
            public void onChanged(List<ItemTopMovies> itemTopMovies) {
                topMoviesRecyclerView.setAdapter(new TopMovieAdapter(itemTopMovies, getActivity()));
            }
        });
    }

    private void setMostPopularRecyclerView(View view) {
        mostPopularRecyclerView = view.findViewById(R.id.mostPopularRecyclerView);
        mostPopularRecyclerView.setHasFixedSize(true);
        mostPopularRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mostPopularList = viewModel.getMostPopularsList();
        mostPopularList.observe(getViewLifecycleOwner(), new Observer<List<ItemMostPopular>>() {
            @Override
            public void onChanged(List<ItemMostPopular> itemMostPopulars) {
                mostPopularRecyclerView.setAdapter(new MostPopularAdapter(itemMostPopulars, getActivity()));
            }
    });
    }
}