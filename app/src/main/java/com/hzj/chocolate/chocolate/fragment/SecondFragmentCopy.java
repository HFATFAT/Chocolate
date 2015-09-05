package com.hzj.chocolate.chocolate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hzj.chocolate.chocolate.R;

/**
 * Created by FF on 2015/7/19.
 */
public class SecondFragmentCopy extends Fragment implements View.OnClickListener {
    private Button msBtn;
    private int isFirst=0;
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(isFirst==0) {
            rootView = inflater.inflate(R.layout.second_fragment, null);
            msBtn = (Button) rootView.findViewById(R.id.msbutton);
            msBtn.setOnClickListener(this);
            Log.d("ff", "启动次数");
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



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ff","second Create");
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.msbutton:
            msBtn.setText("2222");
                break;
            default:
                break;
        }
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
}
