package com.example.gsund.ui.menu;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.gsund.R;
import com.example.gsund.data.db.helper.AktifitasMakanHelper;
import com.example.gsund.data.db.model.AktifitasMakanModel;
import com.example.gsund.ui.main.MainActivity;
import com.example.gsund.ui.progress.ProgressMakanActivity;
import com.example.gsund.ui.timer.TimerOlahraga;

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

public class DetailData extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.img_gambar)
    ImageView imgGambar;
    @BindView(R.id.tv_judul)
    TextView tvJudul;
    @BindView(R.id.tv_subjudul)
    TextView tvSubjudul;
    @BindView(R.id.btn_action)
    Button btnAction;
    @BindView(R.id.tv_deskripsi)
    TextView tvDeskripsi;
    @BindView(R.id.btn_back)
    ImageView btnBack;

    // Inisialisasi ACTION
    public final String EXTRA_ACTION = "extra_action";
    public final String ACTION_MAKANAN = "beli";
    public final String ACTION_OLAHRAGA = "mulai_olahraga";
    public final String ACTION_PENYAKIT = "pelajari_penyakit";
    public final String ACTION_DIET = "pelajari_diet";

    public final String JUDUL = "judul";
    public final String SUBJUDUL = "subjudul";
    public final String GAMBAR = "gambar";
    public final String DESKRIPSI = "deskripsi";
    public final String PROTEIN = "protein";
    public final String KARBOHIDRAT = "karbo";
    public final String LEMAK = "lemak";
    public final String KALORI = "kalori";

    // Sound
    SoundPool sp;
    int soundId;
    boolean spLoaded = false;
    Realm realm;
    String action, judul, subjudul, gambar, deskripsi, kalori, lemak, protein, karbo;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);
        // Bindview
        ButterKnife.bind(this);

        Intent intent = getIntent();
        // Set Value
        action = intent.getStringExtra(EXTRA_ACTION);
        judul = intent.getStringExtra(JUDUL);
        subjudul = intent.getStringExtra(SUBJUDUL);
        gambar = intent.getStringExtra(GAMBAR);
        deskripsi = intent.getStringExtra(DESKRIPSI);

        Realm.init(DetailData.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        tvJudul.setText(judul);
        tvSubjudul.setText(String.valueOf(subjudul));
        tvDeskripsi.setText(deskripsi);
        Glide.with(this)
                .load(gambar)
                .into(imgGambar);

        btnAction.setOnClickListener(this);
        btnBack.setOnClickListener(v -> finish());

        // Cek Action Apa yang digunakan
        assert action != null;
        switch (action) {
            case ACTION_MAKANAN:
                btnAction.setText("Makan");
                break;
            case ACTION_DIET:
                Toast.makeText(this, "Upgrade ke premium untuk menggunakan fitur ini! ^_^", Toast.LENGTH_SHORT).show();
                btnAction.setText("Yuk Diet!");
                break;
            case ACTION_PENYAKIT:
                btnAction.setText("Pelajari Penyakit");
                break;
            case ACTION_OLAHRAGA:
                btnAction.setText("Yuk Olahraga!");
                break;
            default:
                Toast.makeText(this, "Opps! Kayaknya ada kesalahan nih!", Toast.LENGTH_SHORT).show();
                break;
        }

        // Sound
        sp = new SoundPool.Builder()
                .setMaxStreams(10)
                .build();
        sp.setOnLoadCompleteListener((soundPool, sampleId, status) -> {
            if (status == 0) {
                spLoaded = true;
            } else {
                Toast.makeText(DetailData.this, "Gagal load", Toast.LENGTH_SHORT).show();
            }
        });
        soundId = sp.load(this, R.raw.tokopedia, 1);
    }

    @Override
    public void onClick(View v) {
        Intent dataIntent = getIntent();
        String keyword = dataIntent.getStringExtra(JUDUL);
        String action = dataIntent.getStringExtra(EXTRA_ACTION);

        assert action != null;
        switch (action) {
            case ACTION_MAKANAN:
                makan();
                break;
            case ACTION_DIET:
                pelajariDiet(keyword);
                break;
            case ACTION_PENYAKIT:
                pelajariPenyakit(keyword);
                break;
            case ACTION_OLAHRAGA:
                olahraga();
                break;
            default:
                Toast.makeText(this, "Opps! Kayaknya ada kesalahan nih!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @SuppressLint("Assert")
    private void makan() {
//        Intent browserIntent = new Intent(
//                Intent.ACTION_VIEW,
//                Uri.parse("https://www.tokopedia.com/search?st=product&q=" + keyword)
//        );
//        startActivity(browserIntent);
//        if (spLoaded) {
//            sp.play(soundId, 1f, 1f, 0, 0, 1f);
//        }
//        Toast.makeText(this, "Mencari " + keyword + " di Tokopedia! ^_^", Toast.LENGTH_SHORT).show();\
        AktifitasMakanModel model = null;
        AktifitasMakanHelper aktifitasMakanHelper = new AktifitasMakanHelper(realm);

        Intent intent = getIntent();

        kalori = intent.getStringExtra(KALORI);
        lemak = intent.getStringExtra(LEMAK);
        protein = intent.getStringExtra(PROTEIN);
        karbo = intent.getStringExtra(KARBOHIDRAT);

        Date date = Calendar.getInstance().getTime();
        @SuppressLint("SimpleDateFormat")
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = simpleDateFormat.format(date);

        assert false;
        model.setKalori(kalori);
        model.setKarbohidrat(karbo);
        model.setLemak(lemak);
        model.setNama(judul);
        model.setProtein(protein);
        model.setTanggal(dateString);

        aktifitasMakanHelper.save(model);
        startActivity(new Intent(DetailData.this, ProgressMakanActivity.class));
    }

    private void pelajariDiet(String keyword) {
        Intent intentDiet = new Intent(Intent.ACTION_WEB_SEARCH);
        intentDiet.putExtra(SearchManager.QUERY, keyword);
        startActivity(intentDiet);

        Toast.makeText(this, "Pelajari " + keyword + " lebih lengkap di Google! ^_^", Toast.LENGTH_SHORT).show();
    }

    private void pelajariPenyakit(String keyword) {
        Intent intentPenyakit = new Intent(Intent.ACTION_WEB_SEARCH);
        intentPenyakit.putExtra(SearchManager.QUERY, keyword);
        startActivity(intentPenyakit);

        Toast.makeText(this, "Pelajari " + keyword + " lebih lengkap di Google! ^_^", Toast.LENGTH_SHORT).show();
    }

    private void olahraga() {
        // Pindah ke Intent Olahraga
        Intent intentOlahraga = new Intent(DetailData.this, TimerOlahraga.class);
        startActivity(intentOlahraga);
        Toast.makeText(this, "Yuk mulai olahraga! ^_^", Toast.LENGTH_SHORT).show();
    }
}
