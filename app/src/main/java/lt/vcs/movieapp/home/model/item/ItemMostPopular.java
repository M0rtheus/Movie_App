package lt.vcs.movieapp.home.model.item;

import com.google.gson.annotations.SerializedName;

public class ItemMostPopular {

    @SerializedName("id")
    private String id;
    @SerializedName("rank")
    private long rank;
    @SerializedName("rankUpDown")
    private String rankUpDown;
    @SerializedName("title")
    private String title;
    @SerializedName("year")
    private long year;
    @SerializedName("image")
    private String image;
    @SerializedName("imDbRating")
    private String imDbRating;

    public String getId() {
        return id;
    }

    public long getRank() {
        return rank;
    }

    public String getRankUpDown() {
        return rankUpDown;
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

    public String getImDbRating() {
        return imDbRating;
    }

}
