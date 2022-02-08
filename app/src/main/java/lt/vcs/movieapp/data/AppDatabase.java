package lt.vcs.movieapp.data;

import static lt.vcs.movieapp.utilities.Constants.DATABASE_NAME;
import static lt.vcs.movieapp.utilities.Constants.DATABASE_VER;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {FavoriteItem.class, RecentItem.class},
        version = DATABASE_VER,
        exportSchema = false
)

public abstract class AppDatabase extends RoomDatabase {

    public abstract FavoriteItemDAO favoriteItemDAO();

    public abstract RecentItemDAO recentItemDAO();

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
