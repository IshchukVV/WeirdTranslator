package com.example.testpostapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testpostapplication.data.model.Post;
import com.example.testpostapplication.data.model.TranslatorModel;
import com.example.testpostapplication.data.remote.APIService;
import com.example.testpostapplication.data.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TranslateScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_screen);

        System.out.println("Translate screen activity started");

        final EditText bodyEt = findViewById(R.id.et_body);
        final Button submitBtn = findViewById(R.id.btn_submit);
        final TextView mResponseTv = findViewById(R.id.tv_response);

        APIService mAPIService = ApiUtils.getAPIService();
        submitBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             String body = bodyEt.getText().toString().trim();
                                             if (!TextUtils.isEmpty(body)) {
                                                 sendPost(body);
                                             }
                                         }

                                         private void sendPost(String body) {
                                             mAPIService.savePost(TranslatorModel.getTranslatorType(), body)
                                                     .enqueue(new Callback<Post>() {
                                                 @Override
                                                 public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                                                     if (response.isSuccessful()) {
                                                         assert response.body() != null;
                                                         showResponse(response.body().getContents().getTranslated());
                                                     } else if (response.code() == 429) {
                                                         showResponse("ERROR! Sorry. I am too poor to buy a subscription so you can translate only 5 times per hour and only 60 times per day.");
                                                     } else {
                                                         showResponse("ERROR! Something really goes wrong. Response code is " + response.code());
                                                     }
                                                 }

                                                 @Override
                                                 public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                                                 }
                                             });
                                         }

                                         public void showResponse(String response) {
                                             if (mResponseTv.getVisibility() == View.GONE) {
                                                 mResponseTv.setVisibility(View.VISIBLE);
                                             }

                                             mResponseTv.setText(response);
                                         }
                                     }
        );
    }
}