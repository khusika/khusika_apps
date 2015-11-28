package com.example.khusika.tryslidemenu.Interface;

/**
 * Created by khusika on 27/11/15.
 */

import com.example.khusika.tryslidemenu.handler.ViewPagerHandler;

public interface ViewPager {

    ViewPagerHandler getViewPagerHandler();

    void selectPage(int position);

    void setOnPageChangeListener(
            android.support.v4.view.ViewPager.OnPageChangeListener onPageChangeListener);

    void updateNavigationDrawerTopHandler(ViewPagerHandler viewPagerHandler,
                                          int defaultViewPagerPageSelectedPosition);

    int defaultViewPagerPageSelectedPosition();

}
