package lt.vcs.movieapp.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import lt.vcs.movieapp.data.AppDatabase;
import lt.vcs.movieapp.data.FavoriteItem;
import lt.vcs.movieapp.data.FavoriteItemDAO;

public class LocalRepository {

    private FavoriteItemDAO favoriteItemDAO;
    private LiveData<List<FavoriteItem>> allItems;

    public LocalRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        favoriteItemDAO = appDatabase.favoriteItemDAO();
    }

    public LiveData<List<FavoriteItem>> getAllItems(){
        return favoriteItemDAO.getAllItems();
    }

    public FavoriteItem getItem(int dbId){
        return favoriteItemDAO.getItem(dbId);
    }

    public void deleteItem(int dbId){
        favoriteItemDAO.deleteItem(dbId);
    }

    public void deleteAllItems(){
        favoriteItemDAO.deleteAllItems();
    }

    public int getMaxId(){
        return favoriteItemDAO.getMaxId();
    }

    public void insertItem(FavoriteItem favoriteItem){
        favoriteItemDAO.insertItem(favoriteItem);
    }

    public void insertItems(List<FavoriteItem> favoriteItems){
        favoriteItemDAO.insertItems(favoriteItems);
    }

}
