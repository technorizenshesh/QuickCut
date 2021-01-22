package com.tech.quickcut.activity.HomeDetailsScreen.Review;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tech.quickcut.R;

public class ReviewFragment extends Fragment {

    View rootView;
    private ProgressBar progressBar;
    TextView txt_write;
    RelativeLayout RR_all_review;
    Button btn_save;

    boolean isReview=false;

    public static ReviewFragment newInstance(String param1, String param2) {
        ReviewFragment fragment = new ReviewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.review_fragment, container, false);

        progressBar=rootView.findViewById(R.id.progressBar);
        txt_write=rootView.findViewById(R.id.txt_write);
        RR_all_review=rootView.findViewById(R.id.RR_all_review);
        btn_save=rootView.findViewById(R.id.btn_save);

        txt_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isReview)
                {
                    RR_all_review.setVisibility(View.GONE);
                    isReview=false;

                }else
                {
                    RR_all_review.setVisibility(View.VISIBLE);
                    isReview=true;
                }
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RR_all_review.setVisibility(View.GONE);

            }
        });

        return  rootView;
    }



}
