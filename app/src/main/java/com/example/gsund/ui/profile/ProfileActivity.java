package com.example.gsund.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.gsund.R;
import com.example.gsund.data.prefs.PreferencesManager;
import com.example.gsund.ui.profile_progress.ProgressProfileActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ProfileActivity extends AppCompatActivity {
    PreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        preferencesManager = new PreferencesManager(this);
    }

    @OnClick(R.id.btn_progress)
    void Progress(){startActivity(new Intent(ProfileActivity.this, ProgressProfileActivity.class));
    }
}
