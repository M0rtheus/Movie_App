package lt.vcs.movieapp.api.apimodels.items;

import com.google.gson.annotations.SerializedName;

public class ItemMostPopular {

    @SerializedName("id")
    private String id;
    @SerializedName("rank")
    private long rank;
    @SerializedName("RankUpDown")
    private long rankUpDown;
    @SerializedName("title")
    private String title;
    @SerializedName("year")
    private long year;
    @SerializedName("image")
    private String image;
    @SerializedName("imDbRating")
    private String imDbRating;

    @Override
    public String toString() {
        return "ItemMostPopular{" +
                "id='" + id + '\'' +
                ", rank=" + rank +
                ", rankUpDown=" + rankUpDown +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", image='" + image + '\'' +
                ", imDbRating='" + imDbRating + '\'' +
                '}';
    }
}
