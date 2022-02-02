package lt.vcs.movieapp.apimodels.responses;

import java.util.List;

import lt.vcs.movieapp.apimodels.items.ItemInTheaters;

public class InTheatersResponse {
    private List<ItemInTheaters> items;

    @Override
    public String toString() {
        return "InTheatersResponse{" +
                "items=" + items +
                '}';
    }
}
