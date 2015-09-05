package com.hzj.chocolate.chocolate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.hzj.chocolate.chocolate.R;
import com.hzj.chocolate.chocolate.base.CommonAdapter;
import com.hzj.chocolate.chocolate.bean.Candy;
import com.hzj.chocolate.chocolate.bean.Chocolate;
import com.hzj.chocolate.chocolate.util.ViewHolder;

import java.util.List;

/**
 * Created by ff on 15/8/11.
 */
public class ChocolateAdapter extends CommonAdapter<Chocolate>{



    public ChocolateAdapter(Context context, List<Chocolate> datas) {
        super(context,datas,R.layout.fourth_item_listview);
    }
//    @Override
//    public int getCount() {
//        return mDatas.size();
//    }
//
//    @Override
//    public T getItem(int position) {
//        return mDatas.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder=new ViewHolder(mContext,parent,R.layout.fourth_item_listview,position);
//
//
//        Chocolate chocolate=mDatas.get(position);
//
//        TextView title=holder.getView(R.id.candytitle);
//        title.setText(chocolate.getTitle());
//        TextView desc=holder.getView(R.id.candydesc);
//        desc.setText(chocolate.getDesc());
//        TextView time=holder.getView(R.id.candytime);
//        time.setText(chocolate.getTime());
//        TextView price=holder.getView(R.id.candyprice);
//        price.setText(chocolate.getPrice());
//
//
//        return holder.getConvertView();
//    }

    @Override
    public void convert(ViewHolder holder, final Chocolate chocolate) {
        holder.setText(R.id.candytitle,chocolate.getTitle())
                .setText(R.id.candydesc, chocolate.getDesc())
                .setText(R.id.candytime,chocolate.getTime())
                .setText(R.id.candyprice,chocolate.getPrice());

        final CheckBox cb=holder.getView(R.id.candycb);
        cb.setChecked(chocolate.isChecked());
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chocolate.setIsChecked(cb.isChecked());

            }
        });
//        TextView title=holder.getView(R.id.candytitle);
//        title.setText(chocolate.getTitle());
//        TextView desc=holder.getView(R.id.candydesc);
//        desc.setText(chocolate.getDesc());
//        TextView time=holder.getView(R.id.candytime);
//        time.setText(chocolate.getTime());
//        TextView price=holder.getView(R.id.candyprice);
//        price.setText(chocolate.getPrice());
    }


}
