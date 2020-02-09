package com.example.gsund.api.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class RekomendasiAPI {
    @SerializedName("id")
    private int id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("gambar")
    private String gambar;
    @SerializedName("tipe")
    private String tipe;

    public RekomendasiAPI(int id, String nama, String deskripsi, String gambar, String tipe) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
        this.tipe = tipe;
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

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
}
