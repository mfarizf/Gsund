package com.example.gsund.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gsund.R;
import com.example.gsund.data.prefs.PreferencesManager;

import butterknife.ButterKnife;


public class ProfileActivity extends AppCompatActivity {
    PreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        preferencesManager = new PreferencesManager(this);

    }
}
