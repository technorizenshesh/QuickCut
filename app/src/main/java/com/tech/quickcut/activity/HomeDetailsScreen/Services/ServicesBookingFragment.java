package com.tech.quickcut.activity.HomeDetailsScreen.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import com.tech.quickcut.R;

public class ServicesBookingFragment extends Fragment {

    View rootView;
    private Button btn_book_now1;
    ProgressBar progressBar;


    public static ServicesBookingFragment newInstance(String param1, String param2) {
        ServicesBookingFragment fragment = new ServicesBookingFragment();
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
        rootView = inflater.inflate(R.layout.services_fragment_booking, container, false);
        btn_book_now1=rootView.findViewById(R.id.btn_book_now1);
        progressBar=rootView.findViewById(R.id.progressBar);
        btn_book_now1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent intent=new Intent(getActivity(), SaloonshopGender.class);
              /*  Intent intent=new Intent(getActivity(), SaloonSelectedDate.class);
                startActivity(intent);*/
            }
        });

        //android device Id

        return  rootView;
    }


}
