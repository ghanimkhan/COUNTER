package com.ghanim.master2counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class activity2 extends AppCompatActivity {
    private AdView mAdView;
    private static final String TAG = "activity2";
    String[] week = {"Mon", "Tue", "Wed", "Thus", "Fri", "Sat", "Sun"};
    AnyChartView anyChartView,columchart;
    int[] count1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);



        MobileAds.initialize(this, "ca-app-pub-2896925381663375~9928429241");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Intent intent = getIntent();
        count1= intent.getIntArrayExtra("array");
         anyChartView = findViewById(R.id.any_chart_view);
        setupPieChart();
    }

    public void setupPieChart() {
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i = 0; i < week.length; i++) {
            dataEntries.add(new ValueDataEntry(week[i], count1[i]));
        }

        pie.background().enabled(true);
        pie.background().fill("#1F2223");

        pie.data(dataEntries);
        anyChartView.setChart(pie);


    }

}
