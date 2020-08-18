package com.fishpond.imgaiserver.model;

import java.io.Serializable;

public class MenuRole implements Serializable {
    private int id;
    private int mid;
    private int rid;

    public MenuRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "MenuRole{" +
                "id=" + id +
                ", mid=" + mid +
                ", rid=" + rid +
                '}';
    }
}
