package lt.vcs.movieapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import lt.vcs.movieapp.api.apimodels.items.ItemSearch;
import lt.vcs.movieapp.repository.RemoteRepository;

public class SearchFragmentViewModel extends ViewModel {

    private LiveData<List<ItemSearch>> searchList;
    private RemoteRepository remoteRepository;

    public SearchFragmentViewModel() {
        this.remoteRepository = new RemoteRepository();
    }

    public LiveData<List<ItemSearch>> getSearchList(String expresion) {
        return remoteRepository.getSearchList(expresion);
    }
}
