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

import com.cbitcodeclub.vsnick.cbitcodeclub.Objects.WebDevTutorial;
import com.cbitcodeclub.vsnick.cbitcodeclub.R;
import com.cbitcodeclub.vsnick.cbitcodeclub.TutorialActivity;

import java.util.ArrayList;

/**
 * Created by mdaij on 12/27/2016.
 */
public class WebDevTutorialsRecycler extends RecyclerView.Adapter<WebDevTutorialsRecycler.WebDevTutorialsHolder> {

    static Context context;
    static ArrayList<WebDevTutorial> webDevTuts;
  //  WebDevTutorial webDevTutorial;

    public WebDevTutorialsRecycler(Context context, ArrayList<WebDevTutorial> webDevTuts) {

        WebDevTutorialsRecycler.context = context;
        this.webDevTuts = webDevTuts;
    }

    @Override
    public WebDevTutorialsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.web_tutorials_item, parent, false);
        WebDevTutorialsHolder holder = new WebDevTutorialsHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(WebDevTutorialsHolder holder, int position) {
        holder.title.setText(webDevTuts.get(position).getTitle());
        holder.tag.setText(webDevTuts.get(position).getTag());
        holder.desc.setText(webDevTuts.get(position).getDesc());
        String tagval = webDevTuts.get(position).getTag();
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

        return webDevTuts.size();
    }

    public static class WebDevTutorialsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title,tag, desc;

        public WebDevTutorialsHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.webTutTitleID);
            tag = (TextView)itemView.findViewById(R.id.webTagID);
            desc = (TextView)itemView.findViewById(R.id.webTutDesc);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, TutorialActivity.class);
            intent.putExtra("post",webDevTuts.get(getAdapterPosition()));
            context.startActivity(intent);
        }
    }
}
