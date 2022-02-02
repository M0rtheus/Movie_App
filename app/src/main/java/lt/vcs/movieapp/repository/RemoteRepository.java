package lt.vcs.movieapp.repository;

import static lt.vcs.movieapp.utilities.Constants.LOG_TAG;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import lt.vcs.movieapp.api.IMDBApi;
import lt.vcs.movieapp.api.IMDBApiService;
import lt.vcs.movieapp.model.items.ItemTopMovies;
import lt.vcs.movieapp.model.responses.ComingSoonResponse;
import lt.vcs.movieapp.model.responses.InTheatersResponse;
import lt.vcs.movieapp.model.responses.MostPopularResponse;
import lt.vcs.movieapp.model.responses.TitleResponse;
import lt.vcs.movieapp.model.responses.TopMoviesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteRepository {

    private MutableLiveData<List<ItemTopMovies>> topMovies = new MutableLiveData<>();

    public void getTitle() {
        IMDBApiService service = IMDBApi.getUserInstance().create(IMDBApiService.class);

        Call<TitleResponse> call = service.getTitle("tt0372784");

        Callback<TitleResponse> callback = new Callback<TitleResponse>() {
            @Override
            public void onResponse(@NonNull Call<TitleResponse> call, Response<TitleResponse> response) {
                Log.i(LOG_TAG, "TitleResponse: " + response.body());
            }

            @Override
            public void onFailure(@NonNull Call<TitleResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data" + t.getMessage());
                call.cancel();
            }
        };
        call.enqueue(callback);


    }

    public LiveData<List<ItemTopMovies>> getTopMovies() {
        IMDBApiService service = IMDBApi.getUserInstance().create(IMDBApiService.class);
        Call<TopMoviesResponse> call = service.getTopMovies();
        Callback<TopMoviesResponse> callback = new Callback<TopMoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<TopMoviesResponse> call, Response<TopMoviesResponse> response) {
                Log.i(LOG_TAG, "TopMoviesResponse: " + response.body());
                topMovies.postValue(response.body().getItems());
            }

            @Override
            public void onFailure(@NonNull Call<TopMoviesResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data" + t.getMessage());
                call.cancel();
            }
        };
        call.enqueue(callback);

        return topMovies;
    }

    public void getComingSoon() {
        IMDBApiService service = IMDBApi.getUserInstance().create(IMDBApiService.class);
        Call<ComingSoonResponse> call = service.getComingSoon();
        Callback<ComingSoonResponse> callback = new Callback<ComingSoonResponse>() {
            @Override
            public void onResponse(@NonNull Call<ComingSoonResponse> call, Response<ComingSoonResponse> response) {
                Log.i(LOG_TAG, "ComingSoonResponse: " + response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ComingSoonResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data" + t.getMessage());
                call.cancel();
            }
        };
        call.enqueue(callback);
    }

    public void getInTheaters() {
        IMDBApiService service = IMDBApi.getUserInstance().create(IMDBApiService.class);
        Call<InTheatersResponse> call = service.getInTheaters();
        Callback<InTheatersResponse> callback = new Callback<InTheatersResponse>() {
            @Override
            public void onResponse(@NonNull Call<InTheatersResponse> call, Response<InTheatersResponse> response) {
                Log.i(LOG_TAG, "InTheatersResponse: " + response.body());
            }

            @Override
            public void onFailure(@NonNull Call<InTheatersResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data" + t.getMessage());
                call.cancel();
            }
        };
        call.enqueue(callback);
    }

    public void getMostPopular() {
        IMDBApiService service = IMDBApi.getUserInstance().create(IMDBApiService.class);
        Call<MostPopularResponse> call = service.getMostPopular();
        Callback<MostPopularResponse> callback = new Callback<MostPopularResponse>() {
            @Override
            public void onResponse(@NonNull Call<MostPopularResponse> call, Response<MostPopularResponse> response) {
                Log.i(LOG_TAG, "MostPopularResponse: " + response.body());
            }

            @Override
            public void onFailure(@NonNull Call<MostPopularResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data" + t.getMessage());
                call.cancel();
            }
        };
        call.enqueue(callback);
    }

}
