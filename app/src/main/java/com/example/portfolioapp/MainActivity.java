package com.example.portfolioapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.portfolioapp.home.HomeFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();
        setHomeFragment();
        // Adding more codes for CVFragment
    }

    void setHomeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }


}
