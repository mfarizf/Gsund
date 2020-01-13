package com.example.gsund.data.db;

import android.app.Application;

import com.example.gsund.root.AppConstant;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Gsund extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name(AppConstant.DB_NAME)
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
}
