package lt.vcs.movieapp.api.apimodels.items;

import com.google.gson.annotations.SerializedName;

public class ItemSearch {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("resultType")
    private String resultType;
    @SerializedName("image")
    private String image;
    @SerializedName("description")
    private String description;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getResultType() {
        return resultType;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ItemSearch{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", resultType='" + resultType + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
