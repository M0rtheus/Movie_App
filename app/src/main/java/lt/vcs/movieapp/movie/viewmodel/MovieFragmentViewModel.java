package lt.vcs.movieapp.movie.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import lt.vcs.movieapp.movie.model.TitleResponse;
import lt.vcs.movieapp.favorites.model.FavoriteItem;
import lt.vcs.movieapp.common.repository.FavoriteRepository;
import lt.vcs.movieapp.common.repository.RemoteRepository;

public class MovieFragmentViewModel extends AndroidViewModel {

    private LiveData<TitleResponse> liveTitle;
    private RemoteRepository remoteRepository;
    private FavoriteRepository favoriteRepository;
    private TitleResponse title;

    public MovieFragmentViewModel(Application application) {
        super(application);
        this.favoriteRepository = new FavoriteRepository(application);
        this.remoteRepository = new RemoteRepository();
    }

    public LiveData<TitleResponse> getTitle(String id) {
        if (liveTitle == null) {
            liveTitle = remoteRepository.getTitle(id);
        }
        return liveTitle;
    }

    public void insertItem() {
        favoriteRepository.insertItem(new FavoriteItem(title.getImDBid(), title.getTitle(),
                title.getYear(), title.getImage(), title.getImDBRating()));
    }

    public List<String> getAllIMDBIds() {
        return favoriteRepository.getAllIMDBIds();
    }

    public void setTitle(TitleResponse title) {
        this.title = title;
    }

    public TitleResponse getTitle() {
        return title;
    }

}
