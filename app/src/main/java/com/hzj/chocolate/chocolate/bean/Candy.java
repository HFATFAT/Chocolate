package com.hzj.chocolate.chocolate.bean;

/**
 * Created by ff on 15/8/7.
 */
public class Candy extends Entity {

    private String title;

    private String desc;

    private String url;

    private String pubDate;

    private String body;

    public Candy(){

    }
    public Candy(String title,String desc,String url,String pubDate,String body){
        super();
        this.title=title;
        this.desc=desc;
        this.url=url;
        this.pubDate=pubDate;
        this.body=body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }


}
