package com.example.gsund.ui.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.gsund.R;
import com.example.gsund.ui.profile.adapter.SectionsPagerAdapter;
import com.example.gsund.data.prefs.PreferencesManager;
import com.google.android.material.tabs.TabLayout;


public class ProfileActivity extends AppCompatActivity {
    PreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        preferencesManager = new PreferencesManager(this);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this,getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


}
