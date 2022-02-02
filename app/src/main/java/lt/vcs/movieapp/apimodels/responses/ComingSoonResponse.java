package lt.vcs.movieapp.apimodels.responses;

import java.util.List;

import lt.vcs.movieapp.apimodels.items.ItemComingSoon;

public class ComingSoonResponse {
    private List<ItemComingSoon> items;

    @Override
    public String toString() {
        return "ComingSoonResponse{" +
                "items=" + items +
                '}';
    }
}
