package com.example.gsund.data.db.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AktifitasMakanModel extends RealmObject {

    @PrimaryKey
    private
    int id;
    private String nama;
    private String tanggal;
    private int protein;
    private int lemak;
    private int karbohidrat;
    private int kalori;

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

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getKalori() {
        return kalori;
    }

    public void setKalori(int kalori) {
        this.kalori = kalori;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getLemak() {
        return lemak;
    }

    public void setLemak(int lemak) {
        this.lemak = lemak;
    }

    public int getKarbohidrat() {
        return karbohidrat;
    }

    public void setKarbohidrat(int karbohidrat) {
        this.karbohidrat = karbohidrat;
    }
}
