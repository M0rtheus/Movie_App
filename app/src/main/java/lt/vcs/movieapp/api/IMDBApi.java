package lt.vcs.movieapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IMDBApi {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://imdb-api.com/en/API/";

    public static synchronized Retrofit getUserInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
