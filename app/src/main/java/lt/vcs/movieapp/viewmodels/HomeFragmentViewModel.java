package lt.vcs.movieapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import lt.vcs.movieapp.model.items.ItemTopMovies;
import lt.vcs.movieapp.repository.RemoteRepository;

public class HomeFragmentViewModel extends ViewModel {

    RemoteRepository remoteRepository;

    public LiveData<List<ItemTopMovies>> getMovies(){
        return remoteRepository.getMovies();
    }

}
