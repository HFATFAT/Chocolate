package com.hzj.chocolate.chocolate.ui;



import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.hzj.chocolate.chocolate.AppManager;
import com.hzj.chocolate.chocolate.R;
import com.hzj.chocolate.chocolate.adapter.FragmentAdapter;
import com.hzj.chocolate.chocolate.adapter.StaggeredRecyclerViewSimpleAdapter;
import com.hzj.chocolate.chocolate.bean.ViewModel;
import com.hzj.chocolate.chocolate.fragment.FirstFragment;
import com.hzj.chocolate.chocolate.fragment.MyFragmentTabHost;
import com.hzj.chocolate.chocolate.fragment.RecyclerViewFragment;
import com.hzj.chocolate.chocolate.fragment.TabFragment;
import com.hzj.chocolate.chocolate.util.CircleTransform;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener,
        View.OnClickListener,MyFragmentTabHost.OnTabChangeListener{


//    @InjectView(android.R.id.tabhost)
    public MyFragmentTabHost mTabHost;

    private ViewPager mViewPager;
    private List<Fragment>mTabs=new ArrayList<Fragment>();
    private String[] mTitle=new String[]{
            "111111","22222"
    };
    private FragmentPagerAdapter mAdapter;
    private TabLayout mTabLayout;


    private PullToRefreshListView lv;
    private ArrayAdapter<String> adapter;
    private DrawerLayout drawerLayout;
    private View content;
    private View mAddBt;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private ProgressBar mProgressBar;
    private ImageView headerImage;


    private PopupWindow addpopWindow;

    private DoubleClickExitHelper mDoubleClickExit;

    public static final String AVATAR_URL = "https://www.baidu.com/img/bdlogo.png";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOverflowButtonAlways();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mTabHost= (MyFragmentTabHost) findViewById(R.id.mytabhost);
        initToolbar();
//        initView();
//        initDatas();
        initTabs();
        mTabHost.setCurrentTab(0);
        mTabHost.setOnTouchListener(this);
        mTabHost.setOnTabChangedListener(this);
        mAddBt=findViewById(R.id.quick_option_iv);
        mAddBt.setOnClickListener(this);

        setupDrawerLayout();
        content = this.getWindow().getDecorView();
        mProgressBar= (ProgressBar) findViewById(R.id.headerimageprogressbar);
        mDoubleClickExit = new DoubleClickExitHelper(this);
        AppManager.getAppManager().addActivity(this);

        headerImage = (ImageView) findViewById(R.id.avatar);
//        headerImage.setImageResource(R.drawable.tab_icon_tweet);
//        avatar.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_tweet));
//        headerImage.setImageURI(Uri.parse("https://www.baidu.com/img/bdlogo.png"));
//        Picasso.with(this).load(AVATAR_URL).transform(new CircleTransform()).into(avatar);

        new BitMapAsyncTask().execute("http://192.241.220.247/wp-content/uploads/2015/08/%E8%82%A0%E7%B2%89-768x1024.jpg");
    }

//
//    @Override
//    public void onAttachFragment(android.app.Fragment fragment) {
//
//
//
//        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.hide(f);
//        ft.commit();
//
//    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
            Log.d("aaaaaa","attach");
//        Fragment f= getSupportFragmentManager().findFragmentByTag("综合");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home:
                    if(!drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.openDrawer(GravityCompat.START);
                    Log.d("cccc", String.valueOf(drawerLayout.isDrawerVisible(GravityCompat.START)));}
                    else {
                        drawerLayout.closeDrawers();
                    }
//                    return true;
                    break;
                case R.id.action_group_chat:
                    RecyclerViewFragment.mstaticRecyclerView.setLayoutManager(new GridLayoutManager(RecyclerViewFragment.RecyclerViewFragmentContext,3));
                    Toast.makeText(this,"GridLayoutManager",Toast.LENGTH_LONG).show();
                    break;
                case R.id.action_add:
                    RecyclerViewFragment.mstaticRecyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewFragment.RecyclerViewFragmentContext));
                    Toast.makeText(this,"LinearLayoutManager",Toast.LENGTH_LONG).show();
                    break;
                case R.id.action_add_friend:
                    RecyclerViewFragment.mstaticRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
                    Toast.makeText(this,"StaggeredGridLayoutManager",Toast.LENGTH_LONG).show();
                    break;
//                case R.id.action_scan:
//                    RecyclerViewFragment.setmAdapter(new StaggeredRecyclerViewSimpleAdapter(RecyclerViewFragment.RecyclerViewFragmentContext,RecyclerViewFragment.mDatas)
//                    , RecyclerViewFragment.mstaticRecyclerView);
//                    RecyclerViewFragment.mstaticRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
//                    Toast.makeText(this,"Staggered",Toast.LENGTH_LONG).show();
//                    break;
                case R.id.action_feedback:
                    RecyclerViewFragment.smAdapter.addData(1);
                    break;
                case R.id.action_settings:
                    RecyclerViewFragment.smAdapter.deleteDate(1);
                    break;
                default:
                    break;

    }
            return super.onOptionsItemSelected(item);
}

    private void setupDrawerLayout() {

        mDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mDrawerToggle);
        NavigationView view = (NavigationView) findViewById(R.id.navigation_view);
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(MenuItem menuItem) {
                Snackbar.make(content, menuItem.getTitle() + " pressed", Snackbar.LENGTH_LONG).show();
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }


    private void initToolbar() {
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);
        //        if (actionBar != null) {
//            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
    }

    private void initTabs() {
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        if (android.os.Build.VERSION.SDK_INT > 10) {
            mTabHost.getTabWidget().setShowDividers(0);
        }
        MainTab[] tabs = MainTab.values();
        final int size = tabs.length;
        for (int i = 0; i < size; i++) {
            MainTab mainTab = tabs[i];
            TabHost.TabSpec tab = mTabHost.newTabSpec(getString(mainTab.getResName()));
            View indicator = LayoutInflater.from(getApplicationContext())
                    .inflate(R.layout.tab_indicator, null);
            TextView title = (TextView) indicator.findViewById(R.id.tab_title);
            Drawable drawable = this.getResources().getDrawable(
                    mainTab.getResIcon());
            title.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null,
                    null);
            if (i == 2) {
                indicator.setVisibility(View.INVISIBLE);
                mTabHost.setNoTabChangedTag(getString(mainTab.getResName()));
            }
            title.setText(getString(mainTab.getResName()));
            tab.setIndicator(indicator);
            tab.setContent(new TabHost.TabContentFactory() {

                @Override
                public View createTabContent(String tag) {
                    return new View(MainActivity.this);
                }
            });
            mTabHost.addTab(tab, mainTab.getClz(), null);

//            if (mainTab.equals(MainTab.ME)) {
//                View cn = indicator.findViewById(R.id.tab_mes);
//                mBvNotice = new BadgeView(MainActivity.this, cn);
//                mBvNotice.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
//                mBvNotice.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
//                mBvNotice.setBackgroundResource(R.drawable.notification_bg);
//                mBvNotice.setGravity(Gravity.CENTER);
//            }
            mTabHost.getTabWidget().getChildAt(i).setOnTouchListener(this);
        }


    }

    private void setOverflowButtonAlways()
    {
        try
        {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKey = ViewConfiguration.class
                    .getDeclaredField("sHasPermanentMenuKey");
            menuKey.setAccessible(true);
            menuKey.setBoolean(config, false);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }




    @Override
    public void onTabChanged(String tabId) {
        MainTab[] tabs = MainTab.values();

        Log.d("ttttkk", "Change");
        final int size = mTabHost.getTabWidget().getTabCount();
        for (int i = 0; i < size; i++) {
             View v = mTabHost.getTabWidget().getChildAt(i);
             if (i == mTabHost.getCurrentTab()) {
                 MainTab mainTab = tabs[i];
                 v.setSelected(true);

                 String currentTab=mTabHost.getCurrentTabTag();
              FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                 if(getSupportFragmentManager().findFragmentByTag(getString(tabs[i].getResName()))!=null) {
                     ft.show(getSupportFragmentManager().findFragmentByTag(getString(tabs[i].getResName())));
//                 ft.hide(getFragmentManager().findFragmentByTag(String.valueOf(i)));
                     ft.commit();
                 }
            } else {
                 v.setSelected(false);
                 FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                if(getSupportFragmentManager().findFragmentByTag(getString(tabs[i].getResName()))!=null) {
                    ft.hide(getSupportFragmentManager().findFragmentByTag(getString(tabs[i].getResName())));
//                 ft.hide(getFragmentManager().findFragmentByTag(String.valueOf(i)));
                 ft.commit();
                }
             }
        }

        supportInvalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id) {
            case R.id.quick_option_iv:
                showPopupWindow(mAddBt);
                Log.d("f","click");
                break;
            default:
                break;
        }
    }

    private void showPopupWindow(View parent) {
        if(addpopWindow==null) {
            LayoutInflater inflater = (LayoutInflater) this.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.add_popwindow_layout, null);
            addpopWindow=new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,200);
            addpopWindow.setFocusable(true);
            addpopWindow.setOutsideTouchable(true);
            addpopWindow.setBackgroundDrawable(new BitmapDrawable());
            addpopWindow.showAsDropDown(parent, Gravity.CENTER, 20);

            addpopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    Log.d("f","dismiss");
                    addpopWindow.dismiss();
                    addpopWindow=null;
                }
            });
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 是否退出应用
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                return mDoubleClickExit.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    class BitMapAsyncTask extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            headerImage.setImageBitmap(bitmap);
            mProgressBar.setVisibility(View.GONE);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String url= params[0];
            Bitmap bitmap=null;
            URLConnection connection;
            InputStream is;
            try {
                connection=new URL(url).openConnection();
                is=connection.getInputStream();
                BufferedInputStream bis=new BufferedInputStream(is);
                Thread.sleep(3000);
                bitmap= BitmapFactory.decodeStream(bis);
                is.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return bitmap;
        }
    }
}
