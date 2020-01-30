package com.example.gsund.ui.menumakan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gsund.R;
import com.example.gsund.api.retrofit.DataViewModel;
import com.example.gsund.api.retrofit.model.MakananAPI;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KumpulanMakan extends AppCompatActivity {

    @BindView(R.id.rv_makanan)
    public RecyclerView rvMakanan;
    @BindView(R.id.progressLoadAPI)
    public ProgressBar progressBar;
    private MakananAdapter makananAdapter;

    private DataViewModel dataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kumpulan_makan);
        ButterKnife.bind(this);

        // Main View Model
        dataViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DataViewModel.class);

        rvMakanan.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(KumpulanMakan.this,2);
        rvMakanan.setLayoutManager(gridLayoutManager);
        makananAdapter = new MakananAdapter();
        makananAdapter.notifyDataSetChanged();
        rvMakanan.setAdapter(makananAdapter);

        // Set Listener Adapter
        makananAdapter.setOnItemClickCallback(new MakananAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(MakananAPI data) {
                moveToDetailActivity(data);
            }
        });

        showListMakanan();

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
        // Set Data
        dataViewModel.setDataMakanan();
        showLoading(true);

        // Get Data apabila sudah ada
        dataViewModel.getDataMakanan().observe(this, new Observer<ArrayList<MakananAPI>>() {
            @Override
            public void onChanged(ArrayList<MakananAPI> makananAPIS) {
                if (makananAPIS != null) {
                    makananAdapter.setData(makananAPIS);
                    showLoading(false);
                }
            }
        });
    }

    private void moveToDetailActivity(MakananAPI data) {
        Intent detailMakanan = new Intent(KumpulanMakan.this, DetailMakanan.class);
        detailMakanan.putExtra("nama_makanan", data.getNama());
        detailMakanan.putExtra("kalori_makanan", data.getKalori());
        detailMakanan.putExtra("jenis", data.getJenis());
        startActivity(detailMakanan);
    }
}
