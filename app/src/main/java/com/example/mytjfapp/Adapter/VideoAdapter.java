package com.example.mytjfapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mytjfapp.Model.DuanziBean;
import com.example.mytjfapp.Model.MeiziBean;
import com.example.mytjfapp.Model.VideoBean;
import com.example.mytjfapp.R;
import com.example.mytjfapp.Utils.GlideUtils;
import com.example.mytjfapp.Utils.LogUtils;
import com.example.mytjfapp.Utils.ParseWebUrlHelper;
import com.lid.lib.LabelImageView;

import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Administrator on 2018-08-10 0010.
 */

public class VideoAdapter extends BaseQuickAdapter<DuanziBean.ResultBean, BaseViewHolder> {
    Activity context;

    public VideoAdapter(Activity context, @LayoutRes int layoutResId, @Nullable List<DuanziBean.ResultBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    public void setBeanList(List<DuanziBean.ResultBean> list) {
        this.mData.addAll(list);
        notifyDataSetChanged();

    }


    @Override
    protected void convert(BaseViewHolder helper, DuanziBean.ResultBean item) {
        JZVideoPlayerStandard jzVideoPlayerStandard = helper.getView(R.id.videoplayer);

        if (!TextUtils.isEmpty(item.getVideo())) {
            LogUtils.e("LAI=" + item.toString());
            jzVideoPlayerStandard.setUp(item.getVideo(), JZVideoPlayer.SCREEN_WINDOW_NORMAL, item.getText());
            Glide.with(context).load(item.getThumbnail()).into(jzVideoPlayerStandard.thumbImageView);

        }


  /*      //初始化
        ParseWebUrlHelper parseWebUrlHelper = ParseWebUrlHelper.getInstance().init((WebView) helper.getView(R.id.Web_view), context, item.getUrl());
//解析网页中视频
        parseWebUrlHelper.setOnParseListener(new ParseWebUrlHelper.OnParseWebUrlListener() {
            @Override
            public void onFindUrl(String url) {
                LogUtils.e("webUrl" + url);
                /*//*****处理代码
         }

         @Override public void onError(String errorMsg) {
         /*//****出错监听
         LogUtils.e("errorMsg" + errorMsg);
         }

         });*/

    /*    WebView webView = helper.getView(R.id.Web_view);
        webView.loadUrl(item.getUrl());
        webView.addJavascriptInterface(this, "android");//添加js监听 这样html就能调用客户
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js
//支持屏幕缩放
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });*/
    }

}
