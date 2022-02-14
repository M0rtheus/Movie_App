package lt.vcs.movieapp.common.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import lt.vcs.movieapp.common.data.AppDatabase;
import lt.vcs.movieapp.favorites.model.RecentItem;
import lt.vcs.movieapp.favorites.model.RecentItemDAO;

public class RecentRepository {

    private RecentItemDAO recentItemDAO;

    public RecentRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        recentItemDAO = appDatabase.recentItemDAO();
    }

    public LiveData<List<RecentItem>> getAllItems() {
        return recentItemDAO.getAllItems();
    }

    public void deleteFirstItem() {
        recentItemDAO.deleteFirstItem();
    }

    public int getCount() {
        return recentItemDAO.getCount();
    }

    public void insertItem(RecentItem recentItem) {
        recentItemDAO.insertItem(recentItem);
    }

}
