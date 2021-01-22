package com.tech.quickcut.activity.BookTImeDateScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tech.quickcut.QuickGender.QuickGender;
import com.tech.quickcut.R;
import com.tech.quickcut.activity.BookingDetailsScreen.BookingDetailsActivity;

public class BookTimeDate extends AppCompatActivity {

    private TextView btn_book_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_time_date);

        btn_book_now=findViewById(R.id.btn_book_now);
        btn_book_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(BookTimeDate.this, BookingDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}