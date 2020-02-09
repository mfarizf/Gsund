package com.example.gsund;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;

import com.example.gsund.utils.AlarmNotification;

import butterknife.BindView;

public class Settings extends AppCompatActivity {

    @BindView(R.id.repeat_switches)
    Switch rSwitch;

    AlarmNotification alarmNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        rSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                getDrinkAlarm();
                rSwitch.setChecked(true);
            }else{
                cancelAlarm();
                rSwitch.setChecked(false);
            }
        });
    }

    private  void getDrinkAlarm() {
        String title = "Minum Air";
        String message = "Jangan Lupa Minum Air 2 Liter/Hari !";
        int notifID = 101;

        alarmNotification.showNotification(getApplicationContext(), title, message, notifID);
        alarmNotification.setRepeatingAlarm(this, alarmNotification.TYPE_REPEATING, "30", message);

    }

    private  void cancelAlarm(){
        alarmNotification.cancelAlarm(this,alarmNotification.TYPE_REPEATING);
    }
}
