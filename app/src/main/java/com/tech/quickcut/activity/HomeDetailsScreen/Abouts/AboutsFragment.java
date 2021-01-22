package com.tech.quickcut.activity.HomeDetailsScreen.Abouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tech.quickcut.Preference;
import com.tech.quickcut.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class AboutsFragment extends Fragment{

    View rootView;
   private TextView txt_about;
   private TextView txt_address;

   private TextView txt_monday;
   private TextView txt_tuesday;
   private TextView txt_wednesday;
   private TextView txt_thrsday;
   private TextView txt_friday;
   private TextView txt_saturday;
   private TextView txt_sunday;

    private Preference preference;


    public static AboutsFragment newInstance(String param1, String param2) {
        AboutsFragment fragment = new AboutsFragment();
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
        rootView = inflater.inflate(R.layout.activity_allfrnd_fragment, container, false);

        txt_monday = rootView.findViewById(R.id.txt_monday);
        txt_tuesday = rootView.findViewById(R.id.txt_tuesday);
        txt_wednesday = rootView.findViewById(R.id.txt_wednesday);
        txt_thrsday = rootView.findViewById(R.id.txt_thrsday);
        txt_friday = rootView.findViewById(R.id.txt_friday);
        txt_saturday = rootView.findViewById(R.id.txt_saturday);
        txt_sunday = rootView.findViewById(R.id.txt_sunday);
        txt_about = rootView.findViewById(R.id.txt_about);
        txt_address = rootView.findViewById(R.id.txt_address);

        String CategoryId =  Preference.get(getActivity(),Preference.KEY_CategoryId);

        preference = new Preference(getActivity());

     /*   if (preference.isNetworkAvailable()) {

            getHomeSaloon(CategoryId);

        }else {

            Toast.makeText(getActivity(), R.string.checkInternet, Toast.LENGTH_SHORT).show();
        }*/

        return  rootView;
    }

}
