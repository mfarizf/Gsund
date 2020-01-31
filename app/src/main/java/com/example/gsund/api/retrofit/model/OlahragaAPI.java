package com.example.gsund.api.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class OlahragaAPI {
    @SerializedName("id")
    private int id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("jenis")
    private String jenis;
    @SerializedName("gambar")
    private String gambar;
    @SerializedName("deskripsi")
    private String deskripsi;

    public OlahragaAPI(int id, String nama, String jenis, String gambar, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
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

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
