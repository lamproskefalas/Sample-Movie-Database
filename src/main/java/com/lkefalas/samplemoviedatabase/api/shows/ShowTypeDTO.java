package com.lkefalas.samplemoviedatabase.api.shows;

public enum ShowTypeDTO {
    MOVIE("movie"), TV_SHOW("tv_show");
    private final String type;

    ShowTypeDTO(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
