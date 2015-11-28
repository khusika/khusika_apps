package com.example.khusika.tryslidemenu.adapter;

/**
 * Created by khusika on 27/11/15.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.khusika.tryslidemenu.model.ViewPagerItem;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<ViewPagerItem> mViewPagerItems;

    public ViewPagerAdapter(FragmentManager fm, List<ViewPagerItem> viewPagerItems) {
        super(fm);

        mViewPagerItems = viewPagerItems;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mViewPagerItems.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return mViewPagerItems.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mViewPagerItems.get(position).getFragment();
    }

}
