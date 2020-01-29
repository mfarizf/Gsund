package com.example.gsund.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.kalert.KAlertDialog;
import com.example.gsund.R;
import com.example.gsund.data.db.helper.UserHelper;
import com.example.gsund.data.db.model.UserModel;
import com.example.gsund.data.prefs.PreferencesManager;
import com.example.gsund.ui.alarm.AlarmReminder;
import com.example.gsund.ui.main.adapter.OptionAdapter;
import com.example.gsund.ui.main.adapter.TipsAdapter;
import com.example.gsund.ui.menumakan.DetailMakanan;
import com.example.gsund.ui.menumakan.MenuMakan;
import com.example.gsund.ui.profile.ProfileActivity;
import com.example.gsund.ui.registrasi.RegisterActivity;
import com.example.gsund.utils.AlarmNotification;
import com.example.gsund.utils.RecyclerOnTouchListener;
import com.example.gsund.utils.RecyclerViewClickListener;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.option)
    DiscreteScrollView discreteScrollView;
    @BindView(R.id.recycle_tips)
    RecyclerView recyclerTips;
    @BindView(R.id.sapaan)
    TextView nama;

    List<UserModel> list = new ArrayList<>();
    UserHelper userHelper;
    PreferencesManager preferencesManager;
    AlarmNotification alarm = new AlarmNotification();
    Realm realm;
    private  int JOB_ID = 10;
    private List<ItemOption> item = Arrays.asList(
            new ItemOption(1, "Food", "You're Choose Food", R.drawable.food),
            new ItemOption(2, "Diet", "You're Choose Diet", R.drawable.diet),
            new ItemOption(3, "Sport", "You're Choose Sport", R.drawable.sport));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        preferencesManager = new PreferencesManager(this);

        Realm.init(MainActivity.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        userHelper = new UserHelper(realm);

        OptionAdapter optionAdapter = new OptionAdapter(item);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        TipsAdapter tipsAdapter = new TipsAdapter();

        discreteScrollView.setOrientation(DSVOrientation.HORIZONTAL);
        discreteScrollView.setAdapter(optionAdapter);
        discreteScrollView.setItemTransitionTimeMillis(150);
        discreteScrollView.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        recyclerTips.setLayoutManager(layoutManager);
        recyclerTips.setAdapter(tipsAdapter);

        list = userHelper.getUser(preferencesManager.getId());

        nama.setText(list.get(0).getNama());

        discreteScrollView.addOnItemTouchListener(new RecyclerOnTouchListener(MainActivity.this, recyclerTips, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                showDialog(item.get(position).getName());
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        recyclerTips.addOnItemTouchListener(new RecyclerOnTouchListener(MainActivity.this, recyclerTips, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                
                startActivity(new Intent(MainActivity.this, DetailMakanan.class));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void showDialog(String text){
        KAlertDialog pDialog = new KAlertDialog(this, KAlertDialog.SUCCESS_TYPE);
        pDialog.confirmButtonColor(R.color.colorPrimary);
        pDialog.setTitleText("Are you Sure ?");
        pDialog.setContentText(text);
        pDialog.show();
    }

    @OnClick(R.id.img_profile)
    void profile(){
        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
    }

    @OnClick(R.id.temporary)
    void click(){

        startJob();

    }

    private void startJob(){
        if (JobisRunning(this)){
            Toast.makeText(this, R.string.job_start, Toast.LENGTH_SHORT).show();
            return;
        }
        ComponentName mServiceComponent =  new ComponentName(this,AlarmNotification.class);
        JobInfo.Builder builder =  new JobInfo.Builder(JOB_ID,mServiceComponent);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setRequiresDeviceIdle(false);
        builder.setRequiresCharging(false);

        String title = "Minum Air";
        String message = "Jangan Lupa Minum Air 2 Liter/Hari !";
        int  notifID = 100;
        alarm.showNotification(getApplicationContext(),title,message,notifID);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            builder.setPeriodic(900000);
        }else {
            builder.setPeriodic(180000);
        }



    }

    private boolean JobisRunning(Context context){
        boolean isScheduled = false;
        JobScheduler scheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);

        if(scheduler != null){
            for (JobInfo jobInfo : scheduler.getAllPendingJobs()){
                if(jobInfo.getId() == JOB_ID){
                    isScheduled = true;
                    break;
                }
            }
        }
        return isScheduled;

    }


    private void cancelJob(){
        JobScheduler tm = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        tm.cancel(JOB_ID);
        Toast.makeText(this, "Job Service canceled", Toast.LENGTH_SHORT).show();
        finish();
    }


    @OnClick(R.id.item_food)
    void itemFood(){
        startActivity(new Intent(MainActivity.this, MenuMakan.class));
    }



}