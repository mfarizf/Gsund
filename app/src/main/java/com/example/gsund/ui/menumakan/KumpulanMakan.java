package com.example.gsund.ui.menumakan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.gsund.R;
import com.example.gsund.api.retrofit.response.MakananResponse;
import com.example.gsund.api.retrofit.model.MakananAPI;
import com.example.gsund.api.retrofit.network.ApiInterface;
import com.example.gsund.api.retrofit.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KumpulanMakan extends AppCompatActivity {
    private RecyclerView rvMakanan;
    private MakananAdapter makananAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kumpulan_makan);

        rvMakanan = findViewById(R.id.rv_makanan);
        rvMakanan.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(KumpulanMakan.this,2);
        rvMakanan.setLayoutManager(gridLayoutManager);


        ApiInterface service = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<MakananResponse> call = service.getListMakanan();

        call.enqueue(new Callback<MakananResponse>() {
            @Override
            public void onResponse(Call<MakananResponse> call, Response<MakananResponse> response) {
                MakananResponse makananResponse = response.body();
                makananAdapter = new MakananAdapter(makananResponse.getValues());
                rvMakanan.setAdapter(makananAdapter);
            }

            @Override
            public void onFailure(Call<MakananResponse> call, Throwable t) {
                Toast.makeText(KumpulanMakan.this, "Sesuatu salah!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupRecyclerMakanan(ArrayList<MakananAPI> makananDataList){
        makananAdapter = new MakananAdapter(makananDataList);


    }
}
