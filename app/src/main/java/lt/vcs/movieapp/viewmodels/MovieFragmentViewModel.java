package lt.vcs.movieapp.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import lt.vcs.movieapp.api.apimodels.responses.TitleResponse;
import lt.vcs.movieapp.data.FavoriteItem;
import lt.vcs.movieapp.repository.LocalRepository;
import lt.vcs.movieapp.repository.RemoteRepository;

public class MovieFragmentViewModel extends AndroidViewModel {

    private LiveData<TitleResponse> liveTitle;
    private RemoteRepository remoteRepository;
    private LocalRepository localRepository;
    private TitleResponse title;

    public MovieFragmentViewModel(Application application) {
        super(application);
        this.localRepository = new LocalRepository(application);
        this.remoteRepository = new RemoteRepository();
    }

    public LiveData<TitleResponse> getTitle(String id) {
        if (liveTitle == null){
            liveTitle = remoteRepository.getTitle(id);
        }
        return liveTitle;
    }

    public void insertItem(){
        localRepository.insertItem(new FavoriteItem(title.getImDBid(), title.getTitle(),
                title.getYear(),title.getImage(), title.getImDBRating()));
    }

    public List<String> getAllIMDBIds (){
        return localRepository.getAllIMDBIds();
    }

    public  void fetchTitle(TitleResponse title){
        this.title = title;
    }

    public TitleResponse getTitle() {
        return title;
    }

    public void deleteAllItems(){
        localRepository.deleteAllItems();
    }

}
