package lt.vcs.movieapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
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
import lt.vcs.movieapp.adapters.RecentAdapter;
import lt.vcs.movieapp.adapters.SearchAdapter;
import lt.vcs.movieapp.api.apimodels.items.ItemSearch;
import lt.vcs.movieapp.data.RecentItem;
import lt.vcs.movieapp.viewmodels.SearchFragmentViewModel;

public class SearchFragment extends Fragment {

    private SearchView searchView;

    public SearchFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        setUpSearchView(view);

        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.search_fragment_container, new RecentListFragment())
                .commit();
        return view;
    }

    private void setUpSearchView(View view) {
        searchView = view.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.search_fragment_container, new SearchListFragment(query))
                        .commit();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }


}