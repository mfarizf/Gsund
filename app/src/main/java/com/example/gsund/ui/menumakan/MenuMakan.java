package com.example.gsund.ui.menumakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gsund.R;
import com.example.gsund.ui.kumpulanmakanan.KumpulanMakan;
import com.example.gsund.ui.main.MainActivity;

public class MenuMakan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_makan);
    }

    public void lihat_semua(View view) {
        Intent i = new Intent(MenuMakan.this, KumpulanMakan.class);
        startActivity(i);
    }
}
