package lt.vcs.movieapp.data;

import static lt.vcs.movieapp.utilities.Constants.DATABASE_TABLE_NAME;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavoriteItemDAO {

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME)
    List<FavoriteItem> getAllItems();

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME + " WHERE dbId =:dbId")
    FavoriteItem getItem(int dbId);

    @Query("DELETE FROM " + DATABASE_TABLE_NAME + " WHERE dbId =:dbId")
    void deleteItem(int dbId);

    @Query("DELETE FROM " + DATABASE_TABLE_NAME)
    void deleteAllItems();

    @Query("SELECT MAX(dbId) FROM " + DATABASE_TABLE_NAME)
    int getMaxId();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItem(FavoriteItem favoriteItem);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItems(List<FavoriteItem> favoriteItems);

}
