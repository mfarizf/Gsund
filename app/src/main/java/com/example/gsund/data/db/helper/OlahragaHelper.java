package com.example.gsund.data.db.helper;

import com.example.gsund.data.db.model.OlahragaModel;

import io.realm.Realm;

public class OlahragaHelper {
    private Realm realm;

    public OlahragaHelper(Realm realm){
        this.realm = realm;
    }

    public void save (final OlahragaModel olahragaModel){
        realm.executeTransaction(realm -> {

        });
    }

//    public List<OlahragaModel> getAllOlahraga(){
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
