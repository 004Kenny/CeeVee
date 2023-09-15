package com.example.fintechapp10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        loadHomeFragment(new HomeFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.ac_dashboard) {
                    loadFragment(new HomeFragment());
                    return true;
                } else if (item.getItemId() == R.id.ac_profile) {
                    loadFragment(new Profile());
                    return true;
                } else if (item.getItemId() == R.id.ac_logout){
                    finish();
                    return  true;
                }
                return false;
            }

            private void loadFragment(Fragment fragment) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }

        });


    }

    private void loadHomeFragment(Fragment homeFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}