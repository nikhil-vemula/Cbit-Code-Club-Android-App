package com.cbitcodeclub.vsnick.cbitcodeclub.Objects;

import android.net.Uri;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by mdaij on 12/27/2016.
 */
public class WebDevTutorial implements Serializable {
    private String desc,tag,title;
    String url;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WebDevTutorial() {

    }

    public WebDevTutorial(String desc, String tag, String title, String url) {

        this.desc = desc;
        this.tag = tag;
        this.title = title;
        this.url = url;
    }
}
