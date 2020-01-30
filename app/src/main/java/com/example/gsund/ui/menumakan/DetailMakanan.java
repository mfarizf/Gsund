package com.example.gsund.ui.menumakan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gsund.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailMakanan extends AppCompatActivity {

    @BindView(R.id.img_makanan)
    ImageView imgMakanan;
    @BindView(R.id.tv_nama_makanan)
    TextView tvNamaMakanan;
    @BindView(R.id.tv_kalori_makanan)
    TextView tvKaloriMakanan;
    @BindView(R.id.btn_beli)
    Button btnBeli;

    private String NamaMakanan, Jenis;
    private int KaloriMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);
        // Bindview
        ButterKnife.bind(this);

        Intent intent = getIntent();

        NamaMakanan = intent.getStringExtra("nama_makanan");
        KaloriMakanan = intent.getIntExtra("kalori_makanan", 0);
        Jenis = intent.getStringExtra("jenis");

        tvNamaMakanan.setText(NamaMakanan);
        tvKaloriMakanan.setText(String.valueOf(KaloriMakanan));

        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beliMakanan(NamaMakanan, Jenis);
            }
        });
    }

    private void beliMakanan(String namaMakanan, String jenis) {
        Intent browserIntent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.tokopedia.com/search?st=product&q=" + jenis + " " + namaMakanan)
        );
        startActivity(browserIntent);

        Toast.makeText(this, "Mencari " + namaMakanan + " di Tokopedia!", Toast.LENGTH_SHORT).show();
    }

}
