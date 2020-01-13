package com.example.gsund.data.db.helper;

import com.example.gsund.data.db.model.DietModel;

import io.realm.Realm;

public class DietHelper {
    private Realm realm;

    public DietHelper(Realm realm){
        this.realm = realm;
    }

    public void save (final DietModel dietModel){
        realm.executeTransaction(realm -> {

        });
    }

//    public List<DietModel> getAllDiet(){
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
