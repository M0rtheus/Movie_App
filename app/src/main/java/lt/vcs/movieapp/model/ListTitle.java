package lt.vcs.movieapp.model;

import com.google.gson.annotations.SerializedName;

public class ListTitle {

    @SerializedName("id")
    private String id;
    @SerializedName("rank")
    private long rank;
    @SerializedName("RankUpDown")
    private long RankUpDown;
    @SerializedName("title")
    private String title;
    @SerializedName("year")
    private long year;
    @SerializedName("image")
    private String image;
    @SerializedName("imDbRating")
    private String imDbRating;
    @SerializedName("imDbRatingCount")
    private String imDbRatingCount;
}
