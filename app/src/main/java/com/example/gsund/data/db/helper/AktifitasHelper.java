package com.example.gsund.data.db.helper;

import com.example.gsund.data.db.model.AktifitasModel;

import org.jetbrains.annotations.NotNull;

import io.realm.Realm;

public class AktifitasHelper {
    private Realm realm;

    public AktifitasHelper(Realm realm){
        this.realm = realm;
    }

    public void save (final AktifitasModel aktifitasModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NotNull Realm realm) {

            }
        });
    }

//    public List<AktifitasModel> getAllAktifitas(){
//        return AktifitasModel;
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
