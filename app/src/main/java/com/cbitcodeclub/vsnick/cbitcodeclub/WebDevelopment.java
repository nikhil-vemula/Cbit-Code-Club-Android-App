package com.cbitcodeclub.vsnick.cbitcodeclub;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cbitcodeclub.vsnick.cbitcodeclub.Adapter.WebDevTabsPageAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebDevelopment extends Fragment {


    public WebDevelopment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        WebDevTabsPageAdapter webDevTabsPageAdapter = new WebDevTabsPageAdapter(getFragmentManager());
        View view = inflater.inflate(R.layout.fragment_web_development, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPagerWebDev);
        viewPager.setAdapter(webDevTabsPageAdapter);

        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tabLayoutWebDev);
        tabLayout.setupWithViewPager(viewPager);



        return view;
    }

}
