package com.project.server.searchOrder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class storageRequest {

    @JsonProperty(value="storage")
    public String storage;

    public String getNum() {
        return storage;
    }

    public void setNum(String num) {
        this.storage = storage;
    }
}
