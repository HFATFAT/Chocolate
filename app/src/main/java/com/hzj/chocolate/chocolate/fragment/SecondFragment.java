package com.hzj.chocolate.chocolate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hzj.chocolate.chocolate.R;
import com.hzj.chocolate.chocolate.adapter.CandyAdapter;
import com.hzj.chocolate.chocolate.adapter.ChocolateAdapter;
import com.hzj.chocolate.chocolate.bean.Candy;
import com.hzj.chocolate.chocolate.bean.Chocolate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FF on 2015/7/19.
 */
public class SecondFragment extends Fragment implements View.OnClickListener {

    private ListView mListView;
    private List<Chocolate> mChocolate;
    private CandyAdapter candyAdapter;

    private ChocolateAdapter mChocolateAdapter;
    private LinearLayout mFooterView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fourth_fragment, container, false);
        mListView= (ListView) rootView.findViewById(R.id.fourthlistview);

        mFooterView = (LinearLayout) inflater.inflate(R.layout.list_cell_footer,
                null);
        ProgressBar progress = (ProgressBar) mFooterView
                .findViewById(R.id.progressbar);
        TextView text = (TextView) mFooterView.findViewById(R.id.text);
        mFooterView.setVisibility(View.VISIBLE);
        progress.setVisibility(View.VISIBLE);
        text.setVisibility(View.VISIBLE);

//        mListView.addFooterView(mFooterView);

        mListView.setAdapter(mChocolateAdapter);
        return rootView;


    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDatas();


    }

    private void initDatas() {
        mChocolate=new ArrayList<Chocolate>();
        Chocolate chocolate=new Chocolate("Love","德芙","2015-8-8","RMB:20.00");
        mChocolate.add(chocolate);
        chocolate=new Chocolate("Roca","乐家","2015-8-8","RMB:20.00");
        mChocolate.add(chocolate);
        chocolate=new Chocolate("Roca","乐家","2015-8-8","RMB:20.00");
        mChocolate.add(chocolate);
        chocolate=new Chocolate("Roca","乐家","2015-8-8","RMB:20.00");
        mChocolate.add(chocolate);
        chocolate=new Chocolate("Roca","乐家","2015-8-8","RMB:20.00");
        mChocolate.add(chocolate);
        chocolate=new Chocolate("Roca","乐家","2015-8-8","RMB:20.00");
        mChocolate.add(chocolate);
        chocolate=new Chocolate("Roca","乐家","2015-8-8","RMB:20.00");
        mChocolate.add(chocolate);
        chocolate=new Chocolate("Roca","乐家","2015-8-8","RMB:20.00");
        mChocolate.add(chocolate);
        chocolate=new Chocolate("Roca","乐家","2015-8-8","RMB:20.00");
        mChocolate.add(chocolate);
        chocolate=new Chocolate("Roca","乐家","2015-8-8","RMB:20.00");
        mChocolate.add(chocolate);
        chocolate=new Chocolate("Roca","乐家","2015-8-8","RMB:20.00");
        mChocolate.add(chocolate);
        chocolate=new Chocolate("Roca","乐家","2015-8-8","RMB:20.00");
        mChocolate.add(chocolate);
        chocolate=new Chocolate("Roca","乐家","2015-8-8","RMB:20.00");
        mChocolate.add(chocolate);

//        candyAdapter=new CandyAdapter(this.getActivity(),mCandy);
        mChocolateAdapter =new ChocolateAdapter(this.getActivity(),mChocolate);
    }

    @Override
    public void onClick(View v) {


    }
}