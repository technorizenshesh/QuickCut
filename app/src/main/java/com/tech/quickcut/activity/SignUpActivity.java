package com.tech.quickcut.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tech.quickcut.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void OnRegister(View view) {
        startActivity(new Intent(this,HomeActivity.class));
    }

    public void OnRegisterBack(View view) {
        finish();
        onBackPressed();
    }
}