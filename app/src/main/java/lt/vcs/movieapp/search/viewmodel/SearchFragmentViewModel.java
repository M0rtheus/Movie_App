package lt.vcs.movieapp.search.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import lt.vcs.movieapp.search.model.ItemSearch;
import lt.vcs.movieapp.favorites.model.RecentItem;
import lt.vcs.movieapp.common.repository.RecentRepository;
import lt.vcs.movieapp.common.repository.RemoteRepository;

public class SearchFragmentViewModel extends AndroidViewModel {

    private RemoteRepository remoteRepository;
    private RecentRepository recentRepository;

    public SearchFragmentViewModel(@NonNull Application application) {
        super(application);
        this.remoteRepository = new RemoteRepository();
        this.recentRepository = new RecentRepository(application);
    }

    public LiveData<List<ItemSearch>> getSearchList(String expresion) {
        return remoteRepository.getSearchList(expresion);
    }

    public int getRecentCount() {
        return recentRepository.getCount();
    }

    public void deleteFirstItem() {
        recentRepository.deleteFirstItem();
    }

    public void insertItem(RecentItem recentItem) {
        recentRepository.insertItem(recentItem);
    }

}
