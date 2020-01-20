package com.example.gsund.ui.registrasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gsund.R;
import com.example.gsund.data.db.helper.UserHelper;
import com.example.gsund.data.db.model.UserModel;
import com.example.gsund.data.prefs.PreferencesManager;
import com.example.gsund.ui.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RegisterActivity extends AppCompatActivity implements RegisterCallback {
    @BindView(R.id.btn_daftar) Button btn_daftar;
    @BindView(R.id.register_input_nama) EditText nama;
    @BindView(R.id.register_input_umur) EditText umur;
    @BindView(R.id.register_input_bb) EditText beratBadan;
    @BindView(R.id.register_input_tb) EditText tinggiBadan;
    @BindView(R.id.register_input_riwayat_penyakit) EditText riwayatPenyakit;

    PreferencesManager preferencesManager;
    Realm realm;
    RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        preferencesManager = new PreferencesManager(this);

        Realm.init(RegisterActivity.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        registerPresenter = new RegisterPresenter(RegisterActivity.this,this,realm,preferencesManager);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        new Handler().removeCallbacksAndMessages(null);
    }

    @OnClick(R.id.btn_daftar)
    public void daftar(View view){
        if  (!nama.getText().toString().equals("") &&
                !umur.getText().toString().equals("") &&
                        !beratBadan.getText().toString().equals("") &&
                                !tinggiBadan.getText().toString().equals("") &&
                                        !riwayatPenyakit.getText().toString().equals("")){

            String namaUser = nama.getText().toString();
            int umurUser = Integer.parseInt(umur.getText().toString());
            int bb = Integer.parseInt(beratBadan.getText().toString());
            int tb = Integer.parseInt(tinggiBadan.getText().toString());
            String riwayatPenyakitUser = riwayatPenyakit.getText().toString();

            if  (!namaUser.isEmpty() &&
                    umurUser != 0 &&
                    bb != 0 &&
                    tb != 0 &&
                    !riwayatPenyakitUser.isEmpty()) {
                registerPresenter.getUser(namaUser, umurUser, bb, tb, riwayatPenyakitUser);
            }else{
                Toast.makeText(RegisterActivity.this, "Isi Semua Field", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "Gagal", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onErrorRegister() {

    }

    @Override
    public void onSuccessRegister() {

        startActivity(new Intent(RegisterActivity.this,MainActivity.class));
        finish();
    }
}
