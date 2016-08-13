package com.itheima.zhbj21;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

import com.itheima.zhbj21.utils.CacheUtils;

/*
* 欢迎界面
* */
public class WelcomeUI extends Activity {
    private View welcome_container;
    private long DURATION = 1000;//动画播放的时间
    private String IS_FRIST = "is_first";//记录第一次进入的Key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_ui);
        welcome_container = findViewById(R.id.welcome_container);
        //定义一个动画集合
        AnimationSet set = new AnimationSet(false);
        //设置旋转动画
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setFillEnabled(true);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(DURATION);
        //缩放动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(DURATION);
        //透明度渐变动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
        alphaAnimation.setFillEnabled(true);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(DURATION);
        //将动画添加到动画集合中
        set.addAnimation(rotateAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);
        //开启动画
        welcome_container.startAnimation(set);
        //设置动画的监听
        set.setAnimationListener(new Animation.AnimationListener() {
            //动画开始时的回调
            @Override
            public void onAnimationStart(Animation animation) {

            }

            //动画结束时的回调
            @Override
            public void onAnimationEnd(Animation animation) {
                //此处要判断应用是否为第一次启动
                boolean isFirst = CacheUtils.getBoolean(WelcomeUI.this, IS_FRIST);
                if (!isFirst) {

                    //TODO:将缓存的key中的值改为true，并记录；
                   // CacheUtils.setBoolean(WelcomeUI.this, IS_FRIST, true);
                    //若第一次启动，进入引导页面
                    Intent intent = new Intent(WelcomeUI.this, GuideUI.class);
                    startActivity(intent);
                } else {
                    //若不是第一次，直接进入主页面
                    Intent intent = new Intent(WelcomeUI.this, MainUI.class);
                    startActivity(intent);
                }
                finish();
            }

            //动画重复时的回调
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


}
