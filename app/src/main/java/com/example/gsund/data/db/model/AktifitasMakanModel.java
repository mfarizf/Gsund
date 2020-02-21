package com.example.gsund.data.db.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AktifitasMakanModel extends RealmObject {

    @PrimaryKey
    private
    int id;
    private String nama;
    private String tanggal;
    private String protein;
    private String lemak;
    private String karbohidrat;
    private String kalori;

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

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getLemak() {
        return lemak;
    }

    public void setLemak(String lemak) {
        this.lemak = lemak;
    }

    public String getKarbohidrat() {
        return karbohidrat;
    }

    public void setKarbohidrat(String karbohidrat) {
        this.karbohidrat = karbohidrat;
    }

    public String getKalori() {
        return kalori;
    }

    public void setKalori(String kalori) {
        this.kalori = kalori;
    }
}
