package com.example.testpostapplication.services;

import androidx.annotation.NonNull;

import com.example.testpostapplication.data.model.Post;
import com.example.testpostapplication.data.model.TranslatorModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public interface PostService {
    static Callback<Post> getTranslationCallback() {
        TranslatorModel translatorModel = TranslatorModel.getInstance();
        return new Callback<Post>() {
            @Override
            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    translatorModel.setResponse(response.body().getContents().getTranslated());
                    System.out.println(response.body().getContents().getTranslated());
                } else if (response.code() == 429) {
                    translatorModel.setResponse("ERROR! Sorry. I am too poor to buy a subscription so you can translate only 5 times per hour and only 60 times per day.");
                    System.out.println("ERROR! Sorry. I am too poor to buy a subscription so you can translate only 5 times per hour and only 60 times per day.");
                } else {
                    translatorModel.setResponse("ERROR! Something really goes wrong. Response code is " + response.code());
                    System.out.println("ERROR! Something really goes wrong. Response code is " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
            }
        };
    }
}