package com.example.mytjfapp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mymvp.ImgLoadUtils.ImageConfig;
import com.example.mymvp.ImgLoadUtils.ImageLoadBaseTool;
import com.example.mymvp.ImgLoadUtils.ImageLoadProcessInterface;
import com.example.mytjfapp.Model.MeiziBean;
import com.example.mytjfapp.R;
import com.example.mytjfapp.TjfMvp.Fragment.SWDiffCallBack;
import com.example.mytjfapp.Utils.GlideUtils;
import com.example.mytjfapp.Utils.LogUtils;
import com.lid.lib.LabelImageView;

import java.util.List;

/**
 * Created by Administrator on 2018-08-10 0010.
 */

public class MeiziAdapter extends BaseQuickAdapter<MeiziBean.ResultsBean, BaseViewHolder> {
    Context context;
    List<MeiziBean.ResultsBean> data;

    public MeiziAdapter(Context context, @LayoutRes int layoutResId, @Nullable List<MeiziBean.ResultsBean> data) {
        super(layoutResId, data);
        this.context = context;
        this.data = data;
    }

    public void setBeanList(List<MeiziBean.ResultsBean> list) {
        this.data.addAll(list);
        notifyDataSetChanged();

    }

    @Override
    protected void convert(BaseViewHolder helper, final MeiziBean.ResultsBean item) {

        LabelImageView labelImageView = helper.getView(R.id.meizis);
        labelImageView.setLabelTextColor(Color.BLACK);
        labelImageView.setLabelTextSize(14);
        labelImageView.setLabelText(item.getSource());
//        GlideUtils.loadImage(context, item.getUrl(), labelImageView);

        ImageLoadBaseTool.display(context, labelImageView, item.getUrl(), new ImageConfig(R.drawable.img_start, R.drawable.img_fail, 25), new ImageLoadProcessInterface() {

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
                LogUtils.e(item.getUrl()+"取消清除");
            }

            @Override
            public void onLoadFailed() {
                LogUtils.e("失败");
            }
        });
        helper.setText(R.id.text_time, item.getDesc());
    }
}
