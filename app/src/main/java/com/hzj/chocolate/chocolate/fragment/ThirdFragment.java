package com.hzj.chocolate.chocolate.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.hzj.chocolate.chocolate.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by FF on 2015/7/19.
 */
public class ThirdFragment extends Fragment implements View.OnClickListener,AbsListView.OnScrollListener {


    private int visibleItemCount;
    private int totalItemCount;
    private int lastVisibleItem;
    boolean isLoading;
    private int isFirst=0;
    private View rootView;

    ListView mListView;
    SwipeRefreshLayout mSwipeRefreshLayout;


    private ArrayAdapter<String> mAdapter;
    private  ArrayList<String> mArrayList;
    private String[] catNames;
    private List<String> mmArrayList= new ArrayList<String>();
    private List<String> L = new ArrayList<String>();
    private LinearLayout mFooterView;
    List<String> newCatNames = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(isFirst==0) {
            rootView = inflater.inflate(R.layout.third_fragment, container, false);
            mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swiperefreshlayout);
            mListView = (ListView)rootView.findViewById(R.id.listview);


            mFooterView = (LinearLayout) inflater.inflate(R.layout.list_cell_footer,
                    null);
            ProgressBar progress = (ProgressBar) mFooterView
                    .findViewById(R.id.progressbar);
            TextView text = (TextView) mFooterView.findViewById(R.id.text);
            mFooterView.setVisibility(View.GONE);
            progress.setVisibility(View.VISIBLE);
            text.setVisibility(View.VISIBLE);

            mListView.addFooterView(mFooterView);
            mListView.setOnScrollListener(this);


            catNames= getResources().getStringArray(R.array.cat_names);

            mmArrayList = java.util.Arrays.asList(catNames);
            for (int i = 0; i < mmArrayList.size(); i++) {
                int randomCatNameIndex = new Random().nextInt(mmArrayList.size() - 1);
                newCatNames.add(mmArrayList.get(randomCatNameIndex));
            }

            mAdapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,newCatNames);
            mListView.setAdapter(mAdapter);

            mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_dark, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_green_light);
            mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new ArrayAdapter<String>(ThirdFragment.this.getActivity(), android.R.layout.simple_list_item_1, getNewCatNames());
                            mListView.setAdapter(mAdapter);

                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    },3000);

                }
            });
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                Log.d("ff", "parent != null");
                parent.removeView(rootView);
            }

            return rootView;
        }
        else {
            return rootView;
        }
    }

    private List<String> getNewCatNames() {

//            for (int i = 0; i < mmArrayList.size(); i++) {
//                int randomCatNameIndex = new Random().nextInt(mmArrayList.size() - 1);
//                newCatNames.add(mmArrayList.get(randomCatNameIndex));
//            }
        newCatNames.add(0,"1");
        newCatNames.add(1,"2");
        newCatNames.add(2,"3");
        newCatNames.add("refresh add ");
        mAdapter.notifyDataSetChanged();
        return newCatNames;
    }

    private void getLoadData(){
        /**http://blog.csdn.net/tolcf/article/details/38597217
         mmArrayList.add("ffffff");
         mmArrayList.add("oooooo");
         */
        newCatNames.add("ffffff");
        newCatNames.add("oooooo");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ff", "second Create");

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.d("ff", "onDetach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            Log.d("ff", "parent != null");
            parent.removeView(rootView);
            isFirst+=1;
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if(totalItemCount==lastVisibleItem&&scrollState==SCROLL_STATE_IDLE) {
            if(!isLoading){
                isLoading=true;
                mFooterView.setVisibility(View.VISIBLE);
                onLoadMore();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.lastVisibleItem=firstVisibleItem+visibleItemCount;
        this.totalItemCount=totalItemCount;
//        if(this.totalItemCount==lastVisibleItem) {
//            if(!isLoading){
//                isLoading=true;
//                mFooterView.setVisibility(View.GONE);
//            }
//        }
    }

    public void onLoadMore(){
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getLoadData();
                mAdapter.notifyDataSetChanged();
                loadComplete();
            }
        },2000);

    }
    public void loadComplete(){
        isLoading=false;
        mFooterView.setVisibility(View.GONE);
    }
}
