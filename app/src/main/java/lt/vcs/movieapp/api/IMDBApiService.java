package lt.vcs.movieapp.api;

import static lt.vcs.movieapp.utilities.Constants.API_KEY;

import lt.vcs.movieapp.model.ComingSoonResponse;
import lt.vcs.movieapp.model.InTheatersResponse;
import lt.vcs.movieapp.model.MostPopularResponse;
import lt.vcs.movieapp.model.TitleResponse;
import lt.vcs.movieapp.model.TopMoviesResponse;
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

}
