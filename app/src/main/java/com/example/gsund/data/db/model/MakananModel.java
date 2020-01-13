package com.example.gsund.data.db.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MakananModel extends RealmObject {

    @PrimaryKey
    private
    String id;
    private String nama;
    private String jenis;
    private String kategori;
    private int kalori;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getKalori() {
        return kalori;
    }

    public void setKalori(int kalori) {
        this.kalori = kalori;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
