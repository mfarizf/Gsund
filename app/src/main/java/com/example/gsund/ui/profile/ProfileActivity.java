package com.example.gsund.ui.profile;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.gsund.R;
import com.example.gsund.Settings;
import com.example.gsund.data.prefs.PreferencesManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import mobi.gspd.segmentedbarview.Segment;
import mobi.gspd.segmentedbarview.SegmentedBarView;


public class ProfileActivity extends AppCompatActivity implements ProfileCallback {
    @BindView(R.id.picture_profile)
    CircleImageView imageProfile;
    @BindView(R.id.setting)
    ImageView settings;
    @BindView(R.id.profil_nama)
    TextView nama;
    @BindView(R.id.profil_tb)
    TextView tinggiBadan;
    @BindView(R.id.profil_bb)
    TextView beratBadan;
    @BindView(R.id.profil_penyakit)
    TextView penyakit;
    @BindView(R.id.profil_umur)
    TextView umur;
    @BindView(R.id.profil_jenkel)
    TextView jenkel;
    @BindView(R.id.profil_nama_panggilan)
    TextView namaPanggilan;
    @BindView(R.id.bar_view)
    SegmentedBarView barView;

    private ProfilePresenter profilePresenter;

    PreferencesManager preferencesManager;
    List<Segment> segments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        preferencesManager = new PreferencesManager(this);

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        Realm realm = Realm.getInstance(configuration);

        profilePresenter = new ProfilePresenter(ProfileActivity.this, this, realm, preferencesManager);

        Glide.with(this).load(R.drawable.pic_sample_1).into(imageProfile);
        Glide.with(this).load(R.drawable.ic_settings_black_24dp).into(settings);

        Segment segment = new Segment(0, 18.5f, "Underweight", Color.parseColor("#37CAFB"));
        segments.add(segment);
        Segment segment2 = new Segment(18.5f, 23f, "Normal", Color.parseColor("#93E789"));
        segments.add(segment2);
        Segment segment3 = new Segment(23f, 30f, "Overweight", Color.parseColor("#FADF66"));
        segments.add(segment3);
        Segment segment4 = new Segment(30f,48.5f, "Obese", Color.parseColor("#FC8703"));
        segments.add(segment4);
        barView.setSegments(segments);
        barView.setValueWithUnit(Float.parseFloat(preferencesManager.getBMI())," "); /* You can use Html tags here in unit to support superscript and subscript */

        profilePresenter.getUser(namaPanggilan, nama, tinggiBadan, beratBadan, penyakit, umur, jenkel);

    }


    @OnClick(R.id.setting)
    void setting(){
        startActivity(new Intent(ProfileActivity.this, Settings.class));
    }

    @OnClick(R.id.update_data)
    void ubahData(){
        startActivity(new Intent(ProfileActivity.this, UbahData.class));
    }

}
