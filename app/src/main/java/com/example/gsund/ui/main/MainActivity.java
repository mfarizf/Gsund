package com.example.gsund.ui.main;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.developer.kalert.KAlertDialog;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.example.gsund.R;
import com.example.gsund.api.retrofit.DataViewModel;
import com.example.gsund.data.db.helper.UserHelper;
import com.example.gsund.data.db.model.UserModel;
import com.example.gsund.data.prefs.PreferencesManager;
import com.example.gsund.ui.main.adapter.OptionAdapter;
import com.example.gsund.ui.main.adapter.RekomendasiAdapter;
import com.example.gsund.ui.main.adapter.TipsAdapter;
import com.example.gsund.ui.menu.KumpulanData;
import com.example.gsund.ui.profile.ProfileActivity;
import com.example.gsund.ui.progress.ProgressActivity;
import com.example.gsund.ui.tips.TipsActivity;
import com.example.gsund.utils.AlarmNotification;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.option)
    DiscreteScrollView discreteScrollView;
    @BindView(R.id.recycle_tips)
    RecyclerView recyclerTips;
    @BindView(R.id.sapaan)
    TextView nama;
    @BindView(R.id.img_profile)
    CircleImageView circleImageView;
    @BindView(R.id.img_soup)
    ImageView imageFood;
    @BindView(R.id.img_run)
    ImageView imageSport;
    @BindView(R.id.img_brokoli)
    ImageView imageDiet;

    //declare alarm notification
    AlarmNotification alarmNotification = new AlarmNotification();


    List<UserModel> list = new ArrayList<>();
    UserHelper userHelper;
    PreferencesManager preferencesManager;
    AlarmNotification alarm = new AlarmNotification();
    Animation anim;
    Realm realm;
    private  int JOB_ID = 10;
    private List<ItemOption> item = Arrays.asList(
            new ItemOption(1, "Food", "You're Choose Food", R.drawable.food),
            new ItemOption(2, "Diet", "You're Choose Diet", R.drawable.diet),
            new ItemOption(3, "Sport", "You're Choose Sport", R.drawable.sport));

    // Adapter
    TipsAdapter tipsAdapter;
    RekomendasiAdapter rekomendasiAdapter;
    DataViewModel dataViewModel;

    // SkeletonView
    SkeletonScreen skeletonRekomendasi, skeletonTips;

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
        anim = AnimationUtils.loadAnimation(this,R.anim.logoanim);

        discreteScrollView.setOrientation(DSVOrientation.HORIZONTAL);
//        discreteScrollView.setAdapter(optionAdapter);
        discreteScrollView.setItemTransitionTimeMillis(150);
        discreteScrollView.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        // Untuk Tips
        // Main View Model
        dataViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DataViewModel.class);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerTips.setLayoutManager(layoutManager);
        recyclerTips.setHasFixedSize(true);
        showListTips();

        // Show List Rekomendasi
        showListRekomendasi();


        list = userHelper.getUser(preferencesManager.getId());

        nama.setText(list.get(0).getNamaPanggilan());
//        circleImageView.setImageResource(R.drawable.img_random_face);
//        imageDiet.setImageResource(R.drawable.img_ic_diet);
//        imageSport.setImageResource(R.drawable.img_i_sport);
//        imageFood.setImageResource(R.drawable.img_ic_food);
        circleImageView.startAnimation(anim);
        imageFood.startAnimation(anim);
        imageSport.startAnimation(anim);
        imageDiet.startAnimation(anim);

        Glide.with(this)
                    .load(R.drawable.img_random_face)
                    .into(circleImageView);
        Glide.with(this)
                     .load(R.drawable.img_ic_food)
                     .into(imageFood);
        Glide.with(this)
                     .load(R.drawable.img_i_sport)
                     .into(imageSport);
        Glide.with(this)
                     .load(R.drawable.img_ic_diet)
                     .into(imageDiet);


    }


    private void showDialog(String text){
        KAlertDialog pDialog = new KAlertDialog(this, KAlertDialog.SUCCESS_TYPE);
        pDialog.confirmButtonColor(R.color.colorPrimary);
        pDialog.setTitleText("Kamu memilih");
        pDialog.setContentText(text);
        pDialog.show();
    }






    @OnClick(R.id.img_profile)
    void profile(){
        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
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


    //for schedulede notification
    private void startJob(){
        if (JobisRunning(this)){
            Toast.makeText(this, R.string.job_start, Toast.LENGTH_SHORT).show();
            return;
        }
        @SuppressLint("JobSchedulerService") ComponentName mServiceComponent =  new ComponentName(this,AlarmNotification.class);
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
        assert tm != null;
        tm.cancel(JOB_ID);
        Toast.makeText(this, "Job Service canceled", Toast.LENGTH_SHORT).show();
        finish();
    }


    @OnClick(R.id.item_food)
    void itemFood(){
        startActivity(new Intent(MainActivity.this, KumpulanData.class).putExtra("tipe", "makanan"));
    }

    @OnClick(R.id.item_sport)
    void itemSport() {
        startActivity(new Intent(MainActivity.this, KumpulanData.class).putExtra("tipe", "olahraga"));
    }
    @OnClick(R.id.item_diet)
    void itemDiet() {
        startActivity(new Intent(MainActivity.this, KumpulanData.class).putExtra("tipe", "diet"));
    }

    // Tips
    private void showListTips() {
        // Set Adapter
        tipsAdapter = new TipsAdapter();
        tipsAdapter.notifyDataSetChanged();
        recyclerTips.setAdapter(tipsAdapter);

        // SkeletonView
        skeletonTips = Skeleton.bind(recyclerTips).adapter(tipsAdapter).load(R.layout.item_tips).show();

        // Set Data
        dataViewModel.setDataTips();

        // Get Data apabila sudah ada
        dataViewModel.getDataTips().observe(this, tipsAPIS -> {
            if (tipsAPIS != null) {
                tipsAdapter.setData(tipsAPIS);
                skeletonTips.hide();
            }
        });

        tipsAdapter.setOnItemClickCallback(data -> {
            Intent detailTips = new Intent(MainActivity.this, TipsActivity.class);
//            detailMakanan.putExtra("gambar", data.getGambar());
//            detailMakanan.putExtra("judul", data.getNama());
//            detailMakanan.putExtra("subjudul", data.getJenis());
//            detailMakanan.putExtra("deskripsi", data.getDeskripsi());
//            detailMakanan.putExtra(EXTRA_ACTION, ACTION_MAKANAN);
            detailTips.putExtra("judul", data.getJudul());
            detailTips.putExtra("gambar", data.getGambar());
            detailTips.putExtra("deskripsi", data.getDeskripsi());
            startActivity(detailTips);
//            Toast.makeText(MainActivity.this, "Opps!" + data.getKonteks(), Toast.LENGTH_SHORT).show();
        });
    }

    // Tips
    private void showListRekomendasi() {
        // Set Adapter
        rekomendasiAdapter = new RekomendasiAdapter();
        rekomendasiAdapter.notifyDataSetChanged();
        discreteScrollView.setAdapter(rekomendasiAdapter);

        // Skeleton View
        skeletonRekomendasi = Skeleton.bind(discreteScrollView).adapter(rekomendasiAdapter).load(R.layout.item_option_home).show();

        // Set Data
        dataViewModel.setRandomMakanan();
        dataViewModel.setRandomDiet();
        dataViewModel.setRandomOlahraga();

        // Get Data apabila sudah ada
        dataViewModel.getRandomMakanan().observe(this, itemsMakanan -> {
            if (itemsMakanan != null) {
                dataViewModel.getRandomDiet().observe(this, itemsDiet -> {
                    if (itemsDiet != null) {
                        dataViewModel.getRandomOlahraga().observe(this, itemsOlahraga -> {
                            if (itemsOlahraga != null) {
                                rekomendasiAdapter.setData(itemsMakanan, itemsOlahraga, itemsDiet);
                                skeletonRekomendasi.hide();
                            }
                        });
                    }
                });
            }
        });

        rekomendasiAdapter.setOnItemClickCallback(data -> {
            showDialog(data.getNama());
        });
    }

    @OnClick(R.id.lihatProgress)
    void lihatProgress() {
        startActivity(new Intent(MainActivity.this, ProgressActivity.class));
    }

}