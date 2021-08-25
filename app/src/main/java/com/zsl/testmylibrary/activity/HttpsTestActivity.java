package com.zsl.testmylibrary.activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.zsl.mylibrary.httpsUtils.HttpRequest;
import com.zsl.mylibrary.httpsUtils.OkHttpException;
import com.zsl.mylibrary.httpsUtils.ResponseCallback;
import com.zsl.testmylibrary.R;
import com.zsl.testmylibrary.config.AppSettings;


public class HttpsTestActivity extends AppCompatActivity {

    private Button login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }

    private void getData() {
        new HttpRequest(this).getDataApi(AppSettings.AppVersionData,new ResponseCallback(){

            @Override
            public void onSuccess(Object object) {
                Log.d("==============",object.toString());
                Intent intent = new Intent("com.admin.login");
                sendBroadcast(intent);
                finish();
            }

            @Override
            public void onFailure(OkHttpException failuer) {
                Log.d("==============",failuer.getEmsg());
            }
        });
    }
}