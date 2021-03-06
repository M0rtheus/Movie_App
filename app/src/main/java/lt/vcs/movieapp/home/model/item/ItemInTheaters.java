package lt.vcs.movieapp.home.model.item;

import com.google.gson.annotations.SerializedName;

public class ItemInTheaters {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("year")
    private String year;
    @SerializedName("releaseState")
    private String releaseState;
    @SerializedName("image")
    private String image;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getReleaseState() {
        return releaseState;
    }

    public String getImage() {
        return image;
    }

}
