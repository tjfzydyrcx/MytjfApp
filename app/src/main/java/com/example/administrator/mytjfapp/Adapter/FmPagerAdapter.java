package com.example.administrator.mytjfapp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2018-08-09 0009.
 */

public class FmPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mTabContents;
    private List<String> mDatas;

    public FmPagerAdapter(FragmentManager fm, List<Fragment> mTabContents, List<String> mDatas
    ) {
        super(fm);
        this.mTabContents = mTabContents;
        this.mDatas = mDatas;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDatas.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mTabContents.get(position);
    }

    @Override
    public int getCount() {
        return mTabContents.size();
    }

}
