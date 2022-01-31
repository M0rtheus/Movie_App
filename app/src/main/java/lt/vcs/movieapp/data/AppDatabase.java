package lt.vcs.movieapp.data;

import static lt.vcs.movieapp.utilities.Constants.DATABASE_NAME;
import static lt.vcs.movieapp.utilities.Constants.DATABASE_VER;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import lt.vcs.movieapp.model.Item;

@Database(
        entities = {Item.class},
        version = DATABASE_VER,
        exportSchema = false
)

public abstract class AppDatabase extends RoomDatabase {

    public abstract AppDAO appDao();


    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
