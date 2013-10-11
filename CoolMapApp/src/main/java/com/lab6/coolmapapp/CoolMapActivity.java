package com.lab6.coolmapapp;

import android.app.FragmentTransaction;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;

public class CoolMapActivity extends Activity {
    private GoogleMap mMap;
    private MapFragment mMapFragment;
    //private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cool_map);
        GoogleMapOptions options = new GoogleMapOptions();
        options.mapType(GoogleMap.MAP_TYPE_NORMAL)
               .compassEnabled(true)
               .rotateGesturesEnabled(false)
               .tiltGesturesEnabled(false);
        mMapFragment = MapFragment.newInstance(options);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map_container, mMapFragment);
        fragmentTransaction.commit();
        //locationManager = (LocationManager)
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if(mMap == null) {
            mMap = mMapFragment.getMap();
            if(mMap != null) {
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
                mMap.setMyLocationEnabled(true);
            }
        }

    }

}
