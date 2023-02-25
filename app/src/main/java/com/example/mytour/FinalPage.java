package com.example.mytour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mytour.Fragments.FeedFragment;
import com.example.mytour.Fragments.HomeFragment;
import com.example.mytour.Fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

public class FinalPage extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        openFragment(HomeFragment.newInstance("", ""));

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    openFragment(HomeFragment.newInstance("", ""));
                    return true;

                case R.id.navigation_search:
                    openFragment(SearchFragment.newInstance("", ""));
                    return true;
                case R.id.navigation_feed:
                    openFragment(FeedFragment.newInstance("", ""));
                    return true;
            }
            return false;
        });

    }

    private void openFragment(Fragment fragment) {
        Log.d(TAG, "openFragment:");
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}