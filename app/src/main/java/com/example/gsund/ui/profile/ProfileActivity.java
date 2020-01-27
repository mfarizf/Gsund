package com.example.gsund.ui.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.gsund.R;
import com.example.gsund.ui.main.MainActivity;
import com.example.gsund.ui.menumakan.MenuMakan;
import com.example.gsund.ui.profile.adapter.SectionsPagerAdapter;
import com.example.gsund.data.prefs.PreferencesManager;
import com.google.android.material.tabs.TabLayout;

import butterknife.OnClick;


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
    @OnClick(R.id.btn_ubahdata)
    void btn_ubahdata(){
        startActivity(new Intent(ProfileActivity.this, UbahData.class));
    }


}
