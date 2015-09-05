package com.hzj.chocolate.chocolate.ui;

import android.support.v4.app.Fragment;

import com.hzj.chocolate.chocolate.R;
import com.hzj.chocolate.chocolate.fragment.FirstFragment;
import com.hzj.chocolate.chocolate.fragment.FourthFragment;
import com.hzj.chocolate.chocolate.fragment.ListFragment;
import com.hzj.chocolate.chocolate.fragment.RecyclerViewFragment;
import com.hzj.chocolate.chocolate.fragment.SecondFragment;
import com.hzj.chocolate.chocolate.fragment.ThirdFragment;

/**
 * Created by HFF on 15/7/17.
 */
public enum MainTab {

    NEWS(0, R.string.main_tab_name_news, R.drawable.tab_icon_new,
            FirstFragment.class),

    TWEET(1, R.string.main_tab_name_tweet, R.drawable.tab_icon_tweet,
            SecondFragment.class),

    QUICK(2, R.string.main_tab_name_quick, R.drawable.tab_icon_new,
            null),

    EXPLORE(3, R.string.main_tab_name_explore, R.drawable.tab_icon_explore,
            ThirdFragment.class),

    ME(4, R.string.main_tab_name_my, R.drawable.tab_icon_me,
            RecyclerViewFragment.class);

    private int idx;
    private int resName;
    private int resIcon;
    private Class<?> clz;


    private MainTab(int idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }


    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}
