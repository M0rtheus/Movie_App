package lt.vcs.movieapp.api.apimodels.responses;

import java.util.List;

import lt.vcs.movieapp.api.apimodels.items.ItemSearch;

public class SearchResponse {

    private List<ItemSearch> results;

    public List<ItemSearch> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "results=" + results +
                '}';
    }
}
