package lt.vcs.movieapp.fragments;

import android.graphics.Movie;
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
import lt.vcs.movieapp.adapters.RecentAdapter;
import lt.vcs.movieapp.data.RecentItem;
import lt.vcs.movieapp.viewmodels.RecentFragmentViewModel;
import lt.vcs.movieapp.viewmodels.SearchFragmentViewModel;

public class RecentListFragment extends Fragment {


    private RecyclerView recentRecyclerView;
    private RecentAdapter recentAdapter;
    private LiveData<List<RecentItem>> recentLiveList;
    private List<RecentItem> recentList = Collections.emptyList();
    private RecentFragmentViewModel viewModel;
    private MovieFragment movieFragment;

    public RecentListFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recent_list, container, false);
        viewModel = new ViewModelProvider(this).get(RecentFragmentViewModel.class);
        setUpRecentRecyclerView(view);
        return view;
    }

    private void setUpRecentRecyclerView(View view) {
        recentRecyclerView = view.findViewById(R.id.recentRecyclerView);
        recentRecyclerView.setHasFixedSize(true);
        recentRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recentAdapter = new RecentAdapter(recentList, getActivity());
        recentRecyclerView.setAdapter(recentAdapter);
        recentLiveList = viewModel.getAllItems();
        onItemRecentClick();
        recentLiveList.observe(getViewLifecycleOwner(), new Observer<List<RecentItem>>() {
            @Override
            public void onChanged(List<RecentItem> recentItems) {
                recentList = recentItems;
                recentAdapter.setList(recentList);
            }
        });
    }

    private void onItemRecentClick() {
        recentAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                movieFragment = new MovieFragment(recentList.get(position).getId());
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, movieFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}