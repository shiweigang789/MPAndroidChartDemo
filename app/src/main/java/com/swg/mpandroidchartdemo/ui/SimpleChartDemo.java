
package com.swg.mpandroidchartdemo.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.swg.mpandroidchartdemo.R;
import com.swg.mpandroidchartdemo.common.DemoBase;
import com.swg.mpandroidchartdemo.fragments.BarChartFrag;
import com.swg.mpandroidchartdemo.fragments.ComplexityFragment;
import com.swg.mpandroidchartdemo.fragments.PieChartFrag;
import com.swg.mpandroidchartdemo.fragments.ScatterChartFrag;
import com.swg.mpandroidchartdemo.fragments.SineCosineFragment;

import butterknife.BindView;

/**
 * Demonstrates how to keep your charts straight forward, simple and beautiful with the MPAndroidChart library.
 *
 * @author Philipp Jahoda
 */
public class SimpleChartDemo extends DemoBase {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.pager)
    ViewPager pager;

    @SuppressWarnings("ButterKnifeInjectNotCalled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pager.setOffscreenPageLimit(3);

        PageAdapter a = new PageAdapter(getSupportFragmentManager());
        pager.setAdapter(a);

        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("This is a ViewPager.");
        b.setMessage("Swipe left and right for more awesome design examples!");
        b.setPositiveButton("OK", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        b.show();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_awesomedesign;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initViews() {
        setupToolbar(mToolbar, R.string.ci_14_name, R.string.ci_14_desc, 0, true);
    }

    @Override
    protected void initEvents() {

    }

    private class PageAdapter extends FragmentPagerAdapter {

        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            Fragment f = null;

            switch (pos) {
                case 0:
                    f = SineCosineFragment.newInstance();
                    break;
                case 1:
                    f = ComplexityFragment.newInstance();
                    break;
                case 2:
                    f = BarChartFrag.newInstance();
                    break;
                case 3:
                    f = ScatterChartFrag.newInstance();
                    break;
                case 4:
                    f = PieChartFrag.newInstance();
                    break;
            }

            return f;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
