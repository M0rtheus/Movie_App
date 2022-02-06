package lt.vcs.movieapp.repository;

import static lt.vcs.movieapp.utilities.Constants.LOG_TAG;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import lt.vcs.movieapp.api.IMDBApi;
import lt.vcs.movieapp.api.IMDBApiService;
import lt.vcs.movieapp.api.apimodels.items.ItemComingSoon;
import lt.vcs.movieapp.api.apimodels.items.ItemInTheaters;
import lt.vcs.movieapp.api.apimodels.items.ItemMostPopular;
import lt.vcs.movieapp.api.apimodels.items.ItemSearch;
import lt.vcs.movieapp.api.apimodels.items.ItemTopMovies;
import lt.vcs.movieapp.api.apimodels.responses.ComingSoonResponse;
import lt.vcs.movieapp.api.apimodels.responses.InTheatersResponse;
import lt.vcs.movieapp.api.apimodels.responses.MostPopularResponse;
import lt.vcs.movieapp.api.apimodels.responses.SearchResponse;
import lt.vcs.movieapp.api.apimodels.responses.TitleResponse;
import lt.vcs.movieapp.api.apimodels.responses.TopMoviesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteRepository {

    private MutableLiveData<TitleResponse> title = new MutableLiveData<>();
    private MutableLiveData<List<ItemTopMovies>> topMoviesList = new MutableLiveData<>();
    private MutableLiveData<List<ItemMostPopular>> mostPopularsList = new MutableLiveData<>();
    private MutableLiveData<List<ItemComingSoon>> comingSoonList = new MutableLiveData<>();
    private MutableLiveData<List<ItemInTheaters>> inTheatersList = new MutableLiveData<>();
    private MutableLiveData<List<ItemSearch>> searchList = new MutableLiveData<>();


    public LiveData<TitleResponse> getTitle(String id) {
        IMDBApiService service = IMDBApi.getUserInstance().create(IMDBApiService.class);

        Call<TitleResponse> call = service.getTitle(id);

        Callback<TitleResponse> callback = new Callback<TitleResponse>() {
            @Override
            public void onResponse(@NonNull Call<TitleResponse> call, Response<TitleResponse> response) {
                title.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<TitleResponse> call, Throwable t) {
                call.cancel();
            }
        };
        call.enqueue(callback);
        return title;
    }

    public LiveData<List<ItemTopMovies>> getTopMoviesList() {

        IMDBApiService service = IMDBApi.getUserInstance().create(IMDBApiService.class);

        Call<TopMoviesResponse> call = service.getTopMovies();
        Callback<TopMoviesResponse> callback = new Callback<TopMoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<TopMoviesResponse> call, Response<TopMoviesResponse> response) {
                topMoviesList.postValue(response.body().getItems());
            }

            @Override
            public void onFailure(@NonNull Call<TopMoviesResponse> call, Throwable t) {
                call.cancel();
            }
        };

        call.enqueue(callback);
        return topMoviesList;
    }

    public LiveData<List<ItemComingSoon>> getComingSoon() {
        IMDBApiService service = IMDBApi.getUserInstance().create(IMDBApiService.class);
        Call<ComingSoonResponse> call = service.getComingSoon();
        Callback<ComingSoonResponse> callback = new Callback<ComingSoonResponse>() {
            @Override
            public void onResponse(@NonNull Call<ComingSoonResponse> call, Response<ComingSoonResponse> response) {
                comingSoonList.postValue(response.body().getItems());
            }

            @Override
            public void onFailure(@NonNull Call<ComingSoonResponse> call, Throwable t) {
                call.cancel();
            }
        };
        call.enqueue(callback);
        return comingSoonList;
    }

    public LiveData<List<ItemInTheaters>> getInTheaters() {
        IMDBApiService service = IMDBApi.getUserInstance().create(IMDBApiService.class);
        Call<InTheatersResponse> call = service.getInTheaters();
        Callback<InTheatersResponse> callback = new Callback<InTheatersResponse>() {
            @Override
            public void onResponse(@NonNull Call<InTheatersResponse> call, Response<InTheatersResponse> response) {
                inTheatersList.postValue(response.body().getItems());
            }

            @Override
            public void onFailure(@NonNull Call<InTheatersResponse> call, Throwable t) {

                call.cancel();
            }
        };
        call.enqueue(callback);
        return inTheatersList;
    }

    public LiveData<List<ItemMostPopular>> getMostPopularsList() {
        IMDBApiService service = IMDBApi.getUserInstance().create(IMDBApiService.class);
        Call<MostPopularResponse> call = service.getMostPopular();
        Callback<MostPopularResponse> callback = new Callback<MostPopularResponse>() {
            @Override
            public void onResponse(@NonNull Call<MostPopularResponse> call, Response<MostPopularResponse> response) {
                mostPopularsList.postValue(response.body().getItems());
                Log.i("app_test", "onResponse: " + response.body());
            }

            @Override
            public void onFailure(@NonNull Call<MostPopularResponse> call, Throwable t) {
                call.cancel();
            }
        };
        call.enqueue(callback);

        return mostPopularsList;
    }

    public LiveData<List<ItemSearch>> getSearchList(String expresion) {
        IMDBApiService service = IMDBApi.getUserInstance().create(IMDBApiService.class);
        Call<SearchResponse> call = service.getSearch(expresion);
        Callback<SearchResponse> callback = new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                searchList.postValue(response.body().getResults());
                Log.i("app_test", "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                call.cancel();
            }
        };
        call.enqueue(callback);

        return searchList;
    }

}
