package com.cbitcodeclub.vsnick.cbitcodeclub.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cbitcodeclub.vsnick.cbitcodeclub.Objects.AppDevTutorial;
import com.cbitcodeclub.vsnick.cbitcodeclub.Objects.WebDevTutorial;
import com.cbitcodeclub.vsnick.cbitcodeclub.R;
import com.google.firebase.crash.FirebaseCrash;

import java.util.ArrayList;

/**
 * Created by mdaij on 12/28/2016.
 */
public class AppDevTutorialsRecycler extends RecyclerView.Adapter<AppDevTutorialsRecycler.AppDevTutorialsHolder> {

    static Context context;
    static ArrayList<AppDevTutorial> appDevTuts;
    //  WebDevTutorial webDevTutorial;

    public AppDevTutorialsRecycler(Context context, ArrayList<AppDevTutorial> appDevTuts) {

        AppDevTutorialsRecycler.context = context;
        this.appDevTuts = appDevTuts;
    }

    @Override
    public AppDevTutorialsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_tutorials_item, parent, false);
        AppDevTutorialsHolder holder = new AppDevTutorialsHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AppDevTutorialsHolder holder, int position) {
        holder.title.setText(appDevTuts.get(position).getTitle());
        holder.tag.setText(appDevTuts.get(position).getTag());
        holder.desc.setText(appDevTuts.get(position).getDesc());
        String tagval = appDevTuts.get(position).getTag();
        if(tagval == "html"){
            holder.tag.setTextColor(Color.BLUE);
        }
        else if(tagval == "bootstrap"){
            holder.tag.setTextColor(Color.MAGENTA);
        }
        else{
            holder.tag.setTextColor(Color.GREEN);
        }
    }

    @Override
    public int getItemCount() {

        return appDevTuts.size();
    }

    public static class AppDevTutorialsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title,tag,desc;
        public AppDevTutorialsHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.appTutTitleID);
            tag = (TextView)itemView.findViewById(R.id.appTagID);
            desc = (TextView)itemView.findViewById(R.id.appDescID);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(appDevTuts.get(position).getUrl()));
            try {
                context.startActivity(browserIntent);
            }catch (Exception e){
                FirebaseCrash.log("Intent not found");
            }
        }
    }
}

