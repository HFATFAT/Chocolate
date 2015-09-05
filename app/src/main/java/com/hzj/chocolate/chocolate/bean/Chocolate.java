package com.hzj.chocolate.chocolate.bean;

/**
 * Created by ff on 15/8/7.
 */
public class Chocolate extends Entity {

    private String title;

    private String desc;


    private String time;

    private String price;

    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }


    public Chocolate(){

    }
    public Chocolate(String title, String desc, String time, String price){
        super();
        this.title=title;
        this.desc=desc;
        this.time=time;
        this.price=price;
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
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



}
