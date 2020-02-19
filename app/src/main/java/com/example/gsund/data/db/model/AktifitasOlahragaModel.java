package com.example.gsund.data.db.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AktifitasOlahragaModel extends RealmObject {

    @PrimaryKey
    private String id;
    private String nama;
    private int waktu;

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

    public int getWaktu() {
        return waktu;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }
}
