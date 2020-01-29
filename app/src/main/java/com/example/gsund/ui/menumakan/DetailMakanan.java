package com.example.gsund.ui.menumakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gsund.R;
import com.example.gsund.ui.main.MainActivity;
import com.example.gsund.ui.timer.TimerOlahraga;

import butterknife.OnClick;

public class DetailMakanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);

        final Button button = (Button) findViewById(R.id.btn_mulai_diet);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(DetailMakanan.this, TimerOlahraga.class));            }
        });
    }

}
