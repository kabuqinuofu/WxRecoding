package com.yc.wxrecoding.model;

/**
 * @author kabuqinuofu
 */
public class RecorderBean {

    public float time;
    public String filePath;

    public RecorderBean(float time, String filePath) {
        this.time = time;
        this.filePath = filePath;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

