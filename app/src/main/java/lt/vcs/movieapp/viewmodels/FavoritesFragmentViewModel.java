package lt.vcs.movieapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import lt.vcs.movieapp.data.FavoriteItem;
import lt.vcs.movieapp.repository.FavoriteRepository;

public class FavoritesFragmentViewModel extends AndroidViewModel {

    private FavoriteRepository favoriteRepository;

    public FavoritesFragmentViewModel(@NonNull Application application) {
        super(application);
        this.favoriteRepository = new FavoriteRepository(application);
    }

    public LiveData<List<FavoriteItem>> getAllItems() {
        return favoriteRepository.getAllItems();
    }

    public void deleteItem(int dbId) {
        favoriteRepository.deleteItem(dbId);
    }

    public void insertItem(FavoriteItem favoriteItem) {
        favoriteRepository.insertItem(favoriteItem);
    }

}
