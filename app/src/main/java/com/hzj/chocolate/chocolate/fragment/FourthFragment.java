package com.hzj.chocolate.chocolate.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.hzj.chocolate.chocolate.R;
import com.hzj.chocolate.chocolate.adapter.CandyAdapter;
import com.hzj.chocolate.chocolate.adapter.ChocolateAdapter;
import com.hzj.chocolate.chocolate.bean.Candy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by FF on 2015/7/19.
 */
public class FourthFragment extends Fragment implements View.OnClickListener {

    private ListView mListView;
    private List<Candy> mCandy;
    private CandyAdapter candyAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fourth_fragment, container, false);
        mListView= (ListView) rootView.findViewById(R.id.fourthlistview);
        mListView.setAdapter(candyAdapter);
        return rootView;


    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDatas();


    }

    private void initDatas() {
        mCandy=new ArrayList<Candy>();
        Candy candy=new Candy("Roca","乐家","2015-8-8","RMB:20.00","");
        mCandy.add(candy);
          candy=new Candy("Roca","乐家","2015-8-8","RMB:20.00","");
        mCandy.add(candy);
          candy=new Candy("Roca","乐家","2015-8-8","RMB:20.00","");
        mCandy.add(candy);
          candy=new Candy("Roca","乐家","2015-8-8","RMB:20.00","");
        mCandy.add(candy);
          candy=new Candy("Roca","乐家","2015-8-8","RMB:20.00","");
        mCandy.add(candy);
        candy=new Candy("Roca","乐家","2015-8-8","RMB:20.00","");
        mCandy.add(candy);
        candy=new Candy("Roca","乐家","2015-8-8","RMB:20.00","");
        mCandy.add(candy);
        candy=new Candy("Roca","乐家","2015-8-8","RMB:20.00","");
        mCandy.add(candy);
        candy=new Candy("Roca","乐家","2015-8-8","RMB:20.00","");
        mCandy.add(candy);
        candy=new Candy("Roca","乐家","2015-8-8","RMB:20.00","");
        mCandy.add(candy);
        candy=new Candy("Roca","乐家","2015-8-8","RMB:20.00","");
        mCandy.add(candy);
        candy=new Candy("Roca","乐家","2015-8-8","RMB:20.00","");
        mCandy.add(candy);
        candy=new Candy("Roca","乐家","2015-8-8","RMB:20.00","");
        mCandy.add(candy);

        candyAdapter=new CandyAdapter(this.getActivity(),mCandy);
    }

    @Override
    public void onClick(View v) {


    }
}
