package com.example.gsund.utils;

class HitungKebutuhan {

    public HitungKebutuhan(){

    }

    public static double hitungBMI(double tinggiBadan, double beratBadan){
        double hasil;
        hasil = beratBadan/ tinggiBadan*tinggiBadan;
        return hasil;
    }

    public static double hitungBMR(String jenkel, double tinggiBadan, double beratBadan,int usia,double levelAktifitas){
        double hasil;
        if (jenkel.equals("pria")){
            hasil = 66.5 + 13.8 * beratBadan + 5 * tinggiBadan / 6.8 * usia * levelAktifitas;
        }else{
            hasil = 655.1 + 9.6 * beratBadan + 1.9 * tinggiBadan / 4.7 * usia * levelAktifitas;
        }
        return hasil;
    }

    public static double hitungAir(double beratBadan, double levelAktifitas){
        double hasil ;
        hasil = beratBadan * 30 * levelAktifitas;
        return hasil;
    }
}