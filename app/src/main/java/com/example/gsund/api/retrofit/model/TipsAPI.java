package com.example.gsund.api.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class TipsAPI {
    @SerializedName("id")
    private int id;
    @SerializedName("judul")
    private String judul;
    @SerializedName("isi")
    private String deskripsi;
    @SerializedName("gambar")
    private String gambar;
    @SerializedName("konteks")
    private String konteks;

    public TipsAPI(int id, String judul, String deskripsi, String gambar, String konteks) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
        this.konteks = konteks;
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

    public String getKonteks() {
        return konteks;
    }

    public void setKonteks(String konteks) {
        this.konteks = konteks;
    }
}
