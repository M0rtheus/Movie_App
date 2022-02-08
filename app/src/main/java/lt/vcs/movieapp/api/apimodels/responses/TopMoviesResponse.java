package lt.vcs.movieapp.api.apimodels.responses;

import java.util.List;

import lt.vcs.movieapp.api.apimodels.items.ItemTopMovies;

public class TopMoviesResponse {
    private List<ItemTopMovies> items;

    public List<ItemTopMovies> getItems() {
        return items;
    }

}
