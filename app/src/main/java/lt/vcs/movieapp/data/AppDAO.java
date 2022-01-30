package lt.vcs.movieapp.data;

import static lt.vcs.movieapp.utilities.Constants.DATABASE_TABLE_NAME;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import lt.vcs.movieapp.model.ListTitle;

@Dao
public interface AppDAO {

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME)
    List<ListTitle> getAll();

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME + " WHERE id =:id")
    ListTitle getTitle(int id);

    @Query("DELETE FROM " + DATABASE_TABLE_NAME + " WHERE id =:id")
    void deleteTitle(int id);

    @Query("DELETE FROM " + DATABASE_TABLE_NAME)
    void deleteAllTitles();

    @Query("SELECT MAX(id) FROM " + DATABASE_TABLE_NAME)
    int getMaxId();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTitle(ListTitle listTitle);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTitles(List<ListTitle> titles);

}
