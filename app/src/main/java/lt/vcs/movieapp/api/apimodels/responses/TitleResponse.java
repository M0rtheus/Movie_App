package lt.vcs.movieapp.api.apimodels.responses;

import com.google.gson.annotations.SerializedName;

public class TitleResponse {

    private int dbId;
    @SerializedName("id")
    private String imDBid;
    @SerializedName("title")
    private String title;
    @SerializedName("year")
    private long year;
    @SerializedName("image")
    private String image;
    @SerializedName("releaseDate")
    private String releaseDate;
    @SerializedName("runtimeMins")
    private long runtimeMins;
    @SerializedName("runtimeStr")
    private String runtimeStr;
    @SerializedName("plot")
    private String plot;
    @SerializedName("awards")
    private String awards;
    @SerializedName("directors")
    private String directors;
    @SerializedName("writers")
    private String writers;
    @SerializedName("stars")
    private String stars;
    @SerializedName("genres")
    private String genres;
    @SerializedName("companies")
    private String companies;
    @SerializedName("countries")
    private String countries;
    @SerializedName("imDbRating")
    private String imDBRating;
    @SerializedName("imDbRatingVotes")
    private String imDBRatingVotes;
    @SerializedName("metacriticRating")
    private String metacriticRating;

    public int getDbId() {
        return dbId;
    }

    public String getImDBid() {
        return imDBid;
    }

    public String getTitle() {
        return title;
    }

    public long getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public long getRuntimeMins() {
        return runtimeMins;
    }

    public String getRuntimeStr() {
        return runtimeStr;
    }

    public String getPlot() {
        return plot;
    }

    public String getAwards() {
        return awards;
    }

    public String getDirectors() {
        return directors;
    }

    public String getWriters() {
        return writers;
    }

    public String getStars() {
        return stars;
    }

    public String getGenres() {
        return genres;
    }

    public String getCompanies() {
        return companies;
    }

    public String getCountries() {
        return countries;
    }

    public String getImDBRating() {
        return imDBRating;
    }

    public String getImDBRatingVotes() {
        return imDBRatingVotes;
    }

    public String getMetacriticRating() {
        return metacriticRating;
    }

}
