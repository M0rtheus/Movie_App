package lt.vcs.movieapp.common.api;

import static lt.vcs.movieapp.common.utilities.Constants.API_KEY;

import lt.vcs.movieapp.home.model.response.ComingSoonResponse;
import lt.vcs.movieapp.home.model.response.InTheatersResponse;
import lt.vcs.movieapp.home.model.response.MostPopularResponse;
import lt.vcs.movieapp.search.model.SearchResponse;
import lt.vcs.movieapp.movie.model.TitleResponse;
import lt.vcs.movieapp.home.model.response.TopMoviesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IMDBApiService {

    @GET("Title/" + API_KEY + "/{id}")
    Call<TitleResponse> getTitle(@Path("id") String id);

    @GET("MostPopularMovies/" + API_KEY)
    Call<MostPopularResponse> getMostPopular();

    @GET("Top250Movies/" + API_KEY)
    Call<TopMoviesResponse> getTopMovies();

    @GET("InTheaters/" + API_KEY)
    Call<InTheatersResponse> getInTheaters();

    @GET("ComingSoon/" + API_KEY)
    Call<ComingSoonResponse> getComingSoon();

    @GET("SearchMovie/" + API_KEY + "/{expression}")
    Call<SearchResponse> getSearch(@Path("expression") String expression);


}
