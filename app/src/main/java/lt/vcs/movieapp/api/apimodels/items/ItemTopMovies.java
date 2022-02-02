package lt.vcs.movieapp.api.apimodels.items;

import com.google.gson.annotations.SerializedName;


public class ItemTopMovies {

    @SerializedName("id")
    private String id;
    @SerializedName("rank")
    private long rank;
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

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", rank=" + rank +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", image='" + image + '\'' +
                ", imDbRating='" + imDbRating + '\'' +
                '}';
    }
}
