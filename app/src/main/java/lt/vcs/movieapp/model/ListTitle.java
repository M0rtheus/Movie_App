package lt.vcs.movieapp.model;

import static lt.vcs.movieapp.utilities.Constants.DATABASE_TABLE_NAME;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = DATABASE_TABLE_NAME)
public class ListTitle {

    @PrimaryKey
    private int id;
    @SerializedName("id")
    @ColumnInfo
    private String imDBid;
    @SerializedName("rank")
    @ColumnInfo
    private long rank;
    @SerializedName("RankUpDown")
    @ColumnInfo
    private long rankUpDown;
    @SerializedName("title")
    @ColumnInfo
    private String title;
    @SerializedName("year")
    @ColumnInfo
    private long year;
    @SerializedName("image")
    @ColumnInfo
    private String image;
    @SerializedName("imDbRating")
    @ColumnInfo
    private String imDbRating;
    @SerializedName("imDbRatingCount")
    @ColumnInfo
    private String imDbRatingCount;

    public ListTitle(int id, String imDBid, long rank, long rankUpDown, String title, long year, String image, String imDbRating, String imDbRatingCount) {
        this.id = id;
        this.imDBid = imDBid;
        this.rank = rank;
        this.rankUpDown = rankUpDown;
        this.title = title;
        this.year = year;
        this.image = image;
        this.imDbRating = imDbRating;
        this.imDbRatingCount = imDbRatingCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImDBid() {
        return imDBid;
    }

    public void setImDBid(String imDBid) {
        this.imDBid = imDBid;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public long getRankUpDown() {
        return rankUpDown;
    }

    public void setRankUpDown(long rankUpDown) {
        this.rankUpDown = rankUpDown;
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

    public String getImDbRatingCount() {
        return imDbRatingCount;
    }

    public void setImDbRatingCount(String imDbRatingCount) {
        this.imDbRatingCount = imDbRatingCount;
    }
}
