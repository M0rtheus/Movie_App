package lt.vcs.movieapp.model;

import java.util.List;

public class TopMoviesResponse {
    private List<ListTitle> items;

    @Override
    public String toString() {
        return "TopMoviesResponse{" +
                "topMovies=" + items +
                '}';
    }
}
