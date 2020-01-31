package com.example.gsund.utils;

public class HitungKebutuhan {

    public HitungKebutuhan(){

    }

    public double hitungBMI(int tinggiBadan, int beratBadan){
        double hasil;

        double tb = Double.parseDouble(String.valueOf(tinggiBadan))/100;
        double bb = Double.parseDouble(String.valueOf(beratBadan))/100;

        hasil = bb /( tb * tb ) * 100;

        return hasil;
    }

    public double hitungBMR(String jenkel, int tinggiBadan, int beratBadan,int usia,String levelAktifitas){
        double hasil;

        double tb = Double.parseDouble(String.valueOf(tinggiBadan));
        double bb = Double.parseDouble(String.valueOf(beratBadan));

        double level;

        if (levelAktifitas.equals("low")){
            level = 1.2;
        }else if(levelAktifitas.equals("normal")){
            level = 1.4;
        }else{
            level = 1.6;
        }

        if (jenkel.equals("pria")){
            hasil = (66 + (13.7 * bb) + (5 * tb) - (6.8 * usia)) * level;
        }else{
            hasil = (655 + (9.6 * bb) + (1.8 * tb) - (4.7 * usia)) * level;
        }

        return hasil;
    }

    public double hitungAir(double beratBadan, String levelAktifitas){
        double hasil ;
        double level = 0;

        if (levelAktifitas.equals("low")){
            level = 1.2;
        }else if(levelAktifitas.equals("normal")){
            level = 1.4;
        }else{
            level = 1.6;
        }

        hasil = beratBadan * 30 * level;
        return hasil;
    }
}