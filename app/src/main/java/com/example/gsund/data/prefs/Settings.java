package com.example.gsund.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.gsund.root.AppConstant;

public class Settings {
    private Context context;
    private static final String PREF_INGAT = "ingat";

    public Settings(Context context){
        this.context = context;
    }
    public boolean ingatkan(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_SETTINGS, 0);
        return sharedPreferences.getBoolean(PREF_INGAT, false);
    }

    public void setIngatkan(Boolean ingat){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        edit.putBoolean(PREF_INGAT, ingat);
        edit.apply();
    }

}
