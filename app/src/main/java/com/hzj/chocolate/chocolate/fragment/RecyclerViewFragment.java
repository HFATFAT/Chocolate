package com.hzj.chocolate.chocolate.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


import com.hzj.chocolate.chocolate.R;
import com.hzj.chocolate.chocolate.adapter.RecyclerViewSimpleAdapter;
import com.hzj.chocolate.chocolate.adapter.StaggeredRecyclerViewSimpleAdapter;
import com.hzj.chocolate.chocolate.bean.ViewModel;
import com.hzj.chocolate.chocolate.ui.DetailActivity;
import com.hzj.chocolate.chocolate.util.DividerItemDecoration;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ff on 15/8/24.
 */
public class RecyclerViewFragment extends Fragment {
    public static RecyclerView mstaticRecyclerView;
    public static Context RecyclerViewFragmentContext;
    public static StaggeredRecyclerViewSimpleAdapter smAdapter;
    public RecyclerView mRecyclerView;
    public static List<String> mDatas;
    private RecyclerViewSimpleAdapter mAdapter;
    private StaggeredRecyclerViewSimpleAdapter sAdapter;

    private static List<ViewModel> vmItems = new ArrayList<>();

    private static List<Integer> testItems=new ArrayList<>();

    static {

            vmItems.add(new ViewModel("Item c", "http://192.241.220.247/wp-content/uploads/2015/08/Penny%E5%81%9A%E7%9A%84%E5%92%96%E5%96%B1-768x1024.jpg"));
//        http://192.241.220.247/wp-content/uploads/2015/08/%E8%82%A0%E7%B2%89-768x1024.jpg
        vmItems.add(new ViewModel("Item a", "http://192.241.220.247/wp-content/uploads/2015/08/%E8%82%A0%E7%B2%89-768x1024.jpg"));
        vmItems.add(new ViewModel("Item b", "http://192.241.220.247/wp-content/uploads/2015/08/%E7%89%9B%E6%B2%B3-768x1024.jpg"));
        for (int i = 1; i <= 10; i++) {
            vmItems.add(new ViewModel("Item " + i, "http://lorempixel.com/500/500/animals/" + i));
        }

    }

    static {
        testItems.add(R.drawable.a);
        testItems.add(R.drawable.b);
        testItems.add(R.drawable.c);
        testItems.add(R.drawable.d);
        testItems.add(R.drawable.e);
        testItems.add(R.drawable.f);
        testItems.add(R.drawable.g);
        testItems.add(R.drawable.h);
        testItems.add(R.drawable.i);
        testItems.add(R.drawable.j);
//        testItems.add(R.drawable.k);
    }

    

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recyclerviewlayout, container, false);
        mRecyclerView= (RecyclerView) rootView.findViewById(R.id.fragment_recycler_view);
//        mAdapter=new RecyclerViewSimpleAdapter(RecyclerViewFragment.this.getActivity(),mDatas);
        smAdapter=new StaggeredRecyclerViewSimpleAdapter(RecyclerViewFragment.this.getActivity(),vmItems);
        mRecyclerView.setAdapter(smAdapter);

        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(RecyclerViewFragment.this.getActivity(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

//        mRecyclerView.addItemDecoration(new DividerItemDecoration(RecyclerViewFragment.this.getActivity()
//                , DividerItemDecoration.VERTICAL_LIST));
        mstaticRecyclerView=mRecyclerView;
        RecyclerViewFragmentContext=RecyclerViewFragment.this.getActivity();

        smAdapter.setOnItemClickListener(new StaggeredRecyclerViewSimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position,ViewModel viewModel) {
                Toast.makeText(RecyclerViewFragmentContext,
                        position+"",Toast.LENGTH_LONG).show();
                DetailActivity.navigate((AppCompatActivity) RecyclerViewFragmentContext, view.findViewById(R.id.image), viewModel);

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecyclerViewFragmentContext,
                        "long click"+position,Toast.LENGTH_LONG).show();
                smAdapter.deleteDate(position);
            }
        });
        return rootView;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatas();
    }

    private void initDatas() {
        mDatas=new ArrayList<String >();
        for(int i='A';i<='z';i++){
            mDatas.add(""+(char)i);
        }
    }

    public static void setmAdapter(StaggeredRecyclerViewSimpleAdapter mmAdapter,RecyclerView rv){
        rv.setAdapter(mmAdapter);
          smAdapter=mmAdapter;
        smAdapter.setOnItemClickListener(new StaggeredRecyclerViewSimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position,ViewModel viewModel) {
                Toast.makeText(RecyclerViewFragmentContext,
                        position+"",Toast.LENGTH_LONG).show();
//                DetailActivity.navigate(this, view.findViewById(R.id.image), viewModel);

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecyclerViewFragmentContext,
                        "long click"+position,Toast.LENGTH_LONG).show();
//                smAdapter.deleteDate(position);
            }
        });
    }
}
