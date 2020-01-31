package com.example.gsund.ui.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.gsund.R;
import com.example.gsund.ui.main.MainActivity;
import com.example.gsund.ui.menumakan.MenuMakan;
import com.example.gsund.ui.profile.adapter.SectionsPagerAdapter;
import com.example.gsund.data.prefs.PreferencesManager;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileActivity extends AppCompatActivity {
    @BindView(R.id.image_backdrop)
    ImageView imageBack;
    @BindView(R.id.picture_profile)
    CircleImageView imageProfile;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    PreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        preferencesManager = new PreferencesManager(this);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this,getSupportFragmentManager());

        viewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        Glide.with(this).load(R.drawable.gunung).into(imageBack);
        Glide.with(this).load(R.drawable.pic_sample_1).into(imageProfile);
    }

}
