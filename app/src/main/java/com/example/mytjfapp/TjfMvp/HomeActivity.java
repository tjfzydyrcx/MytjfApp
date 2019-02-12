package com.example.mytjfapp.TjfMvp;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.mymvp.base.BaseActivity;

import com.example.mytjfapp.R;
import com.example.mytjfapp.TjfMvp.Fragment.ALLDataFragment;
import com.example.mytjfapp.TjfMvp.Fragment.AndroidFragment;
import com.example.mytjfapp.TjfMvp.Fragment.GirlFramgnet;
import com.example.mytjfapp.TjfMvp.Fragment.XianReadFragment;
import com.example.mytjfapp.Utils.GlideUtils;
import com.example.mytjfapp.View.DecoratorViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2019-01-19 0019.
 */

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.Doviewpager)
    DecoratorViewPager vp;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.goods_tablay)
    TabLayout goodsTablay;

    private List<String> mDatas;
    private List<Fragment> mTabContents;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
        ImageView imageView = navView.getHeaderView(0).findViewById(R.id.imageView);
        GlideUtils.loadCircleImage(this, "https://ww1.sinaimg.cn/large/0065oQSqgy1ftrrvwjqikj30go0rtn2i.jpg", imageView);
        setDatas();
    }

    private void setDatas() {
        mDatas = new ArrayList<>();
        mDatas.add("妹子");
        mDatas.add("Android");
        mDatas.add("休息视频");
        mDatas.add("All");

        mTabContents = new ArrayList<>();
        mTabContents.add(new GirlFramgnet());

        mTabContents.add(new AndroidFragment());
        mTabContents.add(new XianReadFragment());
        mTabContents.add(new ALLDataFragment());


        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mTabContents.get(position);
            }

            @Override
            public int getCount() {
                return mTabContents.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mDatas.get(position);
            }
        };

        vp.setCurrentItem(1);
        vp.setNoScroll(false);
        vp.setAdapter(mAdapter);

        goodsTablay.setTabGravity(TabLayout.GRAVITY_FILL);
        goodsTablay.setTabMode(TabLayout.MODE_FIXED);

        goodsTablay.setupWithViewPager(vp);
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
