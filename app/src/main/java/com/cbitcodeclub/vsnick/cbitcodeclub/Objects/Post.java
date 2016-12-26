package com.cbitcodeclub.vsnick.cbitcodeclub.Objects;

import android.graphics.Color;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by vsnick on 12/25/2016.
 */

public class Post {
    private String title;
    private String content;
    private String tag;

    public Post(){

    }
    public Post(String title,String content,String tag) {
       this.title = title;
        this.content = content;
        this.tag = tag;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription()
    {
        return content;
    }

    public String getTag(){return tag;}

    public int getTagColor()
    {
        switch(tag){
            case "android":
                return Color.rgb(140,28,201);
            case "web":
                return Color.rgb(66,134,244);
            case "ccc":
                return Color.rgb(25,193,157);
        }
        return Color.rgb(0,0,0);
    }
    public String toString(){
        return  content;
    }
}
