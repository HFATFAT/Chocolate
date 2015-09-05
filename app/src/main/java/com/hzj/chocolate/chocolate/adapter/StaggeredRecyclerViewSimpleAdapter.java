package com.hzj.chocolate.chocolate.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hzj.chocolate.chocolate.R;
import com.hzj.chocolate.chocolate.bean.ViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ff on 15/8/26.
 */
public class StaggeredRecyclerViewSimpleAdapter extends RecyclerView.Adapter<StaggeredRecyclerViewSimpleAdapter.MyViewHolder>{
    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;

    private List<Integer> mHeights;

    private List<ViewModel> items;

    private List<Integer> testItems;




//    public StaggeredRecyclerViewSimpleAdapter(Context context,List<String> datas){
//        this.mContext=context;
//        this.mDatas=datas;
//        mInflater=LayoutInflater.from(context);
//
//        mHeights=new ArrayList<Integer>();
//        for(int i=0;i<mDatas.size();i++){
//            mHeights.add((int) (100+Math.random()*300));
//        }
//    }

    public StaggeredRecyclerViewSimpleAdapter(Context context,List<ViewModel> items){
        this.mContext=context;
        this.items=items;
        mInflater=LayoutInflater.from(context);


//        mHeights=new ArrayList<Integer>();
//          ImageView testImageView=new ImageView(context);
//        testImageView.setImageResource(items.get(1));

//        Log.d("ti", String.valueOf(testImageView.getLayoutParams().height));

//        for(int i=0;i<items.size();i++){
//            mHeights.add((int) (100+Math.random()*300));
//        }

    }

    @Override
    public StaggeredRecyclerViewSimpleAdapter.MyViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= mInflater.inflate(R.layout.item_single_textview,parent,false);

        MyViewHolder viewHolder=new MyViewHolder(view);

        return viewHolder;
    }

    public void addData(int pos){
        mDatas.add(pos,"Insert");
        notifyItemInserted(pos);
    }

    public void deleteDate(int pos){
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ViewGroup.LayoutParams lp=holder.itemView.getLayoutParams();
//        lp.height=mHeights.get(position);


//        holder.tv.setText(mDatas.get(position));


        ViewModel item = items.get(position);
        holder.iv.setImageBitmap(null);
//        holder.iv.setImageResource(testItems.get(position));
        Picasso.with(holder.iv.getContext()).load(item.getImage()).into(holder.iv);
        holder.itemView.setTag(item);
//        lp.height=600;
//        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(),testItems.get(position));
//        lp.height=(bitmap.getHeight())/2;
//        Log.d("H", String.valueOf(bitmap.getHeight()));
//        Log.d("HH", String.valueOf(holder.iv.getHeight()));
//        Log.d("ww", String.valueOf(holder.iv.getWidth()));
//        Log.d("dhhhh", String.valueOf(holder.iv.getLayoutParams().height));
//        holder.itemView.setLayoutParams(lp);




        if(mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   int layoutPosition= holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView,layoutPosition, (ViewModel) v.getTag());
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPosition= holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, layoutPosition);
                    return true;
                }
            });
        }
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv;
        ImageView iv;
        public MyViewHolder(View itemView) {
            super(itemView);

//            tv= (TextView) itemView.findViewById(R.id.id_tv);

            iv= (ImageView) itemView.findViewById(R.id.iv_image);


        }
    }

//    @Override public void onClick(final View v) {
//        // Give some time to the ripple to finish the effect
//        if (mOnItemClickListener != null) {
//            new Handler().postDelayed(new Runnable() {
//                @Override public void run() {
//                    mOnItemClickListener.onItemClick(v, (ViewModel) v.getTag());
//                }
//            }, 200);
//        }
//    }


    public interface OnItemClickListener{
        void onItemClick(View view,int position,ViewModel viewModel);
        void onItemLongClick(View view,int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener=listener;
    }
}


