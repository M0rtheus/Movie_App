package lt.vcs.movieapp.api.apimodels.responses;

import java.util.List;

import lt.vcs.movieapp.api.apimodels.items.ItemComingSoon;

public class ComingSoonResponse {
    private List<ItemComingSoon> items;

    @Override
    public String toString() {
        return "ComingSoonResponse{" +
                "items=" + items +
                '}';
    }
}
