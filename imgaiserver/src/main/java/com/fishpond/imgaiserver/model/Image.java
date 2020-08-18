package com.fishpond.imgaiserver.model;

import java.io.Serializable;

public class Image implements Serializable {
    private int id;
    private String imgUrl;
    private Double imgSize;

    public Image() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getImgSize() {
        return imgSize;
    }

    public void setImgSize(Double imgSize) {
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
