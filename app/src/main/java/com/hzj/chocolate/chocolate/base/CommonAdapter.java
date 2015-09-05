package com.hzj.chocolate.chocolate.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hzj.chocolate.chocolate.R;
import com.hzj.chocolate.chocolate.bean.Chocolate;
import com.hzj.chocolate.chocolate.util.ViewHolder;

import java.util.List;

/**
 * Created by kuaidanUI on 15/8/13.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    private int mLayoutId;
    private LinearLayout mFooterView;

    public CommonAdapter(Context context, List<T> datas,int layoutId) {
        this.mContext = context;
//        mInflater = LayoutInflater.from(context);
        this.mDatas = datas;
        this.mLayoutId=layoutId;

    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder=new ViewHolder(mContext,parent, mLayoutId,position);

        convert(holder,getItem(position));
        if (position == getCount() - 1) {
            Toast.makeText(parent.getContext(),"last",Toast.LENGTH_LONG).show();
             mFooterView = (LinearLayout) LayoutInflater.from(
                     mContext).inflate(R.layout.list_cell_footer,
                    null);
            ProgressBar progress = (ProgressBar) mFooterView
                    .findViewById(R.id.progressbar);
            TextView text = (TextView) mFooterView.findViewById(R.id.text);
            mFooterView.setVisibility(View.VISIBLE);
            progress.setVisibility(View.VISIBLE);
            text.setVisibility(View.VISIBLE);
////            if (StringUtils.isEmpty(loadMsg)) {
////                text.setText(_loadmoreText);
////            } else {
////                text.setText(loadMsg);
////            }
        }
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder,T t);
}
