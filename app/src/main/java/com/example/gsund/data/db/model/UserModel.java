package com.example.gsund.data.db.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserModel extends RealmObject {

    @PrimaryKey
    private int id;
    private String nama;
    private String namaPanggilan;
    private int umur;
    private int beratBadan;
    private int tinggiBadan;
    private String jenisKelamin;
    private String riwayatPenyakit;
    private String intensitasOlahraga;

    public String getNamaPanggilan() {
        return namaPanggilan;
    }

    public void setNamaPanggilan(String namaPanggilan) {
        this.namaPanggilan = namaPanggilan;
    }

    public String getIntensitasOlahraga() {
        return intensitasOlahraga;
    }

    public void setIntensitasOlahraga(String intensitasOlahraga) {
        this.intensitasOlahraga = intensitasOlahraga;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public int getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(int beratBadan) {
        this.beratBadan = beratBadan;
    }

    public int getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(int tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public String getRiwayatPenyakit() {
        return riwayatPenyakit;
    }

    public void setRiwayatPenyakit(String riwayatPenyakit) {
        this.riwayatPenyakit = riwayatPenyakit;
    }
}
