package lt.vcs.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import lt.vcs.movieapp.repository.RemoteRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RemoteRepository remoteRepository = new RemoteRepository();
        remoteRepository.getTitle();

    }
}