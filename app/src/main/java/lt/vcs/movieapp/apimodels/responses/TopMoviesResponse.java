package lt.vcs.movieapp.apimodels.responses;

import java.util.List;

import lt.vcs.movieapp.apimodels.items.ItemTopMovies;

public class TopMoviesResponse {
    private List<ItemTopMovies> items;

    public List<ItemTopMovies> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "TopMoviesResponse{" +
                "topMovies=" + items +
                '}';
    }
}
