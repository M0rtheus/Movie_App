package lt.vcs.movieapp.model;

import com.google.gson.annotations.SerializedName;

public class Title {

    @SerializedName("id")
    private String id;
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

}
