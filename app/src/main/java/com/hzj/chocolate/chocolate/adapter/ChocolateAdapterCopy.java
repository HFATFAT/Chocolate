package com.hzj.chocolate.chocolate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hzj.chocolate.chocolate.R;
import com.hzj.chocolate.chocolate.bean.Chocolate;
import com.hzj.chocolate.chocolate.util.ViewHolder;

import java.util.List;

/**
 * Created by ff on 15/8/11.
 */
public class ChocolateAdapterCopy extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<Chocolate> mDatas;
    private Context mContext;

    public ChocolateAdapterCopy(Context context, List<Chocolate> datas) {
        mInflater=LayoutInflater.from(context);
        mDatas=datas;
        mContext=context;
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
        ViewHolder holder=new ViewHolder(mContext,parent,R.layout.fourth_item_listview,position);


        Chocolate chocolate=mDatas.get(position);

        TextView title=holder.getView(R.id.candytitle);
        title.setText(chocolate.getTitle());
        TextView desc=holder.getView(R.id.candydesc);
        desc.setText(chocolate.getDesc());
        TextView time=holder.getView(R.id.candytime);
        time.setText(chocolate.getTime());
        TextView price=holder.getView(R.id.candyprice);
        price.setText(chocolate.getPrice());


        return holder.getConvertView();
    }


}
