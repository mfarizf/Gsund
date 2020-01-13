package com.example.gsund.data.db.helper;

import com.example.gsund.data.db.model.MakananModel;

import io.realm.Realm;

public class MakananHelper {
    Realm realm;

    public MakananHelper(Realm realm){
        this.realm = realm;
    }

    public void save (final MakananModel makananModel){
        realm.executeTransaction(realm -> {

        });
    }

//    public List<MakananModel> getAllMakanan(){
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
