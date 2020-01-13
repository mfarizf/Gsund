package com.example.gsund.ui.intro;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import androidx.fragment.app.Fragment;

import com.example.gsund.data.prefs.PreferencesManager;
import com.example.gsund.ui.registrasi.RegisterActivity;
import com.github.paolorotolo.appintro.AppIntro2;

public class Intro extends AppIntro2 {
    PreferencesManager preferencesManager;

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferencesManager = new PreferencesManager(this);

        addSlide(new intro1());
        addSlide(new intro2());
        setIndicatorColor(Color.parseColor("#1B1B41"), Color.parseColor("#1B1B41"));
        showStatusBar(false);
        showSkipButton(true);

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
        preferencesManager.setFirst(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        new Handler().removeCallbacksAndMessages(null);
    }
}
