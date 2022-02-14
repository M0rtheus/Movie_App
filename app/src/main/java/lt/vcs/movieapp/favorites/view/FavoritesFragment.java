package lt.vcs.movieapp.favorites.view;

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
import lt.vcs.movieapp.favorites.view.adapter.ClickListener;
import lt.vcs.movieapp.favorites.view.adapter.DeleteClickListener;
import lt.vcs.movieapp.favorites.view.adapter.FavoritesAdapter;
import lt.vcs.movieapp.favorites.model.FavoriteItem;
import lt.vcs.movieapp.movie.view.MovieFragment;
import lt.vcs.movieapp.favorites.viewmodel.FavoritesFragmentViewModel;

public class FavoritesFragment extends Fragment {

    private RecyclerView recyclerView;
    private LiveData<List<FavoriteItem>> favoriteItemsLiveList;
    private List<FavoriteItem> favoriteItemsList = Collections.emptyList();
    private FavoritesFragmentViewModel viewModel;
    private FavoritesAdapter favoritesAdapter;
    private MovieFragment movieFragment;

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
        favoriteItemsLiveList = viewModel.getAllItems();
        favoritesAdapter = new FavoritesAdapter(favoriteItemsList, getActivity());
        recyclerView.setAdapter(favoritesAdapter);
        onItemFavoriteClick();
        onDeleteClick();
        favoriteItemsLiveList.observe(getViewLifecycleOwner(), new Observer<List<FavoriteItem>>() {
            @Override
            public void onChanged(List<FavoriteItem> favoriteItems) {
                favoriteItemsList = favoriteItems;
                favoritesAdapter.setList(favoriteItemsList);
            }
        });
        return view;
    }

    private void onDeleteClick() {
        favoritesAdapter.setOnDeleteClickListener(new DeleteClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                viewModel.deleteItem(favoriteItemsList.get(position).getDbId());
            }
        });
    }

    private void onItemFavoriteClick() {
        favoritesAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                movieFragment = new MovieFragment(favoriteItemsList.get(position).getId());
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, movieFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}