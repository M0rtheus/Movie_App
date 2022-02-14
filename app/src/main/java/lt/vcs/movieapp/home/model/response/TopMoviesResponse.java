package lt.vcs.movieapp.home.model.response;

import java.util.List;

import lt.vcs.movieapp.home.model.item.ItemTopMovies;

public class TopMoviesResponse {
    private List<ItemTopMovies> items;

    public List<ItemTopMovies> getItems() {
        return items;
    }

}
