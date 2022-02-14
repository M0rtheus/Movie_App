package lt.vcs.movieapp.home.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import lt.vcs.movieapp.home.model.item.ItemComingSoon;
import lt.vcs.movieapp.home.model.item.ItemInTheaters;
import lt.vcs.movieapp.home.model.item.ItemMostPopular;
import lt.vcs.movieapp.home.model.item.ItemTopMovies;
import lt.vcs.movieapp.common.repository.RemoteRepository;

public class HomeFragmentViewModel extends ViewModel {
    private LiveData<List<ItemTopMovies>> topMoviesList;
    private LiveData<List<ItemMostPopular>> mostPopularsList;
    private LiveData<List<ItemInTheaters>> inTheatersList;
    private LiveData<List<ItemComingSoon>> comingSoonList;

    private RemoteRepository remoteRepository;

    public HomeFragmentViewModel() {
        this.remoteRepository = new RemoteRepository();
    }

    public LiveData<List<ItemTopMovies>> getTopMoviesList() {
        if (topMoviesList == null) {
            topMoviesList = remoteRepository.getTopMoviesList();
        }
        return topMoviesList;
    }

    public LiveData<List<ItemMostPopular>> getMostPopularsList() {
        if (mostPopularsList == null) {
            mostPopularsList = remoteRepository.getMostPopularsList();
        }
        return mostPopularsList;
    }

    public LiveData<List<ItemInTheaters>> getInTheatersList() {
        if (inTheatersList == null) {
            inTheatersList = remoteRepository.getInTheaters();
        }
        return inTheatersList;
    }

    public LiveData<List<ItemComingSoon>> getComingSoonList() {
        if (comingSoonList == null) {
            comingSoonList = remoteRepository.getComingSoon();
        }
        return comingSoonList;
    }
}
