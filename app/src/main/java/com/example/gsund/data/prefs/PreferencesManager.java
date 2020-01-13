package com.example.gsund.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.gsund.root.AppConstant;

public class PreferencesManager {
    private Context context;

    public PreferencesManager(Context context){
        this.context = context;
    }

    public boolean getFirst(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF,0);
        return sharedPreferences.getBoolean("FIRST",true);
    }

    public void setFirst(boolean first){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF,0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("FIRST",first);
        edit.apply();
    }

    public Integer getId(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        return sharedPreferences.getInt("id",0);
    }

    public void setId(Integer id){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("id", id);
        edit.apply();
    }

}
