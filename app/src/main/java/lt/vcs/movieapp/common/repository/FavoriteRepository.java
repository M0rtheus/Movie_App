package lt.vcs.movieapp.common.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import lt.vcs.movieapp.common.data.AppDatabase;
import lt.vcs.movieapp.favorites.model.FavoriteItem;
import lt.vcs.movieapp.favorites.model.FavoriteItemDAO;

public class FavoriteRepository {

    private FavoriteItemDAO favoriteItemDAO;
    private LiveData<List<FavoriteItem>> allItems;

    public FavoriteRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        favoriteItemDAO = appDatabase.favoriteItemDAO();
    }

    public LiveData<List<FavoriteItem>> getAllItems() {
        return favoriteItemDAO.getAllItems();
    }

    public List<String> getAllIMDBIds() {
        return favoriteItemDAO.getAllIMDBIds();
    }

    public void deleteItem(int dbId) {
        favoriteItemDAO.deleteItem(dbId);
    }

    public void insertItem(FavoriteItem favoriteItem) {
        favoriteItemDAO.insertItem(favoriteItem);
    }

}
