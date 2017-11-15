package com.swg.mpandroidchartdemo.ui;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Utils;
import com.swg.mpandroidchartdemo.R;
import com.swg.mpandroidchartdemo.common.DemoBase;
import com.swg.mpandroidchartdemo.custom.MyMarkerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 线状图
 * Created by Administrator on 2017/11/14.
 */

public class LineChartActivity1 extends DemoBase implements SeekBar.OnSeekBarChangeListener,
        OnChartGestureListener, OnChartValueSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.chart1)
    LineChart mChart;

    @BindView(R.id.seekBar2)
    SeekBar mSeekBarY;

    @BindView(R.id.seekBar1)
    SeekBar mSeekBarX;

    @BindView(R.id.tvXMax)
    TextView tvX;

    @BindView(R.id.tvYMax)
    TextView tvY;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_linechart;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initChart();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initViews() {
        setupToolbar(mToolbar, R.string.ci_0_name, R.string.ci_0_desc, R.menu.line, true);

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.actionToggleValues: {
                        // 设置是否显示线上点的值
                        List<ILineDataSet> sets = mChart.getData().getDataSets();
                        for (ILineDataSet iSet : sets) {
                            LineDataSet set = (LineDataSet) iSet;
                            set.setDrawValues(!set.isDrawValuesEnabled());
                        }
                        mChart.invalidate();
                    }
                    break;
                    case R.id.actionToggleHighlight: {
                        // 设置选中的高亮线条
                        if (mChart.getData() != null) {
                            mChart.getData().setHighlightEnabled(!mChart.getData().isHighlightEnabled());
                            mChart.invalidate();
                        }
                    }
                    break;
                    case R.id.actionToggleFilled: {
                        List<ILineDataSet> sets = mChart.getData()
                                .getDataSets();
                        for (ILineDataSet iSet : sets) {
                            iSet.setDrawFilled(!iSet.isDrawFilledEnabled());
                        }
                        mChart.invalidate();
                    }
                    break;
                    case R.id.actionToggleCircles: {
                        List<ILineDataSet> sets = mChart.getData()
                                .getDataSets();
                        for (ILineDataSet iSet : sets) {
                            LineDataSet set = (LineDataSet) iSet;
                            set.setDrawCircles(!iSet.isDrawCirclesEnabled());
                        }
                        mChart.invalidate();
                    }
                    break;
                    case R.id.actionToggleCubic: {
                        List<ILineDataSet> sets = mChart.getData()
                                .getDataSets();

                        for (ILineDataSet iSet : sets) {
                            LineDataSet set = (LineDataSet) iSet;
                            set.setMode(set.getMode() == LineDataSet.Mode.CUBIC_BEZIER
                                    ? LineDataSet.Mode.LINEAR
                                    : LineDataSet.Mode.CUBIC_BEZIER);
                        }
                        mChart.invalidate();
                        break;
                    }
                    case R.id.actionToggleStepped: {
                        List<ILineDataSet> sets = mChart.getData()
                                .getDataSets();

                        for (ILineDataSet iSet : sets) {
                            LineDataSet set = (LineDataSet) iSet;
                            set.setMode(set.getMode() == LineDataSet.Mode.STEPPED
                                    ? LineDataSet.Mode.LINEAR
                                    : LineDataSet.Mode.STEPPED);
                        }
                        mChart.invalidate();
                        break;
                    }
                    case R.id.actionToggleHorizontalCubic: {
                        List<ILineDataSet> sets = mChart.getData()
                                .getDataSets();

                        for (ILineDataSet iSet : sets) {
                            LineDataSet set = (LineDataSet) iSet;
                            set.setMode(set.getMode() == LineDataSet.Mode.HORIZONTAL_BEZIER
                                    ? LineDataSet.Mode.LINEAR
                                    : LineDataSet.Mode.HORIZONTAL_BEZIER);
                        }
                        mChart.invalidate();
                        break;
                    }
                    case R.id.actionTogglePinch: {
                        if (mChart.isPinchZoomEnabled())
                            mChart.setPinchZoom(false);
                        else
                            mChart.setPinchZoom(true);

                        mChart.invalidate();
                        break;
                    }
                    case R.id.actionToggleAutoScaleMinMax: {
                        mChart.setAutoScaleMinMaxEnabled(!mChart.isAutoScaleMinMaxEnabled());
                        mChart.notifyDataSetChanged();
                        break;
                    }
                    case R.id.animateX: {
                        mChart.animateX(3000);
                        break;
                    }
                    case R.id.animateY: {
                        mChart.animateY(3000, Easing.EasingOption.EaseInCubic);
                        break;
                    }
                    case R.id.animateXY: {
                        mChart.animateXY(3000, 3000);
                        break;
                    }
                    case R.id.actionSave: {
//                        if (mChart.saveToPath("title" + System.currentTimeMillis(), Environment.getExternalStorageDirectory().getAbsolutePath())) {
//                            Toast.makeText(getApplicationContext(), "Saving SUCCESSFUL!",
//                                    Toast.LENGTH_SHORT).show();
//                        }

                        if (mChart.saveToGallery("test", 100)) {
                            Toast.makeText(LineChartActivity1.this, "图片保存成功", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getApplicationContext(), "Saving FAILED!", Toast.LENGTH_SHORT)
                                    .show();
                        break;
                    }
                }
                return true;
            }
        });
    }

    @Override
    protected void initEvents() {
        mSeekBarY.setOnSeekBarChangeListener(this);
        mSeekBarX.setOnSeekBarChangeListener(this);

        mChart.setOnChartGestureListener(this);
        mChart.setOnChartValueSelectedListener(this);
    }

    private void initChart() {
        // 先为SeekBar设置ChangeListener，这样setProgress时也会触发
        mSeekBarX.setProgress(45);
        mSeekBarY.setProgress(100);

        //设置是否显示表格背景
        mChart.setDrawGridBackground(false);
        // 设置描述信息
//        Description description = new Description();
//        description.setText("My Chart");
//        description.setPosition(100, 20);
//        mChart.setDescription(description);
        mChart.getDescription().setEnabled(false);
        // 设置是否可以触摸
        mChart.setTouchEnabled(true);
        // 是否可以拖拽
        mChart.setDragEnabled(true);
        // 是否可以缩放 x和y轴, 默认是true
        mChart.setScaleEnabled(true);
        //设置x轴和y轴能否同时缩放。默认是否
        mChart.setPinchZoom(true);
        // 设置MarkerView
        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);
        mv.setChartView(mChart); // For bounds control
        mChart.setMarker(mv);

        // 设置一条限制线
        LimitLine llXAxis = new LimitLine(10f, "Index 10");// 位置， 名称
        llXAxis.setLineWidth(4f); // 限制线的高
        llXAxis.enableDashedLine(10f, 10f, 0f);// 线的样式设置为虚线样式,三个参数分别是（长度，间距，没太看懂）
        llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);// 设置线名称相对于线的位置
        llXAxis.setTextSize(10f);// 线名称的字号
//        llXAxis.setTypeface(tf);// 线名称字体样式

        // x轴限制线
        XAxis xAxis = mChart.getXAxis();
        xAxis.enableAxisLineDashedLine(10f, 10f, 0f);
//        xAxis.setValueFormatter(new MyCustomXAxisValueFormatter());
        xAxis.addLimitLine(llXAxis); // add x-axis limit line 这里注释了添加X轴限制线的代码
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        Typeface tf = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");

        LimitLine ll1 = new LimitLine(150f, "Upper Limit");
        ll1.setLineWidth(4f);
        ll1.enableDashedLine(10f, 10f, 0f);
        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        ll1.setTextSize(10f);
        ll1.setTypeface(tf);

        LimitLine ll2 = new LimitLine(-30f, "Lower Limit");
        ll2.setLineWidth(4f);
        ll2.enableDashedLine(10f, 10f, 0f);
        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        ll2.setTextSize(10f);
        ll2.setTypeface(tf);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        leftAxis.addLimitLine(ll1);
        leftAxis.addLimitLine(ll2);
        leftAxis.setAxisMaximum(200f);
        leftAxis.setAxisMinimum(-50f);
        //leftAxis.setYOffset(20f);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);
        // limit lines are drawn behind data (and not on top)
        leftAxis.setDrawLimitLinesBehindData(true);

        mChart.getAxisRight().setEnabled(false);

        //设置数据
        setData(45, 100);
        // X轴动画
        mChart.animateX(2500);
        // 坐标线描述的样式
        Legend l = mChart.getLegend();
        l.setForm(Legend.LegendForm.CIRCLE);
    }

    private void setData(int count, float range) {
        ArrayList<Entry> values = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range + 3);
            values.add(new Entry(i, val));
        }

        LineDataSet set1;
        if (mChart.getData() != null && mChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new LineDataSet(values, "DataSet 1");
            set1.enableDashedLine(10f, 5f, 0f);
            set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setColor(Color.BLACK);
            set1.setCircleColor(Color.BLACK);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawFilled(true);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15f);

            if (Utils.getSDKInt() >= 18) {
                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_red);
                set1.setFillDrawable(drawable);
            } else {
                set1.setFillColor(Color.BLACK);
            }

//            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
//            dataSets.add(set1); // add the datasets

            // create a data object with the datasets
            LineData data = new LineData(set1);

            // set data
            mChart.setData(data);

        }


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tvX.setText(String.valueOf(mSeekBarX.getProgress() + 1));
        tvY.setText(String.valueOf(mSeekBarY.getProgress()));

        setData(mSeekBarX.getProgress() + 1, mSeekBarY.getProgress());
        mChart.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        Log.i("Gesture", "START, x: " + me.getX() + ", y: " + me.getY());
    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        Log.i("Gesture", "END, lastGesture: " + lastPerformedGesture);
        if (lastPerformedGesture != ChartTouchListener.ChartGesture.SINGLE_TAP)
            mChart.highlightValues(null);
    }

    @Override
    public void onChartLongPressed(MotionEvent me) {
        Log.i("LongPress", "Chart longpressed.");
    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {
        Log.i("DoubleTap", "Chart double-tapped.");
    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {
        Log.i("SingleTap", "Chart single-tapped.");
    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {
        Log.i("Fling", "Chart flinged. VeloX: " + velocityX + ", VeloY: " + velocityY);
    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
        Log.i("Scale / Zoom", "ScaleX: " + scaleX + ", ScaleY: " + scaleY);
    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {
        Log.i("Translate / Move", "dX: " + dX + ", dY: " + dY);
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        Log.i("Entry selected", e.toString());
        Log.i("LOWHIGH", "low: " + mChart.getLowestVisibleX() + ", high: " + mChart.getHighestVisibleX());
        Log.i("MIN MAX", "xmin: " + mChart.getXChartMin() + ", xmax: " + mChart.getXChartMax() + ", ymin: " + mChart.getYChartMin() + ", ymax: " + mChart.getYChartMax());
    }

    @Override
    public void onNothingSelected() {
        Log.i("Nothing selected", "Nothing selected.");
    }

}
