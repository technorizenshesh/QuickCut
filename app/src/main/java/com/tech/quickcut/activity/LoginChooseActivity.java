package com.tech.quickcut.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tech.quickcut.R;

public class LoginChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_choose);
    }

    public void ForloginScreen(View view) {
        startActivity(new Intent(this,LoginActivity.class));
    }

    public void FOrsignUpScreen(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }
}