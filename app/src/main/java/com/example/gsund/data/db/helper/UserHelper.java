package com.example.gsund.data.db.helper;

import android.util.Log;

import com.example.gsund.data.db.model.UserModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class UserHelper {
    private Realm realm;

    public UserHelper(Realm realm){
        this.realm = realm;
    }

    public void save (final UserModel userModel){
        realm.executeTransaction(realm -> {
            Log.e("Created","Database was Created");
            Number currentIdNum = realm.where(UserModel.class).max("id");
            int nextId;
            if (currentIdNum == null){
                nextId = 1;
            }else{
                nextId = currentIdNum.intValue() +1;
            }
            userModel.setId(nextId);
            UserModel model = realm.copyToRealm(userModel);
        });
    }

    public List<UserModel> getAllUser(){
        return realm.where(UserModel.class).findAll();
    }

    public List<UserModel> getUser(Integer id){
        return realm.where(UserModel.class).equalTo("id",id).findAll();
    }

    public void update(final Integer id, final String nama,final Integer umur, final Integer bb, final Integer tb, final String riwayatPenyakit){
        realm.executeTransactionAsync(realm -> {
            UserModel model =realm.where(UserModel.class)
                    .equalTo("id",id)
                    .findFirst();
            assert model != null;
            model.setNama(nama);
            model.setUmur(umur);
            model.setBeratBadan(bb);
            model.setTinggiBadan(tb);
            model.setRiwayatPenyakit(riwayatPenyakit);
        }, () -> Log.e("Success","Update Success"), Throwable::printStackTrace);
    }

    public void delete(Integer id){
        final RealmResults<UserModel> realmResults = realm.where(UserModel.class).equalTo("id",id).findAll();
        realm.executeTransaction(realm -> realmResults.deleteFromRealm(0));
    }
}
