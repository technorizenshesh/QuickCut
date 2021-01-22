package com.tech.quickcut.activity.HomeDetailsScreen.Gallary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.tech.quickcut.Preference;
import com.tech.quickcut.R;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

public class GallaryFragment extends Fragment{

    View rootView;
    RecyclerView recycler_view_gallery;
    private GallaryRecyclerViewAdapter mAdapter;
    private ArrayList<GallaryModel> modelList = new ArrayList<>();

    private Preference preference;

    public static GallaryFragment newInstance(String param1, String param2) {
        GallaryFragment fragment = new GallaryFragment();
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
        rootView = inflater.inflate(R.layout.gallary_fragment, container, false);

       // recycler_view_gallery=rootView.findViewById(R.id.recycler_view_gallery);

     //   String CategoryId =  Preference.get(getActivity(),Preference.KEY_CategoryId);

     //   preference = new Preference(getActivity());

      /*  if (preference.isNetworkAvailable()) {

            getHomeSaloon(CategoryId);

        }else {

            Toast.makeText(getActivity(), R.string.checkInternet, Toast.LENGTH_SHORT).show();
        }*/


        return  rootView;
    }

    private void setAdapter(ArrayList<GallaryModel> modelList) {

        mAdapter = new GallaryRecyclerViewAdapter(getActivity(),modelList);
        recycler_view_gallery.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recycler_view_gallery.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recycler_view_gallery.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new GallaryRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, GallaryModel model) {

            }
        });
    }



}
