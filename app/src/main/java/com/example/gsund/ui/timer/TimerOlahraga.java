package com.example.gsund.ui.timer;

import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.developer.kalert.KAlertDialog;
import com.example.gsund.R;

import net.crosp.libs.android.circletimeview.CircleTimeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimerOlahraga extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.circle_timer_view)
    CircleTimeView circleTimeView;
    @BindView(R.id.label_timer)
    TextView labelTimer;
//    @BindView(R.id.btn_play_timer)
//    ImageView btnPlayTimer;
//    @BindView(R.id.btn_stop_timer)
//    ImageView btnStopTimer;
//    @BindView(R.id.btn_reset_timer)
//    ImageView btnResetTimer;

    // Dialog
    KAlertDialog mDialog;
    private Boolean isPlay = false;

    // Sound
    SoundPool sp;
    int soundId;
    boolean spLoaded = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_olahraga);
        ButterKnife.bind(this);

        labelTimer.setOnClickListener(this);
//        btnPlayTimer.setOnClickListener(this);
//        btnStopTimer.setOnClickListener(this);
//        btnResetTimer.setOnClickListener(this);

        // Setup Timer
        circleTimeView.setCurrentTime(300);
        // Set Timer Listener
        circleTimeView.setCircleTimerListener(new CircleTimeView.CircleTimerListener() {
            @Override
            public void onTimerStop() {
                finish();
            }

            @Override
            public void onTimerStart(long time) {
                Toast.makeText(TimerOlahraga.this, "Ayo Mulai!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTimerTimeValueChanged(long time) {
                Log.d("Time", "onTimerTimeValueChanged : " + time);
                if (time == 0) {
                    Toast.makeText(TimerOlahraga.this, "Opps! Waktu kamu habis!", Toast.LENGTH_SHORT).show();
                    if (spLoaded) {
                        sp.play(soundId, 1f, 1f, 1, 0, 1f);
                    }
                    circleTimeView.stopTimer();
                    isPlay = false;
                    circleTimeView.setCurrentTimeMode(CircleTimeView.MODE_MANUAL_SETUP);
                }
            }
        });

        // Set Circle Listener
        circleTimeView.setCircleTimeListener(new CircleTimeView.CircleTimeListener() {
            @Override
            public void onTimeManuallySet(long time) {
                Log.d("Time", "onTimeManuallySet : " + time);
            }

            @Override
            public void onTimeManuallyChanged(long time) {
                Log.d("Time", "onTimeManuallyChanged : " + time);
            }

            @Override
            public void onTimeUpdated(long time) {
                Log.d("Time", "onTimeUpdated : " + time);
            }
        });

        // Sound
        sp = new SoundPool.Builder()
                .setMaxStreams(10)
                .build();
        sp.setOnLoadCompleteListener((soundPool, sampleId, status) -> {
            if (status == 0) {
                spLoaded = true;
            } else {
                Toast.makeText(TimerOlahraga.this, "Gagal load", Toast.LENGTH_SHORT).show();
            }
        });
        soundId = sp.load(this, R.raw.tokopedia, 1);

        new Handler().postDelayed(() -> circleTimeView.startTimer(),1000L);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.label_timer) {
            finish();
        }
//        else if (v.getId() == R.id.btn_play_timer) {
//            showConfirmDialog(1);
//        } else if (v.getId() == R.id.btn_stop_timer) {
//            showConfirmDialog(2);
//        } else if (v.getId() == R.id.btn_reset_timer) {
//            showConfirmDialog(3);
//        }
    }
//
//    private void showConfirmDialog(int typeDialog) {
//        if (typeDialog == 1) {
//            if (circleTimeView.getCurrentTimeInSeconds() != 0) {
//                if (!isPlay) {
//                    mDialog = new KAlertDialog(this);
//                    mDialog.setTitleText("Beneran yakin mau mulai?");
//                    mDialog.setContentText("Siap siap yaa!");
//                    mDialog.setConfirmText("Iya Dong!");
//                    mDialog.confirmButtonColor(R.color.blue_btn_bg_color);
//                    mDialog.setConfirmClickListener(kAlertDialog -> {
//                        circleTimeView.startTimer();
//                        kAlertDialog.cancel();
//                        isPlay = true;
//                    });
//                    mDialog.setCancelText("Ngga jadi deh");
//                    mDialog.setCancelClickListener(KAlertDialog::cancel);
//                    mDialog.show();
//                } else {
//                    mDialog = new KAlertDialog(this);
//                    mDialog.setTitleText("Lanjut nih?");
//                    mDialog.setContentText("Kali ini lebih semangat Ya!");
//                    mDialog.setConfirmText("Gas!");
//                    mDialog.confirmButtonColor(R.color.blue_btn_bg_color);
//                    mDialog.setConfirmClickListener(kAlertDialog -> {
//                        circleTimeView.startTimer();
//                        kAlertDialog.cancel();
//                        isPlay = true;
//                    });
//                    mDialog.setCancelText("Ngga jadi deh");
//                    mDialog.setCancelClickListener(KAlertDialog::cancel);
//                    mDialog.show();
//                }
//            } else {
//                mDialog = new KAlertDialog(this);
//                mDialog.setTitleText("Oops!");
//                mDialog.setContentText("Belum juga di Set, udah dimulai aja :( ");
//                mDialog.setConfirmText("Hehe ya maap");
//                mDialog.setConfirmClickListener(kAlertDialog -> mDialog.cancel());
//                mDialog.show();
//            }
//
//        } else if (typeDialog == 2) {
//            if (isPlay) {
//                mDialog = new KAlertDialog(this);
//                mDialog.setTitleText("Beneran yakin mau udahan?");
//                mDialog.setContentText("Tetap Semangat Yaa!");
//                mDialog.setConfirmText("Iya cape nih!");
//                mDialog.confirmButtonColor(R.color.blue_btn_bg_color);
//                mDialog.setConfirmClickListener(kAlertDialog -> {
//                    circleTimeView.stopTimer();
//                    circleTimeView.setCurrentTimeMode(CircleTimeView.MODE_MANUAL_SETUP);
//                    kAlertDialog.cancel();
//                });
//                mDialog.setCancelText("Lanjut!");
//                mDialog.setCancelClickListener(KAlertDialog::cancel);
//                mDialog.show();
//            } else {
//                mDialog = new KAlertDialog(this);
//                mDialog.setTitleText("Oops!");
//                mDialog.setContentText("Belum juga dimulai, udah berhenti aja :( ");
//                mDialog.setConfirmText("Hehe ya maap");
//                mDialog.setConfirmClickListener(kAlertDialog -> mDialog.cancel());
//                mDialog.show();
//            }
//        } else if (typeDialog == 3) {
//            if (circleTimeView.getCurrentTimeInSeconds() != 0) {
//                mDialog = new KAlertDialog(this);
//                mDialog.setTitleText("Beneran yakin mau di reset?");
//                mDialog.setContentText("Waktu bakal balik lagi ke awal, kayak kita dulu :( !");
//                mDialog.setConfirmText("Iya nih!");
//                mDialog.confirmButtonColor(R.color.blue_btn_bg_color);
//                mDialog.setConfirmClickListener(kAlertDialog -> {
//                    circleTimeView.stopTimer();
//                    circleTimeView.resetTime();
//                    isPlay = false;
//                    kAlertDialog.cancel();
//                });
//                mDialog.setCancelText("Ngga jadi deh");
//                mDialog.setCancelClickListener(KAlertDialog::cancel);
//                mDialog.show();
//            } else {
//                mDialog = new KAlertDialog(this);
//                mDialog.setTitleText("Oops!");
//                mDialog.setContentText("Belum juga di Set, udah di reset aja :( ");
//                mDialog.setConfirmText("Hehe ya maap");
//                mDialog.setConfirmClickListener(kAlertDialog -> mDialog.cancel());
//                mDialog.show();
//            }
//        }
//    }
}
