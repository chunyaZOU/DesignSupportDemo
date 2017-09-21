package com.zcy.designsupportdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by zcy on 2017/9/21.
 */

public class VPAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private String[] mTitles;

    public VPAdapter(FragmentManager fm, List<Fragment> fragments,String[] titles) {
        super(fm);
        mFragments = fragments;
        mTitles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


}
