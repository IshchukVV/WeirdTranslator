package com.example.testpostapplication.data.remote;

import com.example.testpostapplication.data.model.Post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {
    @POST("{translatorType}.json")
    @FormUrlEncoded
    Call<Post> savePost(@Path("translatorType") String translatorType, @Field("text") String text);
}