package com.example.myapplication;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomNavigationActivity extends AppCompatActivity {


    ActionBar actionBar;
    Fragment fragment;
    BottomNavigationView bottomNavigationView;


    SubribeFragment subribeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        actionBar = getSupportActionBar();

        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.menu_home:
                        showHomePage();
                        break;
                    case R.id.menu_subribe:
                        showOrderPage();
                        break;
                    case R.id.menu_email:
                        showFavoritePage();
                        break;
                    case R.id.menu_library:
                        showUserPage();
                        break;
                }
                return false;
            }
        });
        showHomePage();
    }




    private void showHomePage(){
        Toast.makeText(BottomNavigationActivity.this,"Home", Toast.LENGTH_LONG).show();
        loadFragment(0);
//        actionBar.setIcon();
        actionBar.setTitle("YOUTUBE");
        actionBar.setHomeAsUpIndicator(R.drawable.youtubemot);
        actionBar.setDisplayHomeAsUpEnabled(true);


    }
    private void showOrderPage(){

        Toast.makeText(BottomNavigationActivity.this,"Kênh đăng kí", Toast.LENGTH_LONG).show();
        loadFragment(1);
        actionBar.setTitle("Kênh đăng kí ");
        actionBar.setHomeAsUpIndicator(R.drawable.youtubemot);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    private void showFavoritePage(){
        Toast.makeText(BottomNavigationActivity.this,"Hộp thư đến", Toast.LENGTH_LONG).show();
        loadFragment(2);
        actionBar.setTitle("Hộp thư đến");
        actionBar.setHomeAsUpIndicator(R.drawable.youtubemot);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    private void showUserPage(){
        Toast.makeText(BottomNavigationActivity.this,"Thư viện", Toast.LENGTH_LONG).show();
        loadFragment(3);
        actionBar.setTitle("Thư viện");
        actionBar.setHomeAsUpIndicator(R.drawable.youtubemot);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    private void loadFragment(int flag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(flag==0){
            fragment = new HomeFragment();
        }else if(flag==1){
            fragment = new SubribeFragment();
        }else if(flag==2){
            fragment = new InboxFragment();
        }else if(flag==3){
            fragment = new LibraryFragment();
        }
        fragmentTransaction.replace(R.id.fragment_main,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.business_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
}