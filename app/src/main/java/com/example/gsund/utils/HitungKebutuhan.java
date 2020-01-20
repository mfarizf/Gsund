package com.example.gsund.utils;

public class HitungKebutuhan {

    public HitungKebutuhan(){

    }

    public int hitungBMI(int tinggiBadan, int beratBadan){
        int hasil;
        hasil = beratBadan / ((tinggiBadan/10)*(tinggiBadan/10));
        return hasil;
    }

    public double hitungBMR(String jenkel, double tinggiBadan, double beratBadan,int usia,double levelAktifitas){
        double hasil;
        if (jenkel.equals("pria")){
            hasil = 66.5 + 13.8 * beratBadan + 5 * tinggiBadan / 6.8 * usia * levelAktifitas;
        }else{
            hasil = 655.1 + 9.6 * beratBadan + 1.9 * tinggiBadan / 4.7 * usia * levelAktifitas;
        }
        return Integer.parseInt(String.valueOf(hasil));
    }

    public static double hitungAir(double beratBadan, double levelAktifitas){
        double hasil ;
        hasil = beratBadan * 30 * levelAktifitas;
        return hasil;
    }
}