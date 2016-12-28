package com.cbitcodeclub.vsnick.cbitcodeclub;


import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cbitcodeclub.vsnick.cbitcodeclub.Adapter.recyclerViewAdapter;
import com.cbitcodeclub.vsnick.cbitcodeclub.Objects.Post;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CCCNewsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View loading;
    String TAG = "dbg";

    public CCCNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cccnews, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CoordinatorLayout layout = (CoordinatorLayout) getActivity().findViewById(R.id.coordinatorLayout);
        ConnectivityManager cm =
                (ConnectivityManager)getActivity().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if(isConnected){
            loadPosts();
        }
        else{
            Snackbar.make(layout,"No internet",Snackbar.LENGTH_LONG).show();
        }
        BroadcastReceiver onComplete=new BroadcastReceiver() {
            public void onReceive(Context ctxt, Intent intent) {
                loadPosts();
            }
        };
        getActivity().getApplicationContext().registerReceiver(onComplete, new IntentFilter(cm.CONNECTIVITY_ACTION));
    }



    void loadPosts(){
        final ArrayList<Post> posts = new ArrayList<Post>();
        loading = getActivity().findViewById(R.id.loading);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("notifications");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Post post;
                posts.clear();
                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                    String title = (String) messageSnapshot.child("title").getValue();
                    String desc = (String) messageSnapshot.child("content").getValue();
                    String tag = (String) messageSnapshot.child("tag").getValue();
                    post = new Post(title, desc, tag);
                    posts.add(post);

                    mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
                    //mRecyclerView.setHasFixedSize(true);
                    mLayoutManager = new LinearLayoutManager(getActivity());
                    mRecyclerView.setLayoutManager(mLayoutManager);
                    mAdapter = new recyclerViewAdapter(getContext(), posts);
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
}

