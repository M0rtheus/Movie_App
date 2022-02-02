package lt.vcs.movieapp.apimodels.items;

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

    @Override
    public String toString() {
        return "ItemInTheaters{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", releaseState='" + releaseState + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
