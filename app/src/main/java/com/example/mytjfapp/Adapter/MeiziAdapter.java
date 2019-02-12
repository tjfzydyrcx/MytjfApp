package com.example.mytjfapp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mytjfapp.Model.MeiziBean;
import com.example.mytjfapp.R;
import com.example.mytjfapp.TjfMvp.Fragment.SWDiffCallBack;
import com.example.mytjfapp.Utils.GlideUtils;
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
   /*     DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new SWDiffCallBack(data, list), true);

        diffResult.dispatchUpdatesTo(this);*/
    }

    @Override
    protected void convert(BaseViewHolder helper, MeiziBean.ResultsBean item) {

        LabelImageView labelImageView = helper.getView(R.id.meizis);
        labelImageView.setLabelTextColor(Color.BLACK);
        labelImageView.setLabelTextSize(14);
        labelImageView.setLabelText(item.getSource());
        GlideUtils.loadImage(context, item.getUrl(), labelImageView);
        helper.setText(R.id.text_time, item.getDesc());
    }
}
