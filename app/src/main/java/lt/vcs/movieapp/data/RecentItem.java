package lt.vcs.movieapp.data;

import static lt.vcs.movieapp.utilities.Constants.RECENT_TABLE_NAME;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = RECENT_TABLE_NAME)
public class RecentItem {

    @PrimaryKey(autoGenerate = true)
    private int dbId;
    private String id;
    private String image;
    private String title;
    private String description;

    public RecentItem(String id, String image, String title, String description) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
