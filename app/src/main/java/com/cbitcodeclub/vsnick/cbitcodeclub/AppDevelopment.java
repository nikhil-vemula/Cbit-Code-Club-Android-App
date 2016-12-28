package com.cbitcodeclub.vsnick.cbitcodeclub;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cbitcodeclub.vsnick.cbitcodeclub.Adapter.AppDevTabsPageAdapter;
import com.cbitcodeclub.vsnick.cbitcodeclub.Adapter.WebDevTabsPageAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppDevelopment extends Fragment {


    public AppDevelopment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        AppDevTabsPageAdapter appDevTabsPageAdapter = new AppDevTabsPageAdapter(getFragmentManager());
        View view = inflater.inflate(R.layout.fragment_app_development, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.appDevViewPager);
        viewPager.setAdapter(appDevTabsPageAdapter);

        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tabLayoutAppDev);
        tabLayout.setupWithViewPager(viewPager);



        return view;
    }

}
