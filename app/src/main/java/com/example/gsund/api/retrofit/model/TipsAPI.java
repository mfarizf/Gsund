package com.example.gsund.api.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class TipsAPI {
    @SerializedName("id")
    private int id;
    @SerializedName("judul")
    private String judul;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("gambar")
    private String gambar;

    public TipsAPI(int id, String judul, String deskripsi, String gambar) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
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
