package com.example.gsund.ui.progress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gsund.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgressMakanActivity extends AppCompatActivity {

    @BindView(R.id.btn_back)
    TextView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_makan);
        ButterKnife.bind(this);

        btnBack.setOnClickListener(v -> finish());
    }
}
