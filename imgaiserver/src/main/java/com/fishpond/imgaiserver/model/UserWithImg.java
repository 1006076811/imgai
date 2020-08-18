package com.fishpond.imgaiserver.model;

import java.io.Serializable;

public class UserWithImg implements Serializable {
    private int id;
    private int uid;
    private int iid;

    public UserWithImg() {
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
