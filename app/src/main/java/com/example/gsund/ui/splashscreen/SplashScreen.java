package com.example.gsund.ui.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.gsund.R;
import com.example.gsund.data.prefs.PreferencesManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SplashScreen extends AppCompatActivity implements SplashCallback {
    PreferencesManager preferencesManager;
    Animation anim;
    Realm realm;

    @BindView(R.id.logo) ImageView logoSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        preferencesManager = new PreferencesManager(this);

        Realm.init(SplashScreen.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        SplashPresenter splashPresenter = new SplashPresenter(SplashScreen.this, this, realm, preferencesManager);

        anim = AnimationUtils.loadAnimation(this,R.anim.logoanim);
        logoSplash.startAnimation(anim);

        // Set Agar tidak FC
        Glide.with(this)
                .load(R.drawable.logo)
                .into(logoSplash);

        new Handler().postDelayed(splashPresenter::checkUser
        ,3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        new Handler().removeCallbacksAndMessages(null);
    }

    @Override
    public void onStartActivity(Intent intent) {
        startActivity(intent);
        finish();
    }
}
