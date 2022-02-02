package lt.vcs.movieapp.api.apimodels.responses;

import java.util.List;

import lt.vcs.movieapp.api.apimodels.items.ItemMostPopular;

public class MostPopularResponse {
    private List<ItemMostPopular> items;

    public List<ItemMostPopular> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "MostPopularResponse{" +
                "items=" + items +
                '}';
    }
}
