package com.hzj.chocolate.chocolate.bean;

/**
 * Created by FF on 2015/8/30.
 */
public class ViewModel {
    private String text;
    private String image;

    public ViewModel(String text, String image) {
        this. text = text;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }
}
