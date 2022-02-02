package lt.vcs.movieapp.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import lt.vcs.movieapp.data.FavoriteItem;
import lt.vcs.movieapp.repository.LocalRepository;

public class FavoritesFragmentViewModel extends ViewModel {
    private LocalRepository localRepository;
    private LiveData<List<FavoriteItem>> allItems;

    public FavoritesFragmentViewModel(Context context) {
        this.localRepository = new LocalRepository(context);
        this.allItems = localRepository.getAllItems();
    }

    public LiveData<List<FavoriteItem>> getAllItems(){
        return localRepository.getAllItems();
    }

    public FavoriteItem getItem(int dbId){
        return localRepository.getItem(dbId);
    }

    public void deleteItem(int dbId){
        localRepository.deleteItem(dbId);
    }

    public void deleteAllItems(){
        localRepository.deleteAllItems();
    }

    public int getMaxId(){
        return localRepository.getMaxId();
    }

    public void insertItem(FavoriteItem favoriteItem){
        localRepository.insertItem(favoriteItem);
    }

    public void insertItems(List<FavoriteItem> favoriteItems){
        localRepository.insertItems(favoriteItems);
    }

}
