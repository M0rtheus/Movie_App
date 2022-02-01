package lt.vcs.movieapp.model.responses;

import java.util.List;

import lt.vcs.movieapp.model.items.ItemTopMovies;

public class TopMoviesResponse {
    private List<ItemTopMovies> itemTopMovies;

    @Override
    public String toString() {
        return "TopMoviesResponse{" +
                "topMovies=" + itemTopMovies +
                '}';
    }
}
