package com.example.gsund.ui.profile_progress;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.example.gsund.R;
import com.example.gsund.data.db.model.MakananModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProgressProfileActivity extends AppCompatActivity {
    Cartesian cartesian;
    @BindView(R.id.chart) AnyChartView chart;
    ArrayList array = new ArrayList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);


        cartesian = AnyChart.column();
        //data dummy aja
        array.add(new ValueDataEntry("Satay Kambing",210321930));
        array.add(new ValueDataEntry("Satay Sapi",129312321));
        array.add(new ValueDataEntry("Susu Murni",1283918));


        Column Col = cartesian.column(array);
        Col.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("${%Value}{groupsSeparator: }");

        cartesian.animation(true);
        cartesian.title("Aku Suka Makanan");

        cartesian.yScale().minimum(0d);
        cartesian.yAxis(0).labels().format("${%Value}{groupsSeparator: }");
        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("Makanan");
        cartesian.yAxis(0).title("Keuntungan");

        chart.setChart(cartesian);

    }
}
