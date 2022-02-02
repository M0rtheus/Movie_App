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
import lt.vcs.movieapp.adapters.TopMovieAdapter;
import lt.vcs.movieapp.api.apimodels.items.ItemTopMovies;
import lt.vcs.movieapp.viewmodels.HomeFragmentViewModel;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomeFragmentViewModel viewModel;
    private LiveData<List<ItemTopMovies>> list;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.topMoviesRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        viewModel = new ViewModelProvider(this).get(HomeFragmentViewModel.class);
        list = viewModel.getTopMovies();
        list.observe(getViewLifecycleOwner(), new Observer<List<ItemTopMovies>>() {
            @Override
            public void onChanged(List<ItemTopMovies> itemTopMovies) {
                recyclerView.setAdapter(new TopMovieAdapter(itemTopMovies, getActivity()));
            }
        });

        return view;
    }
}