package com.example.gsund.ui.tips;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gsund.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TipsActivity extends AppCompatActivity {
    @BindView(R.id.gambar)
    ImageView gambar;
    @BindView(R.id.judul_tips)
    TextView judulTips;
    @BindView(R.id.deskripsi_tips)
    TextView deskripsiTips;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String judul = intent.getStringExtra("judul");
        String deskripsi = intent.getStringExtra("deskripsi");

        Glide.with(this).load(intent.getStringExtra("gambar")).into(gambar);
        judulTips.setText(judul);
        deskripsiTips.setText(deskripsi);

    }
}
