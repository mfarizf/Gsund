package com.example.gsund.ui.progress;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gsund.R;
import com.example.gsund.data.db.helper.AktifitasMakanHelper;
import com.example.gsund.data.db.model.AktifitasMakanModel;
import com.example.gsund.data.prefs.PreferencesManager;
import com.example.gsund.ui.menu.DetailData;
import com.skydoves.progressview.ProgressView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ProgressMakanActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    TextView btnBack;
    @BindView(R.id.progress_makan)
    ProgressView progressMakan;
    @BindView(R.id.progress_karbo)
    ProgressView progressKarbo;
    @BindView(R.id.progress_lemak)
    ProgressView progressLemak;
    @BindView(R.id.progress_protein)
    ProgressView progressProtein;
    @BindView(R.id.progress_lemak_text) TextView lemakText;
    @BindView(R.id.progress_karbo_text) TextView karboText;
    @BindView(R.id.progress_protein_text) TextView proteinText;

    Realm realm;
    PreferencesManager preferencesManager;
    AktifitasMakanHelper aktifitasMakanHelper;
    List<AktifitasMakanModel> list = new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_makan);
        ButterKnife.bind(this);
        preferencesManager = new PreferencesManager(this);

        Realm.init(ProgressMakanActivity.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        Date date = Calendar.getInstance().getTime();
        @SuppressLint("SimpleDateFormat")
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = simpleDateFormat.format(date);

        list = aktifitasMakanHelper.getMakanByDate(dateString);

        progressMakan.setMax(Float.parseFloat(preferencesManager.getBMR()));
        progressKarbo.setMax(Float.parseFloat(preferencesManager.getKarbohidrat()));
        progressLemak.setMax(Float.parseFloat(preferencesManager.getLemak()));
        progressProtein.setMax(Float.parseFloat(preferencesManager.getProtein()));

        for (int i = 0;i <list.size();i++){
            progressProtein.setProgress(Float.parseFloat(list.get(i).getProtein()));
            progressLemak.setProgress(Float.parseFloat(list.get(i).getLemak()));
            progressKarbo.setProgress(Float.parseFloat(list.get(i).getKarbohidrat()));
            progressMakan.setProgress(Float.parseFloat(list.get(i).getKalori()));
        }
//        progressMakan.setProgress(Float.parseFloat(preferencesManager.getBMR()));
//        progressKarbo.setProgress(50);
//        progressLemak.setProgress(50);
//        progressProtein.setProgress(50);

        progressMakan.setLabelText(String.valueOf(progressMakan.getProgress()));
        lemakText.setText(progressLemak.getProgress()+" gr");
        proteinText.setText(progressProtein.getProgress()+" gr");
        karboText.setText(progressKarbo.getProgress()+" gr");

        btnBack.setOnClickListener(v -> finish());
    }
}
