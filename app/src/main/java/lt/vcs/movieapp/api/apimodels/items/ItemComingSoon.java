package lt.vcs.movieapp.api.apimodels.items;

import com.google.gson.annotations.SerializedName;

public class ItemComingSoon {

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

    @Override
    public String toString() {
        return "ItemComingSoon{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", releaseState='" + releaseState + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
