package com.cbitcodeclub.vsnick.cbitcodeclub;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cbitcodeclub.vsnick.cbitcodeclub.Adapter.AppDevTutorialsRecycler;
import com.cbitcodeclub.vsnick.cbitcodeclub.Adapter.WebDevTutorialsRecycler;
import com.cbitcodeclub.vsnick.cbitcodeclub.Objects.AppDevTutorial;
import com.cbitcodeclub.vsnick.cbitcodeclub.Objects.WebDevTutorial;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppTutorialsFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View loading;

    public AppTutorialsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_tutorials, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ConnectivityManager cm =
                (ConnectivityManager)getActivity().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if(isConnected){
            final ArrayList<AppDevTutorial> tutorials = new ArrayList<AppDevTutorial>();
            loading = getActivity().findViewById(R.id.loading);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("AppDev").child("Tutorials");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    AppDevTutorial appDevTutorial;
                    for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                        String desc = (String) messageSnapshot.child("desc").getValue();
                        String tag = (String) messageSnapshot.child("tag").getValue();
                        String title = (String) messageSnapshot.child("title").getValue();
                        String url = (String) messageSnapshot.child("url").getValue();
                        appDevTutorial = new AppDevTutorial(desc,tag,title,url);
                        tutorials.add(appDevTutorial);

                        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.app_tut_rv);
                        mLayoutManager = new LinearLayoutManager(getActivity());
                        mRecyclerView.setLayoutManager(mLayoutManager);
                        mAdapter = new AppDevTutorialsRecycler(getContext(), tutorials);
                        mRecyclerView.setAdapter(mAdapter);
                        loading.setVisibility(View.INVISIBLE);
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) getActivity().findViewById(R.id.coordinatorLayout);
                    Snackbar.make(coordinatorLayout,error.toString(),Snackbar.LENGTH_LONG).show();
                }
            });
        }
        else{
            CoordinatorLayout layout = (CoordinatorLayout) getActivity().findViewById(R.id.coordinatorLayout);
            Snackbar.make(layout,"No Internet",Snackbar.LENGTH_INDEFINITE).show();
        }
    }

}
