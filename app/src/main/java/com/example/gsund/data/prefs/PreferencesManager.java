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

    public Integer getBMR(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        return sharedPreferences.getInt("bmr",0);
    }

    public void setBMR(Integer bmr){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("bmr", bmr);
        edit.apply();
    }

    public Integer getBMI(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        return sharedPreferences.getInt("bmi",0);
    }

    public void setBMI(Integer bmi){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("bmi", bmi);
        edit.apply();
    }

}
