package com.swg.mpandroidchartdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.github.mikephil.charting.utils.Utils;
import com.swg.mpandroidchartdemo.R;
import com.swg.mpandroidchartdemo.adapter.MyAdapter;
import com.swg.mpandroidchartdemo.bean.ContentItem;
import com.swg.mpandroidchartdemo.common.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by swg on 2017/11/14.
 */

public class MainActivity extends BaseActivity implements MyAdapter.OnItemClickListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private Context mContext;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        Utils.init(this);
    }

    @Override
    protected void initViews() {
        mToolbar.setTitle("MpAndroidChart Demo");
        mToolbar.inflateMenu(R.menu.main);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }

    @NonNull
    private ArrayList<ContentItem> getContentItems() {
        ArrayList<ContentItem> objects = new ArrayList<>();
        objects.add(new ContentItem(
                getString(R.string.ci_0_name),
                getString(R.string.ci_0_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_1_name),
                getString(R.string.ci_1_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_2_name),
                getString(R.string.ci_2_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_3_name),
                getString(R.string.ci_3_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_4_name),
                getString(R.string.ci_4_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_5_name),
                getString(R.string.ci_5_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_6_name),
                getString(R.string.ci_6_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_7_name),
                getString(R.string.ci_7_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_8_name),
                getString(R.string.ci_8_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_9_name),
                getString(R.string.ci_9_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_10_name),
                getString(R.string.ci_10_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_11_name),
                getString(R.string.ci_11_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_12_name),
                getString(R.string.ci_12_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_13_name),
                getString(R.string.ci_13_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_14_name),
                getString(R.string.ci_14_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_15_name),
                getString(R.string.ci_15_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_16_name),
                getString(R.string.ci_16_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_17_name),
                getString(R.string.ci_17_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_18_name),
                getString(R.string.ci_18_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_19_name),
                getString(R.string.ci_19_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_20_name),
                getString(R.string.ci_20_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_21_name),
                getString(R.string.ci_21_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_22_name),
                getString(R.string.ci_22_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_23_name),
                getString(R.string.ci_23_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_24_name),
                getString(R.string.ci_24_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_25_name),
                getString(R.string.ci_25_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_26_name),
                getString(R.string.ci_26_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_27_name),
                getString(R.string.ci_27_desc)));

        ContentItem realm = new ContentItem(
                getString(R.string.ci_28_name),
                getString(R.string.ci_28_desc));
        objects.add(realm);

        ContentItem time = new ContentItem(
                getString(R.string.ci_29_name),
                getString(R.string.ci_29_desc));
        time.isNew = true;
        objects.add(time);
        objects.add(new ContentItem(
                getString(R.string.ci_30_name),
                getString(R.string.ci_30_desc)));
        objects.add(new ContentItem(
                getString(R.string.ci_31_name),
                getString(R.string.ci_31_desc)));

        // 关于
        objects.add(new ContentItem(
                getString(R.string.about_name),
                getString(R.string.about_desc)));
        return objects;
    }

    @Override
    protected void initEvents() {
        MyAdapter adapter = new MyAdapter(this, getContentItems());
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                startActivity(LineChartActivity1.class);
                break;
            case 1:
                startActivity(LineChartActivity2.class);
                break;
        }
    }

    private void startActivity(Class<? extends BaseActivity> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
    }

}
