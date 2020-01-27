package com.example.gsund.ui.main;

import android.content.Context;

import com.example.gsund.data.prefs.PreferencesManager;

import io.realm.Realm;

public class MainPresenter {
    private final Context context;
    private final MainCallback registerCallback;
    private final Realm realm;
    private final PreferencesManager preferencesManager;

    public MainPresenter(Context context, MainCallback registerCallback, Realm realm, PreferencesManager preferencesManager) {
        this.context = context;
        this.registerCallback = registerCallback;
        this.realm = realm;
        this.preferencesManager = preferencesManager;
    }

    void setInterfaceData(){

    }
}
