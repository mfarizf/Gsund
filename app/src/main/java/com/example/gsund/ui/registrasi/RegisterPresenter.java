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
    private HitungKebutuhan hitungKebutuhan;

    RegisterPresenter(Context context, RegisterCallback registerCallback, Realm realm, PreferencesManager preferencesManager) {
        this.context = context;
        this.registerCallback = registerCallback;
        this.realm = realm;
        this.preferencesManager = preferencesManager;
    }

    void getUser(String nama, int umur, int bb, int tb, String riwayatPenyakit){
        UserModel userModel = new UserModel();
        userModel.setNama(nama);
        userModel.setUmur(umur);
        userModel.setBeratBadan(bb);
        userModel.setTinggiBadan(tb);
//        userModel.setJenisKelamin();
        userModel.setRiwayatPenyakit(riwayatPenyakit);

        UserHelper userHelper = new UserHelper(realm);
        userHelper.save(userModel);

        hitungKebutuhan = new HitungKebutuhan();

//        preferencesManager.setBMR(hitungKebutuhan.hitungBMR());
        preferencesManager.setFirst(false);
        preferencesManager.setId(userModel.getId());
        double bmi = hitungKebutuhan.hitungBMI(tb,bb);
        Log.d("BMI", String.valueOf(bmi));
        preferencesManager.setBMI(bmi);

        registerCallback.onSuccessRegister();

    }
}