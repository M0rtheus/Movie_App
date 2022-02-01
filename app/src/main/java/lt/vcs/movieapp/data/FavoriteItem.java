package lt.vcs.movieapp.data;

import static lt.vcs.movieapp.utilities.Constants.DATABASE_TABLE_NAME;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = DATABASE_TABLE_NAME)
public class FavoriteItem {

    @PrimaryKey (autoGenerate = true)
    private int dbId;
    private String id;
    private String title;
    private long year;
    private String image;
    private String imDbRating;

    public FavoriteItem(int dbId, String id, String title, long year, String image, String imDbRating) {
        this.dbId = dbId;
        this.id = id;
        this.title = title;
        this.year = year;
        this.image = image;
        this.imDbRating = imDbRating;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }
}
