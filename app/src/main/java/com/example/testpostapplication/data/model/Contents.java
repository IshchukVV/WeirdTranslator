package com.example.testpostapplication.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contents {

    @SerializedName("translated")
    @Expose
    private String translated;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("translation")
    @Expose
    private String translation;

    public String getTranslated() {
        return translated;
    }

    public String getText() {
        return text;
    }

    public String getTranslation() {
        return translation;
    }
}
