package com.xoi.sos;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private Circle mCircle;
    private Marker mMarker;
    private GoogleMap mGoogleMap;
    LatLng currentlocation;
    Button btnsend;
    private final static int PLACE_PICKER_REQUEST = 999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        btnsend=(Button) findViewById(R.id.btnSend);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
//        mGoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//
//            @Override
//            public void onMapClick(LatLng point) {
//                Toast.makeText(getApplicationContext(), point.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
        LatLng sydney = new LatLng(13.2560426, 74.7834597);
        LatLng sydne2 = new LatLng(12.2560426, 74.7834597);
        float zoomLevel = 8.0f; //This goes up to 21
//        mGoogleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mGoogleMap.addMarker(new MarkerOptions().position(sydne2).title("Marker in new"));
   mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,zoomLevel));
//        drawMarkerWithCircle(sydney);
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener()
        {
            @Override
            public void onMapClick(LatLng latLng)
            {
                mGoogleMap.clear();
                mGoogleMap.addMarker(new MarkerOptions().position(latLng).title("I am here").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                currentlocation = latLng;
//                Toast.makeText(getApplicationContext(), currentlocation.toString(), Toast.LENGTH_SHORT).show();
                btnsend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MapsActivity.this, finalActivity.class);
                        i.putExtra("latlang",currentlocation.toString());
                        startActivity(i);
                    }
                });
            }
        });
    }
    private void updateMarkerWithCircle(LatLng position) {
        mCircle.setCenter(position);
        mMarker.setPosition(position);
    }

    private void drawMarkerWithCircle(LatLng position){
        double radiusInMeters = 100.0;
        int strokeColor = 0xffff0000; //red outline
        int shadeColor = 0x44ff0000; //opaque red fill

        CircleOptions circleOptions = new CircleOptions().center(position).radius(radiusInMeters).fillColor(shadeColor).strokeColor(strokeColor).strokeWidth(8);
        mCircle = mGoogleMap.addCircle(circleOptions);

        MarkerOptions markerOptions = new MarkerOptions().position(position);
        mMarker = mGoogleMap.addMarker(markerOptions);
    }

}
