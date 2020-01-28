package com.example.gsund.api.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class TipsAPI {
    @SerializedName("id")
    private int id;
    @SerializedName("judul")
    private String judul;
    @SerializedName("isi")
    private String isi;
    @SerializedName("gambar")
    private String gambar;

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

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
