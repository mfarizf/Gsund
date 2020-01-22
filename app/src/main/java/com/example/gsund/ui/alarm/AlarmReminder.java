package com.example.gsund.ui.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gsund.R;
import com.example.gsund.ui.main.MainActivity;

import butterknife.OnClick;

public class AlarmReminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_reminder);
    }
    @OnClick(R.id.fab_add)
    void addAlarm(){
        startActivity(new Intent(AlarmReminder.this, AddReminder.class));
    }


}
