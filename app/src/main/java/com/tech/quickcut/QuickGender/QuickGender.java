package com.tech.quickcut.QuickGender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tech.quickcut.R;
import com.tech.quickcut.SplashActivity;
import com.tech.quickcut.activity.BookTImeDateScreen.BookTimeDate;
import com.tech.quickcut.activity.LoginChooseActivity;

public class QuickGender extends AppCompatActivity {

    private TextView btn_book_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_gender);

        btn_book_now=findViewById(R.id.btn_book_now);
        btn_book_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(QuickGender.this, BookTimeDate.class);
                startActivity(intent);
            }
        });
    }
}