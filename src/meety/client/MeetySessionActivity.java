package meety.client;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MeetySessionActivity extends Activity {

	private GoogleMap gMap;
	private CameraPosition cameraPosition;
	private Marker currentPositionMarker = null;
	private Marker friendPositionMarker = null;
	private Location friendLocation = null;

	LatLng friendPos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.meety_session);
		startMap();

		LocationManager locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);
		String locationProvider = LocationManager.GPS_PROVIDER;

		LocationListener locationListener = new LocationListener() {

			public void onLocationChanged(Location myLocation) {
				// Called when a new location is found by the network location
				// provider.

				makeUseOfNewLocation(myLocation);
			}

			public void onStatusChanged(String provider, int status,
					Bundle extras) {
			}

			public void onProviderEnabled(String provider) {
			}

			public void onProviderDisabled(String provider) {
			}
		};
		locationManager.requestLocationUpdates(locationProvider, 0, 0,
				locationListener);

	}

	private void makeUseOfNewLocation(Location location) {

		gMap.clear();

		LatLng newpos = new LatLng(location.getLatitude(),
				location.getLongitude());

		cameraPosition = new CameraPosition.Builder().target(newpos).zoom(17)
				.bearing(0).tilt(30).build();

		gMap.animateCamera(CameraUpdateFactory
				.newCameraPosition(cameraPosition));

		currentPositionMarker = gMap.addMarker(new MarkerOptions()
				.position(newpos).title("You")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.redp)));

		currentPositionMarker.setPosition(newpos);

		
		setDummyFriend(location);
		
		friendPositionMarker = gMap.addMarker(new MarkerOptions()
				.position(friendPos).title("Friend")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.bluep)));

		friendPositionMarker.setPosition(friendPos);

	}

	private LatLng setDummyFriend(Location location) {

		if (friendPos == null) {
			friendPos = new LatLng(location.getLatitude() + 0.0005,
					location.getLongitude() + 0.0004);
		}
		return friendPos;
	}

	private void startMap() {

		gMap = ((MapFragment) getFragmentManager().findFragmentById(
				R.id.id_googlemap)).getMap();
		gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		gMap.setBuildingsEnabled(true);

	}

	private Location setFriendLocation(Location location) {

		Location friendLocation = new Location(location);
		friendLocation.setLatitude(location.getLatitude() + 0.0001);
		friendLocation.setLongitude(location.getLongitude() + 0.0001);

		return friendLocation;

	}

}