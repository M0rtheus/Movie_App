package lt.vcs.movieapp.repository;

import android.content.Context;

import java.util.List;

import lt.vcs.movieapp.data.AppDAO;
import lt.vcs.movieapp.data.AppDatabase;
import lt.vcs.movieapp.model.Item;

public class LocalRepository {

    private AppDAO appDAO;

    public LocalRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        appDAO = appDatabase.appDao();
    }

    public List<Item> getAll() {
        return appDAO.getAll();
    }

    public Item getItem(int dbId) {
        return appDAO.getItem(dbId);
    }

    public void deleteItem(int dbId) {
        appDAO.deleteItem(dbId);
    }

    public void deleteAllItems() {
        appDAO.deleteAllItems();
    }

    public int getMaxId() {
        return appDAO.getMaxId();
    }

    public void insertItem(Item item) {
        appDAO.insertItem(item);
    }

    public void insertItems(List<Item> items) {
        appDAO.insertItems(items);
    }

}
