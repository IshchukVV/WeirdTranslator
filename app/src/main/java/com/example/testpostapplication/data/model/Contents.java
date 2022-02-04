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

    public void setTranslated(String translated) {
        this.translated = translated;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

}
