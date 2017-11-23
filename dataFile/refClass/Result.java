package com.isport.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snowlive on 17-7-12.
 */

public class Result {
    private String stat ="";
    private List<News> data = new ArrayList<News>();

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<News> getData() {
        return data;
    }

    public void setData(List<News> data) {
        this.data = data;
    }
}
