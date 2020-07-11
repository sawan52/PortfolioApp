package com.example.portfolioapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.portfolioapp.cv.CVFragment;
import com.example.portfolioapp.home.HomeFragment;
import com.example.portfolioapp.team.TeamFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        setTeamFragment();
        //setCVFragment();
        //setHomeFragment();

    }

    void setTeamFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TeamFragment()).commit();
    }

    void setCVFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CVFragment()).commit();
    }

    void setHomeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }

}
