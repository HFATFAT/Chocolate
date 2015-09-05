package com.hzj.chocolate.chocolate.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.hzj.chocolate.chocolate.R;


/**
 * Created by ff on 15/7/6.
 */
public class SplashActivity extends Activity{
    private Handler handler=new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final View view = View.inflate(this, R.layout.splash, null);
        setContentView(view);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.alpha);
        view.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {goHome();
                    }
                },500);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void goHome() {
//        openActivity(MainActivity.class);
//        defaultFinish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
