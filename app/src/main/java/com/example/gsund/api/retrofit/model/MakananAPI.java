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
    @SerializedName("protein")
    private double protein;
    @SerializedName("lemak")
    private double lemak;
    @SerializedName("karbohidrat")
    private double karbohidrat;
    @SerializedName("gambar")
    private String gambar;
    @SerializedName("deskripsi")
    private String deskripsi;

    // Constructornya
    public MakananAPI(int id, String nama, String jenis, String kategori, int kalori,double protein, double lemak, double karbohidrat, String gambar, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.kategori = kategori;
        this.kalori = kalori;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
        this.karbohidrat = karbohidrat;
        this.protein = protein;
        this.lemak = lemak;
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

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getLemak() {
        return lemak;
    }

    public void setLemak(double lemak) {
        this.lemak = lemak;
    }

    public double getKarbohidrat() {
        return karbohidrat;
    }

    public void setKarbohidrat(double karbohidrat) {
        this.karbohidrat = karbohidrat;
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
