package com.yc.wxrecoding.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yc.wxrecoding.R;
import com.yc.wxrecoding.model.RecorderBean;

import java.util.List;
import java.util.Locale;

/**
 * @author by kabuqinuofu on 2018/3/7.
 */
public class RecorderAdapter extends ArrayAdapter<RecorderBean> {

    //item 最小最大值
    private int mMinItemWidth;
    private int mMaxIItemWidth;

    private LayoutInflater mInflater;

    public RecorderAdapter(@NonNull Context context, List<RecorderBean> datas) {
        super(context, -1, datas);
        mInflater = LayoutInflater.from(context);

        //获取屏幕宽度
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);

        //item 设定最小最大值
        mMaxIItemWidth = (int) (outMetrics.widthPixels * 0.7f);
        mMinItemWidth = (int) (outMetrics.widthPixels * 0.15f);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_recorder, parent, false);
            holder = new ViewHolder();
            holder.seconds = convertView.findViewById(R.id.id_recorder_time);
            holder.length = convertView.findViewById(R.id.id_recorder_length);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        RecorderBean item = getItem(position);
        if (item != null) {
            //设置时间  matt.round 四舍五入
            holder.seconds.setText(String.format(Locale.CANADA, "%s", Math.round(item.getTime()) + "\""));
            //设置背景的宽度
            ViewGroup.LayoutParams lp = holder.length.getLayoutParams();
            //getItem(position).time
            lp.width = (int) (mMinItemWidth + (mMaxIItemWidth / 60f * item.getTime()));
        }

        return convertView;
    }

    private class ViewHolder {
        TextView seconds;
        View length;
    }
}



