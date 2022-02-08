package com.example.testpostapplication.data.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.testpostapplication.BR;

public class TranslatorModel extends BaseObservable {
    private String translatorType;
    private String translatorTitle;
    private String response;
    private static TranslatorModel instance;

    TranslatorModel(String translatorType, String translatorTitle, String response){
        this.translatorType = translatorType;
        this.translatorTitle = translatorTitle;
        this.response = response;
    }

    public static synchronized TranslatorModel getInstance() {
        if (instance == null) {
            instance = new TranslatorModel("","","");
        }
        return instance;
    }

    public String getTranslatorType() {
        return translatorType;
    }

    public void setTranslatorType(String translatorType) {
        this.translatorType = translatorType;
    }

    public String getTranslatorTitle() {
        return translatorTitle;
    }

    public void setTranslatorTitle(String translatorTitle) {
        this.translatorTitle = translatorTitle;
    }

    @Bindable
    public String getResponse() {
        if (response == null) {
            return "";
        }
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
        notifyPropertyChanged(BR.response);
    }
}