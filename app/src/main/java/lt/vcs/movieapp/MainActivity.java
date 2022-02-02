package lt.vcs.movieapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import lt.vcs.movieapp.fragments.FavoritesFragment;
import lt.vcs.movieapp.fragments.HomeFragment;
import lt.vcs.movieapp.fragments.SearchFragment;
import lt.vcs.movieapp.repository.LocalRepository;
import lt.vcs.movieapp.repository.RemoteRepository;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment = new HomeFragment();
    private SearchFragment searchFragment = new SearchFragment();
    private FavoritesFragment favoritesFragment = new FavoritesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(navListener);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new FavoritesFragment())
                .commit();
    }

    private NavigationBarView.OnItemSelectedListener navListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = homeFragment;
                            break;
                        case R.id.nav_search:
                            selectedFragment = searchFragment;
                            break;
                        case R.id.nav_favorites:
                            selectedFragment = favoritesFragment;
                    }
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();
                    return true;
                }
            };
}