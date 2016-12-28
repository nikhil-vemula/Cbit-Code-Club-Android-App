package com.cbitcodeclub.vsnick.cbitcodeclub.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cbitcodeclub.vsnick.cbitcodeclub.CbitNewsFragment;
import com.cbitcodeclub.vsnick.cbitcodeclub.TutorialsFragment;
import com.cbitcodeclub.vsnick.cbitcodeclub.WebDevelopment;

/**
 * Created by mdaij on 12/26/2016.
 */

public class WebDevTabsPageAdapter extends FragmentStatePagerAdapter {

    public WebDevTabsPageAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TutorialsFragment();
            case 1:
                return new CbitNewsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {

        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Tutorials";
            case 1:
                return "Videos";
            default:
                return "Tutorials";
        }
        // return super.getPageTitle(position);
    }
}
