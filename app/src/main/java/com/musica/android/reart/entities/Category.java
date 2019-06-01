package com.musica.android.reart.entities;

import com.google.gson.annotations.SerializedName;

public class Category {
    String keyword;
    int id;

    public Category(String keyword, int id) {
        this.keyword = keyword;
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getId() {
        return id;
    }
}
