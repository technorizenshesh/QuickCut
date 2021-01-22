package com.tech.quickcut.activity.HomeDetailsScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tech.quickcut.Preference;
import com.tech.quickcut.QuickGender.QuickGender;
import com.tech.quickcut.R;
import com.tech.quickcut.activity.HomeDetailsScreen.Abouts.AboutsFragment;
import com.tech.quickcut.activity.HomeDetailsScreen.Gallary.GallaryFragment;
import com.tech.quickcut.activity.HomeDetailsScreen.Review.ReviewFragment;
import com.tech.quickcut.activity.HomeDetailsScreen.Services.ServicesFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeDetailsActivity extends AppCompatActivity{

    RecyclerView recycler_view_saloon_specialist;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView txt_open;
    private ImageView Saloon_img;
    private TextView saloon_name;
    private TextView txt_view_rating;
    private TextView txt_address;

    private Preference preference;
    private ProgressBar progressBar;
    private String android_id ="";
    private Button btn_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_details);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(
                    this, R.color.purple_200));
        }

        //android device Id
        android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        preference = new Preference(this);

        findview();

        txt_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent=new Intent(SaloonShopDetailsActivity.this, SaloonshopGender.class);
                startActivity(intent);*/
            }
        });

        String CategoryId =  Preference.get(HomeDetailsActivity.this,Preference.KEY_CategoryId);

     /*   if (preference.isNetworkAvailable()) {

            progressBar.setVisibility(View.VISIBLE);

            getHomeSaloon(CategoryId);

        }else {

            Toast.makeText(this, R.string.checkInternet, Toast.LENGTH_SHORT).show();
        }*/
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Intent intent=new Intent(HomeDetailsActivity.this, QuickGender.class);
                startActivity(intent);
            }
        });

    }
    private void findview() {
        recycler_view_saloon_specialist=findViewById(R.id.recycler_view_saloon_specialist);
        btn_book=findViewById(R.id.btn_book);
        txt_open=findViewById(R.id.txt_open);
        progressBar=findViewById(R.id.progressBar);
        saloon_name=findViewById(R.id.saloon_name);
        Saloon_img=findViewById(R.id.Saloon_img);
        txt_view_rating=findViewById(R.id.txt_view_rating);
        txt_address=findViewById(R.id.txt_address);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFrag(new AboutsFragment(), "About");
        adapter.addFrag(new ServicesFragment(), "Services");
        adapter.addFrag(new GallaryFragment(), "Gallary");
        adapter.addFrag(new ReviewFragment(), "Review");

        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }

}
