package com.example.mywenda.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mywenda.bean.Questioninfo;
import com.example.mywenda.fragment.CardFragment;

import java.util.List;

/**
 * Created by Administrator on 2019-04-27 0027.
 */

public class CardFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Questioninfo> mList;


    public CardFragmentPagerAdapter(FragmentManager fm, List<Questioninfo> mList) {
        super(fm);
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        return CardFragment.newInstance(mList.get(position));
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
