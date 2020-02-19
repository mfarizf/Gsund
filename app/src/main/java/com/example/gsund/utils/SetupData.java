package com.example.gsund.utils;

import com.example.gsund.data.db.helper.UserHelper;
import com.example.gsund.data.db.model.AktifitasMakanModel;
import com.example.gsund.data.db.model.AktifitasOlahragaModel;
import com.example.gsund.data.db.model.UserModel;
import com.example.gsund.data.prefs.PreferencesManager;

import java.util.List;

import io.realm.Realm;

public class SetupData  {
    private final Realm realm;
    private final PreferencesManager preferencesManager;
    List<UserModel> userModels;
    UserHelper userHelper;

    public SetupData(Realm realm, PreferencesManager preferencesManager){
        this.realm = realm;
        this.preferencesManager = preferencesManager;
    }

    public List<AktifitasMakanModel> setMakanan(List<AktifitasMakanModel> aktifitasMakanModels){
        userModels = userHelper.getUser(preferencesManager.getId());

        return aktifitasMakanModels;
    }

    public List<AktifitasOlahragaModel> setOlahraga(List<AktifitasOlahragaModel> aktifitasOlahragaModels){
        return aktifitasOlahragaModels;
    }

    public void LoadData(){

    }

}
