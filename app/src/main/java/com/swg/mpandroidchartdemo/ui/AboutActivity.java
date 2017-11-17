package com.swg.mpandroidchartdemo.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.swg.mpandroidchartdemo.R;
import com.swg.mpandroidchartdemo.common.BaseActivity;

import butterknife.BindView;

/**
 * Created by zhuanghongji on 2016/11/26.
 */

public class AboutActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

//    @BindView(R.id.tv_about)
//    TextView tvAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // nothing
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_about;
    }

    @Override
    protected void initViews() {
        setupToolbar(mToolbar,R.string.about_name,R.string.about_desc,0,true);
    }

    @Override
    protected void initEvents() {

    }
}
