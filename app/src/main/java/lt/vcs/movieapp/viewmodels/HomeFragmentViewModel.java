package lt.vcs.movieapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import lt.vcs.movieapp.api.apimodels.items.ItemMostPopular;
import lt.vcs.movieapp.api.apimodels.items.ItemTopMovies;
import lt.vcs.movieapp.repository.RemoteRepository;

public class HomeFragmentViewModel extends ViewModel {
    private LiveData<List<ItemTopMovies>> topMovies;
    private LiveData<List<ItemMostPopular>> mostPopulars;
    private RemoteRepository remoteRepository;

    public HomeFragmentViewModel() {
        this.remoteRepository = new RemoteRepository();
    }

    public LiveData<List<ItemTopMovies>> getTopMovies(){
        if (topMovies == null){
            topMovies = remoteRepository.getTopMovies();
        }
        return topMovies;
    }

    public LiveData<List<ItemMostPopular>> getMostPopulars(){
        if (mostPopulars == null){
            mostPopulars = remoteRepository.getMostPopulars();
        }
        return mostPopulars;
    }
}
