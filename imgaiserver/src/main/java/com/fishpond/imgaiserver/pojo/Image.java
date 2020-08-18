package com.fishpond.imgaiserver.pojo;

import java.io.Serializable;

public class Image implements Serializable {
    private int id;
    private int imgUrl;
    private int imgSize;

    public Image() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getImgSize() {
        return imgSize;
    }

    public void setImgSize(int imgSize) {
        this.imgSize = imgSize;
    }

    @Override
    public String toString() {
        return "image{" +
                "id=" + id +
                ", imgUrl=" + imgUrl +
                ", imgSize=" + imgSize +
                '}';
    }
}
