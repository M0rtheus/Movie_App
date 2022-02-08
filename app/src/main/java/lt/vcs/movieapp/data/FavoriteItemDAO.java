package lt.vcs.movieapp.data;

import static lt.vcs.movieapp.utilities.Constants.FAVORITES_TABLE_NAME;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavoriteItemDAO {

    @Query("SELECT * FROM " + FAVORITES_TABLE_NAME)
    LiveData<List<FavoriteItem>> getAllItems();

    @Query("DELETE FROM " + FAVORITES_TABLE_NAME + " WHERE dbId =:dbId")
    void deleteItem(int dbId);

    @Query("SELECT id FROM " + FAVORITES_TABLE_NAME)
    List<String> getAllIMDBIds();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItem(FavoriteItem favoriteItem);

}
