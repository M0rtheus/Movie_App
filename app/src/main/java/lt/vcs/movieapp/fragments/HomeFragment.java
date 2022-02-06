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

import java.util.Collections;
import java.util.List;

import lt.vcs.movieapp.R;
import lt.vcs.movieapp.adapters.ClickListener;
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
    private TopMovieAdapter topMovieAdapter;
    private RecyclerView mostPopularRecyclerView;
    private MostPopularAdapter mostPopularAdapter;
    private RecyclerView inTheatersRecyclerView;
    private InTheatersAdapter inTheatersAdapter;
    private RecyclerView comingSoonRecyclerView;
    private ComingSoonAdapter comingSoonAdapter;
    private HomeFragmentViewModel viewModel;
    private LiveData<List<ItemTopMovies>> topMoviesLiveList;
    private List<ItemTopMovies> topMoviesList = Collections.emptyList();
    private LiveData<List<ItemMostPopular>> mostPopularLiveList;
    private List<ItemMostPopular> mostPopularList = Collections.emptyList();
    private LiveData<List<ItemInTheaters>> inTheatersLiveList;
    private List<ItemInTheaters> inTheatersList = Collections.emptyList();
    private LiveData<List<ItemComingSoon>> comingSoonLiveList;
    private List<ItemComingSoon> comingSoonList = Collections.emptyList();
    private MovieFragment movieFragment;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewModel = new ViewModelProvider(this).get(HomeFragmentViewModel.class);
//        setTopMoviesRecyclerView(view);
//        setMostPopularRecyclerView(view);
//        setInTheatersRecyclerView(view);
        setComingSoonRecyclerView(view);
        return view;
    }


    private void setComingSoonRecyclerView(View view) {
        comingSoonRecyclerView = view.findViewById(R.id.comingSoonRecyclerView);
        comingSoonRecyclerView.setHasFixedSize(true);
        comingSoonRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        comingSoonLiveList = viewModel.getComingSoonList();
        comingSoonAdapter = new ComingSoonAdapter(comingSoonList, getActivity());
        comingSoonRecyclerView.setAdapter(comingSoonAdapter);
        onItemComingSoonClick();
        comingSoonLiveList.observe(getViewLifecycleOwner(), new Observer<List<ItemComingSoon>>() {
            @Override
            public void onChanged(List<ItemComingSoon> itemComingSoons) {
                comingSoonList = itemComingSoons;
                comingSoonAdapter.setList(comingSoonList);
            }
        });
    }

    private void onItemComingSoonClick() {
        comingSoonAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                movieFragment = new MovieFragment(comingSoonList.get(position).getId());
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, movieFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void setInTheatersRecyclerView(View view) {
        inTheatersRecyclerView = view.findViewById(R.id.inTheatersRecyclerView);
        inTheatersRecyclerView.setHasFixedSize(true);
        inTheatersRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        inTheatersLiveList = viewModel.getInTheatersList();
        inTheatersAdapter = new InTheatersAdapter(inTheatersList, getActivity());
        inTheatersRecyclerView.setAdapter(inTheatersAdapter);
        onIteminTheatersClick();
        inTheatersLiveList.observe(getViewLifecycleOwner(), new Observer<List<ItemInTheaters>>() {
            @Override
            public void onChanged(List<ItemInTheaters> itemInTheaters) {
                inTheatersList = itemInTheaters;
                inTheatersAdapter.setList(itemInTheaters);
            }
        });
    }

    private void onIteminTheatersClick() {
        inTheatersAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                movieFragment = new MovieFragment(inTheatersList.get(position).getId());
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, movieFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void setTopMoviesRecyclerView(View view) {
        topMoviesRecyclerView = view.findViewById(R.id.topMoviesRecyclerView);
        topMoviesRecyclerView.setHasFixedSize(true);
        topMoviesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        topMoviesLiveList = viewModel.getTopMoviesList();
        topMovieAdapter = new TopMovieAdapter(topMoviesList, getActivity());
        topMoviesRecyclerView.setAdapter(topMovieAdapter);
        onItemTopMoviesClick();
        topMoviesLiveList.observe(getViewLifecycleOwner(), new Observer<List<ItemTopMovies>>() {
            @Override
            public void onChanged(List<ItemTopMovies> itemTopMovies) {
                topMoviesList = itemTopMovies;
                topMovieAdapter.setList(topMoviesList);
            }
        });
    }

    private void onItemTopMoviesClick() {
        topMovieAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                movieFragment = new MovieFragment(topMoviesList.get(position).getId());
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, movieFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void setMostPopularRecyclerView(View view) {
        mostPopularRecyclerView = view.findViewById(R.id.mostPopularRecyclerView);
        mostPopularRecyclerView.setHasFixedSize(true);
        mostPopularRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mostPopularLiveList = viewModel.getMostPopularsList();
        mostPopularAdapter = new MostPopularAdapter(mostPopularList, getActivity());
        mostPopularRecyclerView.setAdapter(mostPopularAdapter);
        onItemMostPopularClick();
        mostPopularLiveList.observe(getViewLifecycleOwner(), new Observer<List<ItemMostPopular>>() {
            @Override
            public void onChanged(List<ItemMostPopular> itemMostPopulars) {
                mostPopularList = itemMostPopulars;
                mostPopularAdapter.setList(mostPopularList);
            }
        });
    }

    private void onItemMostPopularClick() {
        mostPopularAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                movieFragment = new MovieFragment(mostPopularList.get(position).getId());
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, movieFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }


}