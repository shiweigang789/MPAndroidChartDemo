
package com.swg.mpandroidchartdemo.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.swg.mpandroidchartdemo.R;
import com.swg.mpandroidchartdemo.common.DemoBase;

import java.util.ArrayList;

import butterknife.BindView;

public class ScrollViewActivity extends DemoBase {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.chart1)
    BarChart mChart;

    @SuppressWarnings("ButterKnifeInjectNotCalled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mChart.getDescription().setEnabled(false);

        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);

        mChart.setDrawBarShadow(false);
        mChart.setDrawGridBackground(false);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        mChart.getAxisLeft().setDrawGridLines(false);
        
        mChart.getLegend().setEnabled(false);

        setData(10);
        mChart.setFitBars(true);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_scrollview;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initViews() {
        setupToolbar(mToolbar,R.string.ci_26_name,R.string.ci_26_desc,0,true);
    }

    @Override
    protected void initEvents() {

    }

    private void setData(int count) {
        ArrayList<BarEntry> yVals = new ArrayList<BarEntry>();
        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * count) + 15;
            yVals.add(new BarEntry(i, (int) val));
        }

        BarDataSet set = new BarDataSet(yVals, "Data Set");
        set.setColors(ColorTemplate.VORDIPLOM_COLORS);
        set.setDrawValues(false);

        BarData data = new BarData(set);

        mChart.setData(data);
        mChart.invalidate();
        mChart.animateY(800);
    }
}
