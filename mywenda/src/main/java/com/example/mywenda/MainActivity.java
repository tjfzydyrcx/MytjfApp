package com.example.mywenda;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.mymvp.base.BaseActivity;
import com.example.mywenda.Presenter.TestPresenter;
import com.example.mywenda.adapter.CardFragmentPagerAdapter;
import com.example.mywenda.bean.Questioninfo;
import com.example.mywenda.fragment.CardFragment;
import com.example.mywenda.view.ITestView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ITestView {


    @BindView(R.id.viewpage)
    ViewPager viewpage;
    @BindView(R.id.tv_bottom_text)
    TextView tvBottomText;
    private List<Questioninfo> mList = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    CardFragmentPagerAdapter cardFragmentPagerAdapter;

    @Override
    protected void initView() {
        TestPresenter presenter = new TestPresenter(this);
        presenter.getData();
    }

    @Override
    public void updateUI(List<Questioninfo> mList) {
        cardFragmentPagerAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(), mList);
        viewpage.setAdapter(cardFragmentPagerAdapter);
        viewpage.setOffscreenPageLimit(3);
    }
}
