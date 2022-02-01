package lt.vcs.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import lt.vcs.movieapp.data.FavoriteItem;
import lt.vcs.movieapp.repository.LocalRepository;
import lt.vcs.movieapp.repository.RemoteRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RemoteRepository remoteRepository = new RemoteRepository();
//        remoteRepository.getTitle();
//        remoteRepository.getTopMovies();
//        remoteRepository.getComingSoon();
//        remoteRepository.getInTheaters();
//        remoteRepository.getMostPopular();

        LocalRepository localRepository = new LocalRepository(getApplicationContext());
//        localRepository.insertItem(new FavoriteItem(1,"tt11466222", "Jackass Forever", 2022, "https://m.media-amazon.", "10"));
//        localRepository.deleteAllItems();
    }
}