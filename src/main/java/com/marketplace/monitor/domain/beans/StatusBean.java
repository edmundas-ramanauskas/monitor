package com.marketplace.monitor.domain.beans;

/**
 *
 * @author edmundas
 */
public class StatusBean {
    private int code;
    private String text;
    private float time;
    
    public StatusBean(int code, String text, float time) {
        this.code = code;
        this.text = text;
        this.time = time;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
}
