package com.hzj.chocolate.chocolate.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by HFF on 15/7/14.
 */
public class TabFragment extends Fragment {
    private String mTitle="Default";

    public static final String TITLE ="";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(getArguments()!=null){
            mTitle=getArguments().getString(TITLE);
        }

        TextView tv=new TextView(getActivity());
        tv.setTextSize(30);
        tv.setBackgroundColor(Color.parseColor("#ffEDEDED"));
        tv.setText(mTitle);
        return tv;
    }
}
