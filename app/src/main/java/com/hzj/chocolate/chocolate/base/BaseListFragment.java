package com.hzj.chocolate.chocolate.base;

import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hzj.chocolate.chocolate.bean.Entity;
import com.hzj.chocolate.chocolate.bean.ListEntity;

/**
 * Created by kuaidanUI on 15/8/7.
 */
public abstract class BaseListFragment<T extends Entity> extends BaseFragment
        implements SwipeRefreshLayout.OnRefreshListener,AdapterView.OnItemClickListener,
         OnScrollListener {


    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected ListView mListView;
    protected ListBaseAdapter<T> mAdapter;
//    protected EmptyLayout mErrorLayout;


    protected int mStoreEmptyState = -1;

    protected int mCurrentPage = 0;

    protected int mCatalog = 1;
    // 错误信息
//    protected Result mResult;
    private AsyncTask<String, Void, ListEntity<T>> mCacheTask;
//    private ParserTask mParserTask;



}
