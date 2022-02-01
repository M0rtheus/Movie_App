package lt.vcs.movieapp.model.responses;

import java.util.List;

import lt.vcs.movieapp.model.items.ItemMostPopular;

public class MostPopularResponse {
    private List<ItemMostPopular> items;

    @Override
    public String toString() {
        return "MostPopularResponse{" +
                "items=" + items +
                '}';
    }
}
