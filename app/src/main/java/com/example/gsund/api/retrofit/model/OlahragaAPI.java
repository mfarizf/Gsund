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

    public OlahragaAPI(int id, String nama, String jenis, String gambar){
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
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
}
