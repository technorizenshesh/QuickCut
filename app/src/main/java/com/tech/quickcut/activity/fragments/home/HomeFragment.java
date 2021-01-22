package com.tech.quickcut.activity.fragments.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tech.quickcut.FragmentListener;
import com.tech.quickcut.R;
import com.tech.quickcut.activity.BookingDetailsScreen.BookingDetailsActivity;
import com.tech.quickcut.activity.HomeActivity;
import com.tech.quickcut.activity.HomeDetailsScreen.HomeDetailsActivity;


public class HomeFragment extends Fragment implements OnMapReadyCallback {

    private HomeViewModel homeViewModel;
    private TextView tab2;
    private TextView tab1;
    FragmentListener listener;
    private CardView card_map;
    private LinearLayout linearRequestId;
    private CardView cardrequestId;

    public HomeFragment(FragmentListener listener) {
        this.listener = listener;
    }

    public HomeFragment() {

    }
    private Circle mCircle;
    private Marker mMarker;
    private GoogleMap mMap;
    private String productlat="22.7533";
    private String productlon="75.8937";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment)this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        linearRequestId=root.findViewById(R.id.linearRequestId);
        card_map=root.findViewById(R.id.card_map);
        cardrequestId=root.findViewById(R.id.cardrequestId);

        linearRequestId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), HomeDetailsActivity.class);
                startActivity(intent);

            }
        });


        // getAddress(Double.parseDouble(productlat),Double.parseDouble(productlon));

        tab1=root.findViewById(R.id.tab_txt1);
        tab2=root.findViewById(R.id.tab_txt2);
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tab1.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_bg));
                tab2.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_whitebg));
                tab1.setTextColor(Color.parseColor("#ffffff"));
                tab2.setTextColor(Color.parseColor("#000000"));
                card_map.setVisibility(View.GONE);
                cardrequestId.setVisibility(View.VISIBLE);
            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tab1.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_whitebg));
                tab2.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_bg));
                tab1.setTextColor(Color.parseColor("#000000"));
                tab2.setTextColor(Color.parseColor("#ffffff"));
                card_map.setVisibility(View.VISIBLE);
                cardrequestId.setVisibility(View.GONE);



            }
        });

        return root;
    }



    private void updateMarkerWithCircle(LatLng position) {
        mCircle.setCenter(position);
        mMarker.setPosition(position);
    }

    private void drawMarkerWithCircle(LatLng position){
        double radiusInMeters = 100;
        int strokeColor = 0xffff0000; //red outline
        int shadeColor = 0x44ff0000; //opaque red fill

        CircleOptions circleOptions = new CircleOptions().center(position).radius(radiusInMeters).fillColor(shadeColor).strokeColor(strokeColor).strokeWidth(2);
        mCircle = mMap.addCircle(circleOptions);
        int height = 16;
        int width = 16;
        BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.task);
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);

        MarkerOptions markerOptions = new MarkerOptions().position(position).
                icon(BitmapDescriptorFactory.fromBitmap((smallMarker)));// .icon(bitmapDescriptorFromVector(this, R.drawable.ic_circle));


        //5256 2208 0046 7254
        // mMarker = mMap.addMarker(markerOptions);

    }

  /*  private BitmapDescriptor bitmapDescriptorFromVector(Context context, @DrawableRes int vectorDrawableResourceId) {
        Drawable background = ContextCompat.getDrawable(context, R.drawable.ic_circle);
        background.setBounds(0, 0, background.getIntrinsicWidth(), background.getIntrinsicHeight());
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorDrawableResourceId);
        vectorDrawable.setBounds(40, 20, vectorDrawable.getIntrinsicWidth() + 40, vectorDrawable.getIntrinsicHeight() + 20);
        Bitmap bitmap = Bitmap.createBitmap(background.getIntrinsicWidth(), background.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        background.draw(canvas);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }*/


    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng Point = new LatLng(Double.parseDouble(productlat), Double.parseDouble(productlon));
        // mMap.addMarker(new MarkerOptions().position(Point).title("Product"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(Point));
        if(mCircle == null || mMarker == null){
            drawMarkerWithCircle(Point);
        }else{
            updateMarkerWithCircle(Point);
        }
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Point, 16));


/*        CircleOptions circleOptions = new CircleOptions()
                .center(Point)   //set center
                .radius(500)   //set radius in meters
                .fillColor(Color.TRANSPARENT)  //default
                .strokeColor(Color.BLUE)
                .strokeWidth(5);

        mCircle  = mMap.addCircle(circleOptions);*/

      /*  mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                if(mCircle == null || mMarker == null){
                    drawMarkerWithCircle(Point);
                }else{
                    updateMarkerWithCircle(Point);
                }
            }
        });
*/

    }





/*
    private String getAddress(double latitude, double longitude) {
        StringBuilder result = new StringBuilder();
        try {
            Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                String addressStreet = addresses.get(0).getAddressLine(0);
                String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String postalCode = addresses.get(0).getPostalCode();
                String knownName = addresses.get(0).getFeatureName();

                // result.append(address.getLocality()).append("\n");
                // result.append(address.getCountryName());
                Log.e("Address===",addressStreet + " " + city + " " + country);
                Log.e("addressStreet===",addressStreet);
//                Log.e("city===", city);
                Log.e("country===",country);

                // tvServiceLocation.setText(addressStreet + " " + city + " " + country);
               // details_locationId.setText(city+" "+country);
            }
        } catch (IOException e) {
            Log.e("tag", e.getMessage());
        }

        return result.toString();
    }*/
}