package com.example.multilayoutapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
  // <- note this package

import com.example.multilayoutapp.DashboardActivity;
import com.example.multilayoutapp.FormActivity;
import com.example.multilayoutapp.ProfileActivity;
import com.example.multilayoutapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_frame) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                return true;
            } else if (id == R.id.nav_constraint) {
                startActivity(new Intent(MainActivity.this, FormActivity.class));
                return true;
            } else if (id == R.id.nav_relative) {
                startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                return true;
            }
            return false;
        });

    }
}
