package com.example.mydzdoublelessonsix;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_main);


    }

    private void initView() {
        Toolbar toolbar = initToolbar();
        initDrawer(toolbar);

    }
    // регистрация drawer
    private void initDrawer(Toolbar toolbar) {
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();







        // Обработка навигационного меню

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                /*int id = item.getItemId();
                if (navigateFragment(id)){
                    drawer.closeDrawer(GravityCompat.START);
                    return true;
                }*/
                return false;
            }


        });
    }




    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

       if (navigateFragment(id)) {
            return true;

       }






        return super.onOptionsItemSelected(item);
    }*/


    /*private boolean navigateFragment(int id) {


        switch (id) {
            case R.id.action_settings2:
              //MonthsFragment();
                return true;
            case R.id.action_main2:
                //MonthsFragment();
                return true;
            case R.id.action_favorite2:
                //MonthsFragment();
                return true;


        }

            return false;
    }*/



    private Toolbar initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;
    }








    /*private boolean navigateFragment(int id) {
        switch (id) {
            case R.id.action_settings:
                showFragment(new MonthsFragment.newInstant());
                return true;
            case R.id.action_main:
                addFragment(new FloraFragment());
                return true;
            case R.id.action_favorite:
                addFragment(new FloraOrientation());
                return true;


        }
        return false;
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchText = (SearchView) search.getActionView();
        searchText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

        return true;
    }



}