package com.lkefalas.samplemoviedatabase.domain;

public enum ShowType {
    MOVIE("movie"), TV_SHOW("tv_show");
    private final String type;

    ShowType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}