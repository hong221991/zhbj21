package com.itheima.zhbj21;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

/*
* 引导页面
* */
public class GuideUI extends Activity {
    private ViewPager mPager;
    private List<ImageView> mList;//引导页面的ImageView的存放集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_ui);
        mPager = (ViewPager) findViewById(R.id.guide_pager);
        //初始化数据
        initData();
    }
    //初始化数据
    private void initData() {
        int[] imgRes = new int[]{
                R.drawable.guide_1,
                R.drawable.guide_2,
                R.drawable.guide_3
        };
        mList = new ArrayList<ImageView>();
        for (int i = 0; i < imgRes.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(imgRes[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            mList.add(iv);
        }
        mPager.setAdapter(new GuidePagerAdapter());
    }
    //mPager的适配器
    class GuidePagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            if (mList != null) {
                return mList.size();
            }
            return 0;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv=mList.get(position);
            container.addView(iv);
            return iv;
        }
        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
