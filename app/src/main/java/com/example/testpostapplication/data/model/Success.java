package com.example.testpostapplication.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Success {

    @SerializedName("total")
    @Expose
    private Integer total;

    public Integer getTotal() {
        return total;
    }
}
