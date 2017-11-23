package com.isport.entity;

/**
 * Created by snowlive on 17-7-12.
 */

public class NewsResults {
    private String reason = "";
    private Result result = new Result();
    private int error_code = 1;


    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
