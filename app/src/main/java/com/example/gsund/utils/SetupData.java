package com.example.gsund.utils;

import com.example.gsund.data.db.helper.UserHelper;
import com.example.gsund.data.db.model.MakananModel;
import com.example.gsund.data.db.model.OlahragaModel;
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

    public List<MakananModel> setMakanan(List<MakananModel> makananModels){
        userModels = userHelper.getUser(preferencesManager.getId());

        return makananModels;
    }

    public List<OlahragaModel> setOlahraga(List<OlahragaModel> olahragaModels){
        return olahragaModels;
    }

}
