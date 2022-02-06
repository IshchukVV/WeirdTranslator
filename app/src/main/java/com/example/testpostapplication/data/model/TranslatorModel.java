package com.example.testpostapplication.data.model;

public class TranslatorModel {
    public static String translatorType;

    public static String getTranslatorTitle() {
        return translatorTitle;
    }

    public static void setTranslatorTitle(String translatorTitle) {
        TranslatorModel.translatorTitle = translatorTitle;
    }

    public static String translatorTitle;

    public static String getTranslatorType() {
        return translatorType;
    }

    public static void setTranslatorType(String type) {
        translatorType = type;
    }
}