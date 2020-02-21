package com.example.gsund.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.gsund.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class UbahData extends AppCompatActivity {
    @BindView(R.id.update_input_bb)
    EditText updateBB;
    @BindView(R.id.update_input_tb)
    EditText updateTB;
    @BindView(R.id.update_input_riwayat_penyakit)
    EditText updatePenyakit;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_data);
        ButterKnife.bind(this);

        Realm.init(UbahData.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);



    }
}
