package lt.vcs.movieapp.viewmodels;

import androidx.lifecycle.LiveData;

import java.util.List;

import lt.vcs.movieapp.api.apimodels.items.ItemSearch;
import lt.vcs.movieapp.repository.RemoteRepository;

public class SearchFragmentViewModel {

    private LiveData<List<ItemSearch>> searchList;
    private RemoteRepository remoteRepository;

    public SearchFragmentViewModel() {
        this.remoteRepository = new RemoteRepository();
    }

    public LiveData<List<ItemSearch>> getSearchList(String expresion) {
        if (searchList == null){
            searchList = remoteRepository.getSearchList(expresion);
        }
        return searchList;
    }
}
