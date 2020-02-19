package com.example.gsund.ui.registrasi;

import android.content.Context;
import android.util.Log;

import com.example.gsund.data.db.helper.UserHelper;
import com.example.gsund.data.db.model.UserModel;
import com.example.gsund.data.prefs.PreferencesManager;
import com.example.gsund.utils.HitungKebutuhan;

import io.realm.Realm;

class RegisterPresenter {
    private final Context context;
    private final RegisterCallback registerCallback;
    private final Realm realm;
    private final PreferencesManager preferencesManager;

    RegisterPresenter(Context context, RegisterCallback registerCallback, Realm realm, PreferencesManager preferencesManager) {
        this.context = context;
        this.registerCallback = registerCallback;
        this.realm = realm;
        this.preferencesManager = preferencesManager;
    }

    void getUser(String nama, String namaPanggilan,int umur, int bb, int tb, String riwayatPenyakit, String jenkel, String intensOlahraga){
        UserModel userModel = new UserModel();
        userModel.setNama(nama);
        userModel.setNamaPanggilan(namaPanggilan);
        userModel.setUmur(umur);
        userModel.setBeratBadan(bb);
        userModel.setTinggiBadan(tb);
        userModel.setJenisKelamin(jenkel.toLowerCase());
        userModel.setIntensitasOlahraga(intensOlahraga);
        userModel.setRiwayatPenyakit(riwayatPenyakit);

        UserHelper userHelper = new UserHelper(realm);
        userHelper.save(userModel);

        HitungKebutuhan hitungKebutuhan = new HitungKebutuhan();

        preferencesManager.setFirst(false);
        preferencesManager.setId(userModel.getId());
        double bmi = hitungKebutuhan.hitungBMI(tb,bb);
        double bmr = hitungKebutuhan.hitungBMR(jenkel, tb, bb, umur, intensOlahraga);
        preferencesManager.setBMI(bmi);
        preferencesManager.setBMR(bmr);
        preferencesManager.setAir(hitungKebutuhan.hitungAir(bb,intensOlahraga));
        preferencesManager.setKarbohidrat(hitungKebutuhan.hitungKarbohidrat(bmr));
        preferencesManager.setLemak(hitungKebutuhan.hitungLemak(bmr));
        preferencesManager.setProtein(hitungKebutuhan.hitungProtein(bmr));

        registerCallback.onSuccessRegister();

    }
}