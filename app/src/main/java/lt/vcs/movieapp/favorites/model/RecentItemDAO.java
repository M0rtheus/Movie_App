package lt.vcs.movieapp.favorites.model;

import static lt.vcs.movieapp.common.utilities.Constants.RECENT_TABLE_NAME;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecentItemDAO {

    @Query("SELECT * FROM " + RECENT_TABLE_NAME + " ORDER BY dbId DESC")
    LiveData<List<RecentItem>> getAllItems();

    @Query("DELETE FROM " + RECENT_TABLE_NAME + " WHERE dbId IN (SELECT dbId FROM " + RECENT_TABLE_NAME + " ORDER BY dbId LIMIT 1)")
    void deleteFirstItem();

    @Query("SELECT COUNT(*) FROM " + RECENT_TABLE_NAME)
    int getCount();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItem(RecentItem recentItem);

}
