package com.example.testpostapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testpostapplication.data.model.Post;
import com.example.testpostapplication.data.model.TranslatorModel;
import com.example.testpostapplication.data.remote.APIService;
import com.example.testpostapplication.data.remote.ApiUtils;
import com.example.testpostapplication.databinding.ActivityTranslateScreenBinding;
import com.example.testpostapplication.services.PostService;

import retrofit2.Callback;

public class TranslateScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TranslatorModel translatorModel = TranslatorModel.getInstance();
        ActivityTranslateScreenBinding translateScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_translate_screen);
        translateScreenBinding.setTranslatorModel(translatorModel);

        final EditText bodyEt = findViewById(R.id.et_body);
        final Button submitBtn = findViewById(R.id.btn_submit);
        final Button goBackBtn = findViewById(R.id.btn_goBack);

        View.OnClickListener goBackOnClick = v -> onBackPressed();

        goBackBtn.setOnClickListener(goBackOnClick);

        View.OnClickListener translateBtnOnClick = view -> {
            runOnUiThread(() -> {
                APIService mAPIService = ApiUtils.getAPIService();
                Callback<Post> translationCallBack = PostService.getTranslationCallback();
                translatorModel.setResponse("Please wait...");
                String body = bodyEt.getText().toString().trim();
                if (!TextUtils.isEmpty(body)) {
                    mAPIService.savePost(translatorModel.getTranslatorType(), body)
                            .enqueue(translationCallBack);
                }
            }
            );
        };
        submitBtn.setOnClickListener(translateBtnOnClick);
    }

}