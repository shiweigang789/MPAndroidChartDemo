package com.swg.mpandroidchartdemo.common;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.swg.mpandroidchartdemo.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * activity基类
 * Created by swg on 2017/11/14.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        mUnbinder = ButterKnife.bind(this);
        initViews();
        initEvents();
    }

    protected abstract int getLayoutResId();

    protected abstract void initViews();

    protected abstract void initEvents();

    /**
     * @param toolbar            Support v7 Toolbar
     * @param title              Toolbar的标题
     * @param subtitle           Toolbar的子标题
     * @param menu               Toolbar的菜单，如果为0则不初始化菜单
     * @param isNavigationEnable 是否显示返回按钮并响应点击事件
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void setupToolbar(@NonNull final Toolbar toolbar,
                                @StringRes int title,
                                @StringRes int subtitle,
                                @MenuRes int menu,
                                boolean isNavigationEnable) {

        if (title != 0) {
            toolbar.setTitle(title);
        }

        if (subtitle != 0) {
            toolbar.setSubtitle(subtitle);
        }

        if (menu != 0) {
            toolbar.inflateMenu(menu);
        }

        if (isNavigationEnable) {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    ((Activity)(toolbar.getContext())).finish();
                    onBackPressed();
                }
            });
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

}
