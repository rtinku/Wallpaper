package com.rushil.wallpaperapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.rushil.wallpaperapp.misc.Utility;
import com.rushil.wallpaperapp.ui.gallery.GalleryFragment;
import com.rushil.wallpaperapp.ui.home.HomeFragment;
import com.rushil.wallpaperapp.ui.search.SearchFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();
        Utility.replaceFragment(getSupportFragmentManager(), new HomeFragment(), R.id.nav_host_fragment, "HOME");

    }

    private void initViews() {
        drawer = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
    }

    private void setListeners() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Utility.replaceFragment(getSupportFragmentManager(), new HomeFragment(), R.id.nav_host_fragment, "HOME");
                break;

            case R.id.nav_gallery:
                Utility.replaceFragment(getSupportFragmentManager(), new GalleryFragment(), R.id.nav_host_fragment, "GALLERY");
                break;

            case R.id.nav_send:
                Utility.replaceFragment(getSupportFragmentManager(), new SearchFragment(),
                        R.id.nav_host_fragment, "SEARCH");

                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            manager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
