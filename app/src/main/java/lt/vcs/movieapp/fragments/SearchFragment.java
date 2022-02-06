package lt.vcs.movieapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import lt.vcs.movieapp.R;
import lt.vcs.movieapp.adapters.SearchAdapter;
import lt.vcs.movieapp.api.apimodels.items.ItemSearch;
import lt.vcs.movieapp.viewmodels.SearchFragmentViewModel;

public class SearchFragment extends Fragment {

    private RecyclerView searchRecyclerView;
    private SearchAdapter searchAdapter;
    private SearchFragmentViewModel viewModel;
    private LiveData<List<ItemSearch>> searchLiveList;
    private List<ItemSearch> searchList = Collections.emptyList();
    private SearchView searchView;

    public SearchFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_search, container, false);
        searchRecyclerView = view.findViewById(R.id.searchRecyclerView);
        searchRecyclerView.setHasFixedSize(true);
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        searchLiveList = viewModel.getSearchList();
        searchAdapter = new SearchAdapter(searchList, getActivity());
        searchRecyclerView.setAdapter(searchAdapter);
        searchLiveList.observe(getViewLifecycleOwner(), new Observer<List<ItemSearch>>() {
            @Override
            public void onChanged(List<ItemSearch> itemSearches) {
                searchList = itemSearches;
                searchAdapter.setList(searchList);
            }
        });

        return view;
    }

    private void setSearchView(View view){
        searchView = view.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}