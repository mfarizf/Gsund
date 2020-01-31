package com.example.gsund.api.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class PenyakitAPI {
    @SerializedName("id")
    private int id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("gambar")
    private String gambar;

    public PenyakitAPI(int id, String nama, String deskripsi, String gambar) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
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
}
