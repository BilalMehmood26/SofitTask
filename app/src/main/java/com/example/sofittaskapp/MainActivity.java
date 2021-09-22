package com.example.sofittaskapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sofittaskapp.retrofit.Api;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolBar;
    private BottomNavigationView mBottomNav;
    private int clicked=0;
    Api apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolBar = findViewById(R.id.tool_bar_dashboard);
        setSupportActionBar(mToolBar);

        //Drawer layout
        mDrawerLayout = findViewById(R.id.drawer_layout);
        drawer();

        //Bottom Navigation
        mBottomNav = findViewById(R.id.bottom_navigation_view);
        bottomNavigation();
    }

    private void drawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolBar,R.string.Navigation_drawer_open,
                R.string.Navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void bottomNavigation() {
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment,R.id.servicesFragment,R.id.postsFragment)
                .build();
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(mBottomNav,navController);
    }


    @Override
    public void onBackPressed() {
        if(clicked==0){
            clicked++;
            Toast.makeText(this, "Click Agin to exit!", Toast.LENGTH_SHORT).show();
        }else if(clicked==1){
            finishAffinity();
        }
    }
}