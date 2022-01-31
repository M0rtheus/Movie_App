package lt.vcs.movieapp.data;

import static lt.vcs.movieapp.utilities.Constants.DATABASE_TABLE_NAME;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import lt.vcs.movieapp.model.Item;

@Dao
public interface AppDAO {

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME)
    List<Item> getAll();

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME + " WHERE dbId =:dbId")
    Item getTitle(int dbId);

    @Query("DELETE FROM " + DATABASE_TABLE_NAME + " WHERE dbId =:dbId")
    void deleteTitle(int dbId);

    @Query("DELETE FROM " + DATABASE_TABLE_NAME)
    void deleteAllTitles();

    @Query("SELECT MAX(dbId) FROM " + DATABASE_TABLE_NAME)
    int getMaxId();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTitle(Item item);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTitles(List<Item> titles);

}
