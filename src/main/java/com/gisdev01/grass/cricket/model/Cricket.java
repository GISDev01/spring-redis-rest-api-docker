package com.gisdev01.grass.cricket.model;

import java.io.Serializable;

public class Cricket implements Serializable {

    private String id;
    private String name;
    private String md5;
    private String comments;

    private final String KEY_PREFIX = "CRICKET:";

    public Cricket(String id, String name,
                   String md5) {
        this.id = id;
        this.name = name;
        this.md5 = md5;
    }

    public String getKey() {
        return KEY_PREFIX+id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
