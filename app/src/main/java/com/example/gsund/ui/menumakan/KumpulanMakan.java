package com.example.gsund.ui.menumakan;

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
}
