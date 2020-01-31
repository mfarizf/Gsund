package com.example.gsund.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.gsund.root.AppConstant;

import java.text.DecimalFormat;

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

    public String getBMR(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        return sharedPreferences.getString("bmr",null);
    }

    public void setBMR(double bmr){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(bmr);

        edit.putString("bmr", formatted);
        edit.apply();
    }

    public String getBMI(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        return sharedPreferences.getString("bmi", null);
    }

    public void setBMI(double bmi){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(bmi);

        edit.putString("bmi", formatted);
        edit.apply();
    }

    public String getAir(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        return sharedPreferences.getString("air", null);
    }

    public void setAir(double bmi){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(bmi);

        edit.putString("air", formatted);
        edit.apply();
    }

}
