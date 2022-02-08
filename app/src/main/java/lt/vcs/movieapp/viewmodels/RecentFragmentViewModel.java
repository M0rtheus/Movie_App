package lt.vcs.movieapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import lt.vcs.movieapp.data.RecentItem;
import lt.vcs.movieapp.repository.RecentRepository;

public class RecentFragmentViewModel extends AndroidViewModel {

    private RecentRepository recentRepository;
    private LiveData<List<RecentItem>> allItems;

    public RecentFragmentViewModel(@NonNull Application application) {
        super(application);
        this.recentRepository = new RecentRepository(application);
        this.allItems = recentRepository.getAllItems();
    }

    public LiveData<List<RecentItem>> getAllItems() {
        return recentRepository.getAllItems();
    }

}
