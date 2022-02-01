package lt.vcs.movieapp.model.responses;

import java.util.List;

import lt.vcs.movieapp.model.items.ItemComingSoon;

public class ComingSoonResponse {
    private List<ItemComingSoon> items;

    @Override
    public String toString() {
        return "ComingSoonResponse{" +
                "items=" + items +
                '}';
    }
}
