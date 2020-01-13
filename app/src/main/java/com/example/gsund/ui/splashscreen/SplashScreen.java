package com.example.gsund.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.gsund.R;
import com.example.gsund.data.prefs.PreferencesManager;
import com.example.gsund.ui.intro.Intro;
import com.example.gsund.ui.main.MainActivity;
import com.example.gsund.ui.registrasi.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {
    PreferencesManager preferencesManager;
    Animation anim;

    @BindView(R.id.logo) ImageView logoSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        preferencesManager = new PreferencesManager(this);
        anim = AnimationUtils.loadAnimation(this,R.anim.logoanim);
        logoSplash.startAnimation(anim);
        new Handler().postDelayed(() -> {
            if (preferencesManager.getFirst()){
                startActivity(new Intent(SplashScreen.this, Intro.class));
                finish();
            }else{
                    if (preferencesManager.getId() != null){
                    startActivity(new Intent(SplashScreen.this,MainActivity.class));
                    finish();
                }else{
                    startActivity(new Intent(SplashScreen.this, RegisterActivity.class));
                    finish();
                }
            }
        },3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        new Handler().removeCallbacksAndMessages(null);
    }
}
