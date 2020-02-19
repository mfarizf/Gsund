package com.example.gsund.data.db.helper;

import com.example.gsund.data.db.model.AktifitasOlahragaModel;

import io.realm.Realm;

public class AktifitasOlahragaHelper {
    private Realm realm;

    public AktifitasOlahragaHelper(Realm realm){
        this.realm = realm;
    }

    public void save (final AktifitasOlahragaModel aktifitasOlahragaModel){
        realm.executeTransaction(realm -> {

        });
    }

//    public List<AktifitasOlahragaModel> getAllOlahraga(){
//
//    }

    public void update(){
        realm.executeTransactionAsync(realm -> {

        }, () -> {

        }, error -> {

        });
    }

    public void delete(){

    }
}
