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

    public double hitungBMR(String jenkel, double tinggiBadan, double beratBadan,int usia,double levelAktifitas){
        double hasil;

        double tb = Double.parseDouble(String.valueOf(tinggiBadan));
        double bb = Double.parseDouble(String.valueOf(beratBadan));

        if (jenkel.equals("pria")){
            hasil = (66 + (13.7 * bb) + (5 * tb) - (6.8 * usia)) * levelAktifitas;
        }else{
            hasil = (655 + (9.6 * bb) + (1.8 * tb) - (4.7 * usia)) * levelAktifitas;
        }

        return hasil;
    }

    public static double hitungAir(double beratBadan){
        double hasil ;
        hasil = beratBadan * 30;
        return hasil;
    }
}