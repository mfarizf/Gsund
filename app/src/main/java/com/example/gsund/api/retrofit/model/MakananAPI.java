package com.example.gsund.api.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class MakananAPI {
    @SerializedName("id")
    private int id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("jenis")
    private String jenis;
    @SerializedName("kategori")
    private String kategori;
    @SerializedName("kalori")
    private int kalori;
    @SerializedName("gambar")
    private String gambar;
    @SerializedName("deksripsi")
    private String deskripsi;

    // Constructornya
    public MakananAPI(int id, String nama, String jenis, String kategori, int kalori, String gambar, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.kategori = kategori;
        this.kalori = kalori;
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

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getKalori() {
        return kalori;
    }

    public void setKalori(int kalori) {
        this.kalori = kalori;
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
