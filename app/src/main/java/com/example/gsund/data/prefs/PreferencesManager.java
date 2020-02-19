package com.example.gsund.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.gsund.root.AppConstant;

import java.text.DecimalFormat;

public class PreferencesManager {
    private Context context;
    private static final String PREF_BMI = "bmi";
    private static final String PREF_BMR = "bmr";
    private static final String PREF_AIR = "air";
    private static final String PREF_ID = "id";
    private static final String PREF_FIRST = "first";
    private static final String PREF_KARBO = "karbohidrat";
    private static final String PREF_LEMAK = "lemak";
    private static final String PREF_PROTEIN = "protein";

    public PreferencesManager(Context context){
        this.context = context;
    }

    public boolean getFirst(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF,0);
        return sharedPreferences.getBoolean(PREF_FIRST, true);
    }

    public void setFirst(boolean first){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF,0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(PREF_FIRST, first);
        edit.apply();
    }

    public Integer getId(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        return sharedPreferences.getInt(PREF_ID, 0);
    }

    public void setId(Integer id){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(PREF_ID, id);
        edit.apply();
    }

    public String getBMR(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        return sharedPreferences.getString(PREF_BMR, null);
    }

    public void setBMR(double bmr){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(bmr);

        edit.putString(PREF_BMR, formatted);
        edit.apply();
    }

    public String getBMI(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        return sharedPreferences.getString(PREF_BMI, null);
    }

    public void setBMI(double bmi){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(bmi);

        edit.putString(PREF_BMI, formatted);
        edit.apply();
    }

    public String getAir(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        return sharedPreferences.getString(PREF_AIR, null);
    }

    public void setAir(double bmi){
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(bmi);

        edit.putString(PREF_AIR, formatted);
        edit.apply();
    }

    public void setKarbohidrat(double karbohidrat) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(karbohidrat);

        edit.putString(PREF_KARBO, formatted);
        edit.apply();

    }

    public String getKarbohidrat() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        return sharedPreferences.getString(PREF_KARBO, null);
    }

    public void setLemak(double lemak) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(lemak);

        edit.putString(PREF_LEMAK, formatted);
        edit.apply();


    }

    public String getLemak() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        return sharedPreferences.getString(PREF_LEMAK, null);
    }

    public void setProtein(double protein) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(protein);

        edit.putString(PREF_PROTEIN, formatted);
        edit.apply();


    }

    public String getProtein() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstant.SHARED_PREF, 0);
        return sharedPreferences.getString(PREF_PROTEIN, null);
    }

}
