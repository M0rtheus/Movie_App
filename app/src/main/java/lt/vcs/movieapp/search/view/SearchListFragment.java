package lt.vcs.movieapp.search.view;

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
import lt.vcs.movieapp.search.view.adapter.ClickListener;
import lt.vcs.movieapp.search.view.adapter.SearchAdapter;
import lt.vcs.movieapp.search.model.ItemSearch;
import lt.vcs.movieapp.favorites.model.RecentItem;
import lt.vcs.movieapp.movie.view.MovieFragment;
import lt.vcs.movieapp.search.viewmodel.SearchFragmentViewModel;


public class SearchListFragment extends Fragment {

    private RecyclerView searchRecyclerView;
    private SearchAdapter searchAdapter;
    private LiveData<List<ItemSearch>> searchLiveList;
    private List<ItemSearch> searchList = Collections.emptyList();
    private MovieFragment movieFragment;
    private SearchFragmentViewModel searchFragmentViewModel;
    private String searchInput;

    public SearchListFragment(String searchInput) {
        this.searchInput = searchInput;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_list, container, false);
        searchFragmentViewModel = new ViewModelProvider(this).get(SearchFragmentViewModel.class);
        setUpSearchRecyclerView(view);
        return view;
    }

    private void setUpSearchRecyclerView(View view) {
        searchRecyclerView = view.findViewById(R.id.searchRecyclerView);
        searchRecyclerView.setHasFixedSize(true);
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        searchAdapter = new SearchAdapter(searchList, getActivity());
        searchRecyclerView.setAdapter(searchAdapter);
        searchLiveList = searchFragmentViewModel.getSearchList(searchInput);
        onItemSearchClick();
        searchLiveList.observe(getViewLifecycleOwner(), new Observer<List<ItemSearch>>() {
            @Override
            public void onChanged(List<ItemSearch> itemSearches) {
                searchList = itemSearches;
                searchAdapter.setList(searchList);
            }
        });
    }

    private void onItemSearchClick() {
        searchAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                movieFragment = new MovieFragment(searchList.get(position).getId());
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, movieFragment)
                        .addToBackStack(null)
                        .commit();
                searchFragmentViewModel.insertItem(new RecentItem(searchList.get(position).getId()
                        , searchList.get(position).getImage(), searchList.get(position).getTitle()
                        , searchList.get(position).getDescription()));

                if (searchFragmentViewModel.getRecentCount() > 9) {
                    searchFragmentViewModel.deleteFirstItem();
                }

            }
        });
    }

}