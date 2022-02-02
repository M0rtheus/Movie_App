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

import lt.vcs.movieapp.MainActivity;
import lt.vcs.movieapp.R;
import lt.vcs.movieapp.adapters.FavoritesAdapter;
import lt.vcs.movieapp.adapters.TopMovieAdapter;
import lt.vcs.movieapp.api.apimodels.items.ItemTopMovies;
import lt.vcs.movieapp.data.FavoriteItem;
import lt.vcs.movieapp.viewmodels.FavoritesFragmentViewModel;
import lt.vcs.movieapp.viewmodels.HomeFragmentViewModel;

public class FavoritesFragment extends Fragment {

    private RecyclerView recyclerView;
    private LiveData<List<FavoriteItem>> list;
    private FavoritesFragmentViewModel viewModel;

    public FavoritesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        recyclerView = view.findViewById(R.id.favoritesRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        viewModel = new ViewModelProvider(getActivity()).get(FavoritesFragmentViewModel.class);

//        viewModel.insertItem(new FavoriteItem(1,"tt11466222", "Title 1", 2022, "https://imdb-api.com/images/original/MV5BOTY4YjI2N2MtYmFlMC00ZjcyLTg3YjEtMDQyM2ZjYzQ5YWFkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_Ratio0.6762_AL_.jpg", "10"));
//        viewModel.insertItem(new FavoriteItem(2,"tt11466222", "Title 2", 2022, "https://imdb-api.com/images/original/MV5BOTY4YjI2N2MtYmFlMC00ZjcyLTg3YjEtMDQyM2ZjYzQ5YWFkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_Ratio0.6762_AL_.jpg", "10"));
//        viewModel.insertItem(new FavoriteItem(3,"tt11466222", "Title 3", 2022, "https://imdb-api.com/images/original/MV5BOTY4YjI2N2MtYmFlMC00ZjcyLTg3YjEtMDQyM2ZjYzQ5YWFkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_Ratio0.6762_AL_.jpg", "10"));

        list = viewModel.getAllItems();
        list.observe(getViewLifecycleOwner(), new Observer<List<FavoriteItem>>() {
            @Override
            public void onChanged(List<FavoriteItem> favoriteItems) {
                recyclerView.setAdapter(new FavoritesAdapter(favoriteItems, getActivity()));
            }
        });

        return view;
    }
}