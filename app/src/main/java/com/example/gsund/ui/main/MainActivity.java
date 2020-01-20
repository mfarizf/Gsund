package com.example.gsund.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.developer.kalert.KAlertDialog;
import com.example.gsund.R;
import com.example.gsund.data.prefs.PreferencesManager;
import com.example.gsund.ui.main.adapter.OptionAdapter;
import com.example.gsund.ui.main.adapter.TipsAdapter;
import com.example.gsund.ui.menumakan.DetailMakanan;
import com.example.gsund.ui.menumakan.MenuMakan;
import com.example.gsund.ui.profile.ProfileActivity;
import com.example.gsund.utils.RecyclerOnTouchListener;
import com.example.gsund.utils.RecyclerViewClickListener;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.option)
    DiscreteScrollView discreteScrollView;
    @BindView(R.id.recycle_tips)
    RecyclerView recyclerTips;

    PreferencesManager preferencesManager;

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



    public void item_food(View view) {
        Intent i = new Intent(MainActivity.this, MenuMakan.class);
        startActivity(i);
    }


}