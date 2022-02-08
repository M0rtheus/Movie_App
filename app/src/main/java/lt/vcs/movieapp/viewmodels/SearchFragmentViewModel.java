package lt.vcs.movieapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import lt.vcs.movieapp.api.apimodels.items.ItemSearch;
import lt.vcs.movieapp.data.RecentItem;
import lt.vcs.movieapp.repository.RecentRepository;
import lt.vcs.movieapp.repository.RemoteRepository;

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

    public int getRecentCount(){
        return recentRepository.getCount();
    }

    public void deleteFirstItem() {
        recentRepository.deleteFirstItem();
    }

    public void insertItem(RecentItem recentItem) {
        recentRepository.insertItem(recentItem);
    }

}
