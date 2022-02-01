package lt.vcs.movieapp.model.responses;

import java.util.List;

import lt.vcs.movieapp.model.items.ItemInTheaters;

public class InTheatersResponse {
    private List<ItemInTheaters> items;

    @Override
    public String toString() {
        return "InTheatersResponse{" +
                "items=" + items +
                '}';
    }
}
