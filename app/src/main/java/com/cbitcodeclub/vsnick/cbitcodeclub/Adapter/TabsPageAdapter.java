package com.cbitcodeclub.vsnick.cbitcodeclub.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.cbitcodeclub.vsnick.cbitcodeclub.CCCNewsFragment;
import com.cbitcodeclub.vsnick.cbitcodeclub.CbitNewsFragment;

/**
 * Created by vsnick on 12/25/2016.
 */

public class TabsPageAdapter extends FragmentStatePagerAdapter {
    private static final String TAG ="TabPagerAdapter" ;

    public TabsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new CbitNewsFragment();
            case 1: return new CCCNewsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0: return "Cbit News";
            case 1: return "CCC News";
        }
        return super.getPageTitle(position);
    }
}
