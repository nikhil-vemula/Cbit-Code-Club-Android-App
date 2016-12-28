package com.cbitcodeclub.vsnick.cbitcodeclub;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cbitcodeclub.vsnick.cbitcodeclub.Adapter.TabsPageAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment{

    private static final String TAG = "News Fragment";
    private ViewPager viewPager ;
    private TabLayout tabLayout;
    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        TabsPageAdapter tabsPageAdapter = new TabsPageAdapter(getActivity().getSupportFragmentManager());
        viewPager = (ViewPager) getActivity().findViewById(R.id.viewPager);
        viewPager.setAdapter(tabsPageAdapter);

        tabLayout = (TabLayout) getActivity().findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
    }
}
