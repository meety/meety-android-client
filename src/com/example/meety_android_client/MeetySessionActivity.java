package com.example.meety_android_client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * 
 * @author Tales Tenorio de Souza Pimentel - tales.tsp@gmail.com
 * 
 */
public class MeetySessionActivity extends Activity {

	private GoogleMap gMap;
	private CameraPosition cameraPosition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meety_session);
		
		try {
		startMap();
		} catch (Exception e) {
			System.out.println("********EXCEPTION*********");
			System.out.println(e.toString());
			System.out.println("========EXCEPTION========");
			TextView logo_meety = (TextView) findViewById(R.id.logo_MS);
			logo_meety.setText(e.getMessage());
			logo_meety.setTextColor(this.getResources().getColor(R.color.red_deny_login));
		}
		
		
		try {
		LocationManager locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);
		LocationListener locationListener = new LocationListener() {

			public void onLocationChanged(Location location) {
				// Called when a new location is found by the network location
				// provider.

				makeUseOfNewLocation(location);
			}

			public void onStatusChanged(String provider, int status,
					Bundle extras) {
			}

			public void onProviderEnabled(String provider) {
			}

			public void onProviderDisabled(String provider) {
			}
		};

		
			String locationProvider = LocationManager.GPS_PROVIDER;
			locationManager.requestLocationUpdates(locationProvider, 0, 0,
					locationListener);
		} catch (Exception e) {
			System.out.println("********EXCEPTION*********");
			System.out.println(e.getMessage());
			System.out.println("========EXCEPTION========");
			TextView logo_meety = (TextView) findViewById(R.id.logo_MS);
			logo_meety.setText(e.getMessage());
			logo_meety.setTextColor(this.getResources().getColor(R.color.white));

		}

	}

	private void makeUseOfNewLocation(Location location) {
			
		LatLng latLng = new LatLng(location.getLatitude(), location
				.getLongitude());
		
		cameraPosition = new CameraPosition.Builder()
				.target(latLng).zoom(17).bearing(0).tilt(30).build();

		gMap.clear();
		gMap.animateCamera(CameraUpdateFactory
				.newCameraPosition(cameraPosition));
		gMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.id_googlemap)).getMap();
		gMap.addMarker(new MarkerOptions()
		        .position(latLng)
		        .icon(BitmapDescriptorFactory.fromResource(R.drawable.redp)));

		
		
	}

	private void startMap() {

		gMap = ((MapFragment) getFragmentManager().findFragmentById(
				R.id.id_googlemap)).getMap();
		gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		gMap.setBuildingsEnabled(true);

	}
	

	@Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
        	gMap.clear();
            startActivity(new  Intent(this, LoggedInActivity.class));
            finish();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

}
