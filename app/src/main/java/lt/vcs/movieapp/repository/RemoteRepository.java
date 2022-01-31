package lt.vcs.movieapp.repository;

import static lt.vcs.movieapp.utilities.Constants.LOG_TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import lt.vcs.movieapp.api.IMDBApi;
import lt.vcs.movieapp.api.IMDBApiService;
import lt.vcs.movieapp.model.TitleResponse;
import lt.vcs.movieapp.model.TopMoviesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteRepository {

    public void getTitle() {
        IMDBApiService service = IMDBApi.getUserInstance().create(IMDBApiService.class);

        Call<TitleResponse> call = service.getTitle("tt0372784");

        Callback<TitleResponse> callback = new Callback<TitleResponse>() {
            @Override
            public void onResponse(@NonNull Call<TitleResponse> call, Response<TitleResponse> response) {
                Log.i(LOG_TAG, "getTitle onResponse: " + response.body());
            }

            @Override
            public void onFailure(@NonNull Call<TitleResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data" + t.getMessage());
                call.cancel();
            }
        };
        call.enqueue(callback);
    }

    public void getTopMovies(){
        IMDBApiService service = IMDBApi.getUserInstance().create(IMDBApiService.class);
        Call<TopMoviesResponse> call = service.getTopMovies();
        Callback<TopMoviesResponse> callback = new Callback<TopMoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<TopMoviesResponse> call, Response<TopMoviesResponse> response) {
                Log.i(LOG_TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(@NonNull Call<TopMoviesResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data" + t.getMessage());
                call.cancel();
            }
        };
        call.enqueue(callback);
    }

}
