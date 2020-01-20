package com.example.gsund.ui.splashscreen;

import android.content.Context;
import android.content.Intent;

import com.example.gsund.data.prefs.PreferencesManager;
import com.example.gsund.ui.intro.Intro;
import com.example.gsund.ui.main.MainActivity;
import com.example.gsund.ui.registrasi.RegisterActivity;

import io.realm.Realm;

class SplashPresenter {
    private final Context context;
    private final SplashCallback splashCallback;
    private final Realm realm;
    private final PreferencesManager preferencesManager;
    private Intent intent;

    SplashPresenter(Context context, SplashCallback splashCallback, Realm realm, PreferencesManager preferencesManager) {
        this.context = context;
        this.splashCallback = splashCallback;
        this.realm = realm;
        this.preferencesManager = preferencesManager;
    }

    void checkUser(){
        if (!preferencesManager.getFirst()){
            if (preferencesManager.getId() > 0){
                intent = new Intent(context, MainActivity.class);
            }else {
                intent = new Intent(context, RegisterActivity.class);
            }
        }else{
            intent = new Intent(context, Intro.class);
        }
        splashCallback.onStartActivity(intent);
    }
}
