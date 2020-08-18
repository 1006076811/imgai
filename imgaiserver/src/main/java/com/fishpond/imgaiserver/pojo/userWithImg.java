package com.fishpond.imgaiserver.pojo;

import java.io.Serializable;

public class userWithImg implements Serializable {
    private int id;
    private int uid;
    private int iid;

    public userWithImg() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    @Override
    public String toString() {
        return "userWithImg{" +
                "id=" + id +
                ", uid=" + uid +
                ", iid=" + iid +
                '}';
    }
}
