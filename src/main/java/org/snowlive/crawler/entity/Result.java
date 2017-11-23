package org.snowlive.crawler.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Class For:
 *
 * @auther: 尹振坤
 * @date: 17-11-22
 */
public class Result {

    private Integer status = 0;
    private String msg = "error";
    private List<SchoolResult> data = new ArrayList<SchoolResult>(20);

    public Result(){}


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public List<SchoolResult> getData() {
        return data;
    }

    public void setData(List<SchoolResult> data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
