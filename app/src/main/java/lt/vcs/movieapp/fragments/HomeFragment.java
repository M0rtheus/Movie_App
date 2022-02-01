package lt.vcs.movieapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import lt.vcs.movieapp.R;
import lt.vcs.movieapp.adapters.TopMovieAdapter;
import lt.vcs.movieapp.model.items.ItemTopMovies;
import lt.vcs.movieapp.repository.RemoteRepository;
import lt.vcs.movieapp.viewmodels.HomeFragmentViewModel;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private TopMovieAdapter topMovieAdapter;
    private List<ItemTopMovies> list = Collections.emptyList();

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.topMoviesRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        Log.i("app_test", "onCreateView: " + list);
        RemoteRepository remoteRepository = new RemoteRepository();
        remoteRepository.getTopMovies();
        remoteRepository.getMovies().observe(getViewLifecycleOwner(), new Observer<List<ItemTopMovies>>() {
            @Override
            public void onChanged(List<ItemTopMovies> itemTopMovies) {
                list = itemTopMovies;
                recyclerView.setAdapter(new TopMovieAdapter (list, getActivity()));
                Log.i("app_test", "onChanged: " + list);
            }
        });
        return view;
    }
}