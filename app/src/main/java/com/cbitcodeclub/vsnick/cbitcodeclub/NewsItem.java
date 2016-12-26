package com.cbitcodeclub.vsnick.cbitcodeclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class NewsItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("post");
        final String title = bundle.getString("title");
        final String desc = bundle.getString("desc");
        final String tag = bundle.getString("tag");
        setTitle(title);
        TextView textView = (TextView) findViewById(R.id.desc);
        textView.setText(Html.fromHtml(desc));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "*"+title+"*\n"+desc;
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT,message);
                try {
                    startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.newsCoordinatorLayout);
                    Snackbar.make(coordinatorLayout,"Whatsapp Not Installed",Snackbar.LENGTH_SHORT).show();
                }
            }
        });


    }
}
