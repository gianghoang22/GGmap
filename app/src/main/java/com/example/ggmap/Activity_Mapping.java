package com.example.ggmap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

    public class Activity_Mapping extends AppCompatActivity implements OnMapReadyCallback {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Set the layout file as the content view.
            setContentView(R.layout.activity_mapping);

            // Get a handle to the fragment and register the callback.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
            if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
                return;
            }
            if(checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }else{
                String permission= Manifest.permission.ACCESS_FINE_LOCATION;
                requestPermissions(new String[]{permission},10);
            }
        }

        // Get a handle to the GoogleMap object and display marker.
        @Override
        public void onMapReady(GoogleMap googleMap) {
            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(10.8418, 106.8106))
                    .title("Marker"));

            // Check if Google Play Services are available
            int resultCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
            if (resultCode == ConnectionResult.SUCCESS) {
                Log.d("Map", "Google Play Services are available.");
            } else {
                Log.d("Map", "Google Play Services are not available: " + resultCode);
            }
        }



    }