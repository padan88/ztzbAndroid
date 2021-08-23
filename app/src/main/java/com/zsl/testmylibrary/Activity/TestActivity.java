package com.zsl.testmylibrary.Activity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.zsl.testmylibrary.R;
import com.ztzb.zsllibrary.httpsUtils.HttpRequest;
import com.ztzb.zsllibrary.httpsUtils.OkHttpException;
import com.ztzb.zsllibrary.httpsUtils.ResponseCallback;


public class TestActivity extends AppCompatActivity {

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
        String url = "http://tic.cregcloud.com/tic_server/g/mobile/sys/getApkMeta";
        new HttpRequest(this).getDataApi(url,new ResponseCallback(){

            @Override
            public void onSuccess(Object object) {
                Log.d("==============",object.toString());
            }

            @Override
            public void onFailure(OkHttpException failuer) {
                Log.d("==============",failuer.getEmsg());
            }
        });
    }
}