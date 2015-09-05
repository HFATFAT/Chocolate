package com.hzj.chocolate.chocolate.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hzj.chocolate.chocolate.R;
import com.hzj.chocolate.chocolate.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FF on 2015/7/19.
 */
public class FirstFragment extends Fragment{
    private TabLayout mTabLayout;
    private String[] mTitle=new String[]{
            "111111","22222"};
    private ViewPager mViewPager;
    private List<Fragment>mTabs=new ArrayList<Fragment>();
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootView==null) {
            rootView = inflater.inflate(R.layout.first_fragment, container, false);
            Log.d("ff", "启动次数");
            initView();
            initDatas();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            Log.d("ff", "parent != null");
            parent.removeView(rootView);
        }
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initView() {
        mViewPager=(ViewPager)rootView.findViewById(R.id.id_viewpager);
        mTabLayout = (TabLayout) rootView.findViewById(R.id.tabs);

    }
    private void initDatas() {
        List<String> titles = new ArrayList<>();
        titles.add("巧克力");
        titles.add("糖果");
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)));

//        for(String title:mTitle){
//            TabFragment tabFragment=new TabFragment();
//            Bundle bundle=new Bundle();
//            bundle.putString(TabFragment.TITLE,title);
//            tabFragment.setArguments(bundle);
//            mTabs.add(tabFragment);
//        }
        mTabs.add(new ListFragment());
        mTabs.add(new ListFragment());
        FragmentAdapter mAdapter =
               new FragmentAdapter(getFragmentManager(),mTabs, titles);

        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("ff","onAttach");
    }


}
