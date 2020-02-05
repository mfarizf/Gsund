package com.example.gsund.ui.menumakan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.example.gsund.R;
import com.example.gsund.api.retrofit.DataViewModel;
import com.example.gsund.api.retrofit.model.OlahragaAPI;
import com.example.gsund.ui.main.adapter.DietAdapter;
import com.example.gsund.ui.main.adapter.MakananAdapter;
import com.example.gsund.ui.main.adapter.OlahragaAdapter;
import com.example.gsund.ui.main.adapter.PenyakitAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KumpulanData extends AppCompatActivity {

    @BindView(R.id.rv_data)
    public RecyclerView rvData;
    @BindView(R.id.progressLoadAPI)
    public ProgressBar progressBar;
    // Inisialisasi Semua Adapter yang ada
    private MakananAdapter makananAdapter;
    private OlahragaAdapter olahragaAdapter;
    private DietAdapter dietAdapter;
    private PenyakitAdapter penyakitAdapter;
    // Inisialisasi View Model
    private DataViewModel dataViewModel;
    // Inisialisasi Skeleton View
    SkeletonScreen skeletonListMakanan, skeletonListOlahraga, skeletonListDiet;
    // Inisialisasi Parameter yang dibutuhkan
    public final String EXTRA_ACTION = "extra_action";
    public final String MAKANAN = "makanan";
    public final String OLAHRAGA = "olahraga";
    public final String DIET = "diet";
    public final String PENYAKIT = "penyakit";
    public final String ACTION_MAKANAN = "beli";
    public final String ACTION_OLAHRAGA = "mulai_olahraga";
    public final String ACTION_PENYAKIT = "pelajari_penyakit";
    public final String ACTION_DIET = "pelajari_diet";
    public final String TIPE = "tipe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kumpulan_data);
        ButterKnife.bind(this);

        // Main View Model
        dataViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DataViewModel.class);
        // Set Recycler
        rvData.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(KumpulanData.this, 2);
        rvData.setLayoutManager(gridLayoutManager);

        // Get Data From Intent
        Intent intent = KumpulanData.this.getIntent();
//        Bundle bundle = intent.getExtras();
//        assert bundle != null;
        String tipe = intent.getStringExtra(TIPE);

        // Logic If
        assert tipe != null;
        switch (tipe) {
            case MAKANAN:
                showListMakanan();
                break;
            case OLAHRAGA:
                showListOlahraga();
                break;
            case PENYAKIT:
                showListPenyakit();
                break;
            case DIET:
                showListDiet();
                break;
            default:
                Toast.makeText(this, "Opps! sepertinya ada masalah nih!", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void showLoading(Boolean status) {
        if (status) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    // Makanan
    private void showListMakanan() {
        // Set Adapter
        makananAdapter = new MakananAdapter();
        makananAdapter.notifyDataSetChanged();
        rvData.setAdapter(makananAdapter);
        skeletonListMakanan = Skeleton.bind(rvData).adapter(makananAdapter).load(R.layout.item_makanan).show();

        // Set Data
        dataViewModel.setDataMakanan();

        // Get Data apabila sudah ada
        dataViewModel.getDataMakanan().observe(this, makananAPIS -> {
            if (makananAPIS != null) {
                makananAdapter.setData(makananAPIS);
                skeletonListMakanan.hide();
            }
        });

        makananAdapter.setOnItemClickCallback(data -> {
            Intent detailMakanan = new Intent(KumpulanData.this, DetailData.class);
            detailMakanan.putExtra("gambar", data.getGambar());
            detailMakanan.putExtra("judul", data.getNama());
            detailMakanan.putExtra("subjudul", data.getJenis());
            detailMakanan.putExtra("deskripsi", data.getDeskripsi());
            detailMakanan.putExtra(EXTRA_ACTION, ACTION_MAKANAN);
            startActivity(detailMakanan);
        });
    }

    // Penyakit
    private void showListPenyakit() {
        // Set Adapter
        penyakitAdapter = new PenyakitAdapter();
        penyakitAdapter.notifyDataSetChanged();
        rvData.setAdapter(penyakitAdapter);

        // Set Data
        dataViewModel.setDataPenyakit();
        showLoading(true);

        // Get Data apabila sudah ada
        dataViewModel.getDataPenyakit().observe(this, penyakitAPIS -> {
            if (penyakitAPIS != null) {
                penyakitAdapter.setData(penyakitAPIS);
                showLoading(false);
            }
        });

        penyakitAdapter.setOnItemClickCallback(data -> {
            Intent detailPenyakit = new Intent(KumpulanData.this, DetailData.class);
            detailPenyakit.putExtra("gambar", data.getGambar());
            detailPenyakit.putExtra("judul", data.getNama());
            detailPenyakit.putExtra("subjudul", "Penyakit");
            detailPenyakit.putExtra("deskripsi", data.getDeskripsi());
            detailPenyakit.putExtra(EXTRA_ACTION, ACTION_PENYAKIT);
            startActivity(detailPenyakit);
        });
    }

    // Diet
    private void showListDiet() {
        // Set Adapter
        dietAdapter = new DietAdapter();
        dietAdapter.notifyDataSetChanged();
        rvData.setAdapter(dietAdapter);
        skeletonListDiet = Skeleton.bind(rvData).adapter(dietAdapter).load(R.layout.item_diet).show();

        // Set Data
        dataViewModel.setDataDiet();

        // Get Data apabila sudah ada
        dataViewModel.getDataDiet().observe(this, dietAPIS -> {
            if (dietAPIS != null) {
                dietAdapter.setData(dietAPIS);
                skeletonListDiet.hide();
            }
        });

        dietAdapter.setOnItemClickCallback(data -> {
            Intent detailDiet = new Intent(KumpulanData.this, DetailData.class);
            detailDiet.putExtra("gambar", data.getGambar());
            detailDiet.putExtra("judul", data.getNama());
            detailDiet.putExtra("subjudul", "Salah satu jenis Diet");
            detailDiet.putExtra("deskripsi", data.getDeskripsi());
            detailDiet.putExtra(EXTRA_ACTION, ACTION_DIET);
            startActivity(detailDiet);
        });
    }

    // Olahraga
    private void showListOlahraga() {
        // Set Adapter
        olahragaAdapter = new OlahragaAdapter();
        olahragaAdapter.notifyDataSetChanged();
        rvData.setAdapter(olahragaAdapter);
        skeletonListOlahraga = Skeleton.bind(rvData).adapter(olahragaAdapter).load(R.layout.item_olahraga).show();

        // Set Data
        dataViewModel.setDataOlahraga();

        // Get Data apabila sudah ada
        dataViewModel.getDataOlahraga().observe(this, new Observer<ArrayList<OlahragaAPI>>() {
            @Override
            public void onChanged(ArrayList<OlahragaAPI> olahragaAPIS) {
                if (olahragaAPIS != null) {
                    olahragaAdapter.setData(olahragaAPIS);
                    skeletonListOlahraga.hide();
                }
            }
        });

        olahragaAdapter.setOnItemClickCallback(data -> {
            Intent detailOlahraga = new Intent(KumpulanData.this, DetailData.class);
            detailOlahraga.putExtra("gambar", data.getGambar());
            detailOlahraga.putExtra("judul", data.getNama());
            detailOlahraga.putExtra("subjudul", data.getJenis());
            detailOlahraga.putExtra("deskripsi", data.getDeskripsi());
            detailOlahraga.putExtra(EXTRA_ACTION, ACTION_OLAHRAGA);
            startActivity(detailOlahraga);
        });
    }
}
