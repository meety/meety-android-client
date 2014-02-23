package com.example.meety_android_client;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/**
 * 
 * @author Tales Tenorio de Souza Pimentel - tales.tsp@gmail.com
 *
 */
public class MeetySessionActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meety_session);
		startMap();

	}

	private void startMap() {

		GoogleMap gMap;
		gMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.id_googlemap)).getMap();
		gMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		CameraPosition cameraPosition = new CameraPosition.Builder()
		.target(new LatLng(-7.2290, -35.9))
	    .zoom(8)                   
	    .bearing(0)                
	    .tilt(30)                   
	    .build(); 
		gMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
		gMap.setBuildingsEnabled(true);


	}

}
