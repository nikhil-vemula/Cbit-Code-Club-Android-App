package com.cbitcodeclub.vsnick.cbitcodeclub.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cbitcodeclub.vsnick.cbitcodeclub.NewsItem;
import com.cbitcodeclub.vsnick.cbitcodeclub.Objects.Post;
import com.cbitcodeclub.vsnick.cbitcodeclub.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by vsnick on 12/25/2016.
 */

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.ViewHolder>{

    static private ArrayList<Post> data;
    static Context context;
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title,description,tag;
        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);
            tag = (TextView) view.findViewById(R.id.tag);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, NewsItem.class);
            int position = getAdapterPosition();
            Bundle bundle=new Bundle();
            bundle.putString("title",data.get(position).getTitle());
            bundle.putString("desc",data.get(position).getDescription());
            bundle.putString("tag",data.get(position).getTag());
            intent.putExtra("post",bundle);
            context.startActivity(intent);

        }
    }
    public recyclerViewAdapter(Context context,ArrayList<Post> posts)
    {
        this.context = context;
        this.data = posts;
    }
    @Override
    public recyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        String desc = data.get(position).getDescription();
        Log.d(TAG, "onBindViewHolder: "+Html.fromHtml(desc).toString());
        holder.description.setText(Html.fromHtml(desc));
        holder.tag.setText(data.get(position).getTag());
        holder.tag.setTextColor(data.get(position).getTagColor());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
