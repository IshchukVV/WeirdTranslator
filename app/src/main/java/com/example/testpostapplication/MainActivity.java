package com.example.testpostapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.testpostapplication.data.model.TranslatorModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permissionCheck();
        TranslatorModel translatorModel = TranslatorModel.getInstance();
        ImageButton mask1 = findViewById(R.id.mask1);
        ImageButton mask2 = findViewById(R.id.mask2);
        ImageButton mask3 = findViewById(R.id.mask3);
        ImageButton mask4 = findViewById(R.id.mask4);

        View.OnClickListener onClickListener = view -> {
            switch (view.getId()) {
                case R.id.mask1:
                    translatorModel.setTranslatorType("minion");
                    translatorModel.setTranslatorTitle("Funny yellows Minion");
                    break;
                case R.id.mask2:
                    translatorModel.setTranslatorType("yoda");
                    translatorModel.setTranslatorTitle("Master Yoda");
                    break;
                case R.id.mask3:
                    translatorModel.setTranslatorType("groot");
                    translatorModel.setTranslatorTitle("Talking tree Groot");
                    break;
                case R.id.mask4:
                    translatorModel.setTranslatorType("hodor");
                    translatorModel.setTranslatorTitle("Big Man Hodor");
                    break;
                default:
                    Toast.makeText(MainActivity.this, "Unexpected Translator Code", Toast.LENGTH_SHORT).show();
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }
            startActivity(new Intent(MainActivity.this, TranslateScreen.class));
        };
        mask1.setOnClickListener(onClickListener);
        mask2.setOnClickListener(onClickListener);
        mask3.setOnClickListener(onClickListener);
        mask4.setOnClickListener(onClickListener);
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED |
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_NETWORK_STATE,
            }, 1000);
        }
    }
}