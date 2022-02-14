package lt.vcs.movieapp.home.model.response;

import java.util.List;

import lt.vcs.movieapp.home.model.item.ItemMostPopular;

public class MostPopularResponse {
    private List<ItemMostPopular> items;

    public List<ItemMostPopular> getItems() {
        return items;
    }

}
