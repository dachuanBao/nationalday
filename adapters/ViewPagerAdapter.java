package com.learn.bdc.nationalsday.adapters;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.learn.bdc.nationalsday.R;

import java.util.List;

/**
 * Created by Administrator on 2016/09/30.
 */
public class ViewPagerAdapter extends PagerAdapter{
    private List<View> datas;
    public ViewPagerAdapter(List<View> datas) {
        this.datas=datas;
    }


    @Override
    public int getCount() {
        return datas==null?0:datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view=datas.get(position);
        ViewPager vp=(ViewPager) container;
        vp.removeView(view);


    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=datas.get(position);


        ViewPager vp=(ViewPager) container;
        vp.addView(view);
        return view;
    }
}
