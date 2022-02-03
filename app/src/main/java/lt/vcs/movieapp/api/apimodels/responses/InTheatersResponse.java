package lt.vcs.movieapp.api.apimodels.responses;

import java.util.List;

import lt.vcs.movieapp.api.apimodels.items.ItemInTheaters;

public class InTheatersResponse {
    private List<ItemInTheaters> items;

    public List<ItemInTheaters> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "InTheatersResponse{" +
                "items=" + items +
                '}';
    }
}
