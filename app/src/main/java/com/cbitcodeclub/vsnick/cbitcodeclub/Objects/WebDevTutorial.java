package com.cbitcodeclub.vsnick.cbitcodeclub.Objects;

import java.io.Serializable;

/**
 * Created by mdaij on 12/27/2016.
 */
public class WebDevTutorial {
    private String desc,tag,title,url;

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
