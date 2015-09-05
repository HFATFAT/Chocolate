package com.hzj.chocolate.chocolate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hzj.chocolate.chocolate.R;
import com.hzj.chocolate.chocolate.base.ListBaseAdapter;
import com.hzj.chocolate.chocolate.bean.Candy;

import java.util.List;

/**
 * Created by ff on 15/8/11.
 */
public class CandyAdapter  extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<Candy> mDatas;

    public CandyAdapter(Context context,List<Candy> datas) {
        mInflater=LayoutInflater.from(context);
        mDatas=datas;
    }
    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=mInflater.inflate(R.layout.fourth_item_listview,parent,false);
            holder=new ViewHolder();

            holder.mTitle= (TextView) convertView.findViewById(R.id.candytitle);
            holder.mDesc= (TextView) convertView.findViewById(R.id.candydesc);
            holder.mTime= (TextView) convertView.findViewById(R.id.candytime);
            holder.mPrice= (TextView) convertView.findViewById(R.id.candyprice);

            convertView.setTag(holder);
        }
        else {
            holder= (ViewHolder) convertView.getTag();
        }

        Candy candy=mDatas.get(position);

        holder.mTitle.setText(candy.getTitle());
        holder.mDesc.setText(candy.getDesc());
        holder.mTime.setText(candy.getUrl());
        holder.mPrice.setText(candy.getPubDate());

        return convertView;
    }

    private class ViewHolder{
        TextView mTitle;
        TextView mDesc;
        TextView mTime;
        TextView mPrice;
    }
}
