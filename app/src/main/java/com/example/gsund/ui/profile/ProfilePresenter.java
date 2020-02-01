package com.example.gsund.ui.profile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import com.example.gsund.data.db.helper.UserHelper;
import com.example.gsund.data.db.model.UserModel;
import com.example.gsund.data.prefs.PreferencesManager;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ProfilePresenter {
    private final Context context;
    private final ProfileCallback profileCallback;
    private final Realm realm;
    private final PreferencesManager preferencesManager;

    public ProfilePresenter(Context context, ProfileCallback profileCallback, Realm realm, PreferencesManager preferencesManager) {
        this.context = context;
        this.profileCallback = profileCallback;
        this.realm = realm;
        this.preferencesManager = preferencesManager;
    }

    @SuppressLint("SetTextI18n")
    void getUser(TextView namaPanggilan,TextView nama, TextView tb, TextView bb, TextView penyakit, TextView umur, TextView jenkel){
        List<UserModel> userModel;
        UserHelper userHelper = new UserHelper(realm);

        userModel = userHelper.getUser(preferencesManager.getId());

        nama.setText(userModel.get(0).getNama());
        namaPanggilan.setText(userModel.get(0).getNamaPanggilan());
        tb.setText(userModel.get(0).getTinggiBadan() +" CM");
        bb.setText(userModel.get(0).getBeratBadan() +" KG");
        penyakit.setText(userModel.get(0).getRiwayatPenyakit());
        umur.setText(userModel.get(0).getUmur() +" Tahun");
        jenkel.setText(userModel.get(0).getJenisKelamin());

    }
}
