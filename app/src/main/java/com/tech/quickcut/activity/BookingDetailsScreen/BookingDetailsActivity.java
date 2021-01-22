package com.tech.quickcut.activity.BookingDetailsScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.tech.quickcut.R;
import com.tech.quickcut.activity.HomeActivity;
import com.tech.quickcut.activity.HomeDetailsScreen.HomeDetailsActivity;

public class BookingDetailsActivity extends AppCompatActivity {

    private TextView btn_book_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        btn_book_now=findViewById(R.id.btn_book_now);
        btn_book_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button bttn_cong;
                final Dialog dialog = new Dialog(BookingDetailsActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCancelable(false);
                dialog.show();
                dialog.setContentView(R.layout.congratulation);
                bttn_cong=dialog.findViewById(R.id.bttn_cong);

                bttn_cong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent=new Intent(BookingDetailsActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                        dialog.dismiss();
                    }
                });

            }
        });
    }
}