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
    }
}
