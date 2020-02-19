package com.example.gsund.data.db.helper;

import android.util.Log;

import com.example.gsund.data.db.model.AktifitasMakanModel;

import java.util.List;

import io.realm.Realm;

public class AktifitasMakanHelper {
    private Realm realm;

    public AktifitasMakanHelper(Realm realm){
        this.realm = realm;
    }

    public void save (final AktifitasMakanModel aktifitasMakanModel){
        realm.executeTransaction(realm -> {
            Log.e("Created","Database was Created");
            Number currentIdNum = realm.where(AktifitasMakanModel.class).max("id");
            int nextId;
            if (currentIdNum == null){
                nextId = 1;
            }else{
                nextId = currentIdNum.intValue() +1;
            }
            aktifitasMakanModel.setId(nextId);
            AktifitasMakanModel model = realm.copyToRealm(aktifitasMakanModel);
        });
    }

    public List<AktifitasMakanModel> getAllMakanan(){
        return realm.where(AktifitasMakanModel.class).findAll();
    }

    public List<AktifitasMakanModel> getMakanByDate(String date){
        return realm.where(AktifitasMakanModel.class).equalTo("tanggal",date).findAll();
    }

    public void update(){
        realm.executeTransactionAsync(realm -> {

        }, () -> {

        }, error -> {

        });
    }

    public void delete(){

    }
}
