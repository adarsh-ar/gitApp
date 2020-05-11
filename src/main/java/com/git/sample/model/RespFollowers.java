package com.git.sample.model;

import java.util.List;

public class RespFollowers {
    public List<FollowerItem> getItems() {
        return items;
    }

    public void setItems(List<FollowerItem> items) {
        this.items = items;
    }

    List<FollowerItem> items;
}
