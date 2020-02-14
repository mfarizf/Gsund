package com.example.gsund.ui.progress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gsund.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgressActivity extends AppCompatActivity {

    @BindView(R.id.cv_progress_makan)
    CardView cvProgressMakan;
    @BindView(R.id.btn_back)
    TextView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        ButterKnife.bind(this);

        cvProgressMakan.setOnClickListener(v -> {
            Intent detailProgressMakan = new Intent(ProgressActivity.this, ProgressMakanActivity.class);
            startActivity(detailProgressMakan);
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
