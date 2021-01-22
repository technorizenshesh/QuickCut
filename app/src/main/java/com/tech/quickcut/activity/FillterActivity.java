package com.tech.quickcut.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import com.tech.quickcut.R;
import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.IndicatorType;
import com.warkiz.widget.TickMarkType;

public class FillterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillter);


        IndicatorSeekBar seekBar = IndicatorSeekBar
                .with(this)
                .max(110)
                .min(10)
                .progress(53)
                .tickCount(7)
                .showTickMarksType(TickMarkType.OVAL)
                .tickMarksColor(getResources().getColor(R.color.colorpurple, null))
                .tickMarksSize(13)//dp
                .showTickTexts(true)
                .tickTextsColor(getResources().getColor(R.color.teal_200))
                .tickTextsSize(13)//sp
                .tickTextsTypeFace(Typeface.MONOSPACE)
                .showIndicatorType(IndicatorType.ROUNDED_RECTANGLE)
                .indicatorColor(getResources().getColor(R.color.colorpurple))
                .indicatorTextColor(Color.parseColor("#ffffff"))
                .indicatorTextSize(13)//sp
                .thumbColor(getResources().getColor(R.color.colorpurple, null))
                .thumbSize(14)
                .trackProgressColor(getResources().getColor(R.color.colorpurple,null))
                .trackProgressSize(4)
                .trackBackgroundColor(getResources().getColor(R.color.colorGray))
                .trackBackgroundSize(2)
                .onlyThumbDraggable(false)
                .build();
    }

    public void OnfillterAppyBtn(View view) {
        finish();
        onBackPressed();
    }
}