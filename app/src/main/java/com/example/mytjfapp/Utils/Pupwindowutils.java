package com.example.mytjfapp.Utils;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.mymvp.ImgLoadUtils.ImageConfig;
import com.example.mymvp.ImgLoadUtils.ImageLoadBaseTool;
import com.example.mymvp.ImgLoadUtils.ImageLoadProcessInterface;
import com.example.mytjfapp.Model.MeiziBean;
import com.example.mytjfapp.R;
import com.example.mytjfapp.View.ShowImagesViewPager;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Administrator on 2018-05-11 0011.
 */

public class Pupwindowutils {
    List<View> mViews = new ArrayList<>();
    Context mContent;
    List<MeiziBean.ResultsBean> imglist;
    String imglist1;
    PopupWindow popupWindow;
    Window window;

    public Pupwindowutils(Window window, Context mContent, List<MeiziBean.ResultsBean> imglist) {
        this.mContent = mContent;
        this.imglist = imglist;
        this.window = window;

    }

    public Pupwindowutils(Window window, Context mContent, String imglist) {
        this.mContent = mContent;
        this.imglist1 = imglist;
        this.window = window;


    }

    public void popuwindow_image(View v, final int i, boolean isbu) {
        final ShowImagesViewPager viewPager;
        View contentView = LayoutInflater.from(mContent).inflate(R.layout.popuwindow_image, null);
        viewPager = contentView.findViewById(R.id.pager);
        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        popupWindow.setClippingEnabled(false);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("mengdd", "onTouch : ");
                return false;
            }
        });
        mViews.clear();
        int size;
        if (isbu) {
            size = imglist.size();
            for (int j = 0; j < size; j++) {
                View image = LayoutInflater.from(mContent).inflate(R.layout.image_photo, null);
                final PhotoView img = image.findViewById(R.id.photoView);
                if (!TextUtils.isEmpty(imglist.get(j).getUrl())) {
                    mViews.add(img);
                }
                GlideUtils.loadImage(mContent, imglist.get(j).getUrl(), img);
                img.setOnPhotoTapListener(photoTapListener);
            }
        } else {
            View image = LayoutInflater.from(mContent).inflate(R.layout.image_photo, null);
            final PhotoView img = image.findViewById(R.id.photoView);
            mViews.add(img);
            LogUtils.e("imglist1" + imglist1);
            GlideUtils.loadImage(mContent, imglist1, img);
//            loadImg(img, imglist1);

            img.setOnPhotoTapListener(photoTapListener);
        }

        viewPager.setAdapter(new MyPagerAdapter());
        viewPager.setCurrentItem(i);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //针对放大后，滑动刷新控件使其加载为原来图片
                PhotoView photoView = (PhotoView) mViews.get(position);
                PhotoViewAttacher attacher = new PhotoViewAttacher(photoView);
                attacher.update();
                attacher.setOnPhotoTapListener(photoTapListener);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        popupWindow.setBackgroundDrawable(mContent.getResources().getDrawable(R.mipmap.bg_photo));
        popupWindow.setAnimationStyle(R.style.showPopupAnimation);
        // 设置好参数之后再show
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
    }

    /**
     * @author 小飞
     * @create 2018-06-19 13:36
     * @Describe 针对单击不可点击去下优化
     */
    PhotoViewAttacher.OnPhotoTapListener photoTapListener = new PhotoViewAttacher.OnPhotoTapListener() {
        @Override
        public void onPhotoTap(View view, float v, float v1) {
            ScreenUtils.show_statuslan(window);
            popupWindow.dismiss();
            mViews.removeAll(imglist);
        }

        @Override
        public void onOutsidePhotoTap() {

        }
    };

    public void loadImg(final PhotoView img, final String imglist1) {
        ImageLoadBaseTool.display(mContent, img, imglist1,
                new ImageConfig(R.drawable.img_start, R.drawable.img_fail, 0), new ImageLoadProcessInterface() {

                    @Override
                    public void onLoadStarted() {
                        LogUtils.e("加载中");
                    }

                    @Override
                    public void onResourceReady() {
                        LogUtils.e("已完成");
                    }

                    @Override
                    public void onLoadCleared() {
                        LogUtils.e(imglist1 + "取消清除");
                    }

                    @Override
                    public void onLoadFailed() {
                        LogUtils.e("失败");
                        loadImg(img, imglist1);
                    }
                });

    }

    public class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mViews.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = mViews.get(position);
            ViewGroup parent = (ViewGroup) v.getParent();
            //Log.i("ViewPaperAdapter", parent.toString());
            if (parent != null) {
                parent.removeAllViews();
            }
            container.addView(mViews.get(position));
            return mViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            container.removeView(mViews.get(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            // TODO Auto-generated method stub
            return view == object;
        }
    }
}
