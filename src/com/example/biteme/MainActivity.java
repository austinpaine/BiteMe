package com.example.biteme;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.biteme.R;



public class MainActivity extends ActionBarActivity {
	
	static final LatLng TUCSON = new LatLng(32.221743, -110.926479);

	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		if (savedInstanceState == null) {
//			getSupportFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		//TODO: data helper stuff
		
		if (map != null) {
			LatLng latlng = null;

//			for (int i = 0; i < addressList.size(); i++) {
//				latlng = getPatientLatLong(addressList.get(i).getAddress());
//				Log.d("latLong", latlng.toString());
//				String name = addressList.get(i).getName();
//				
//				Location patient = new Location("patGeo");
//				patient.setLatitude(latlng.latitude);
//				patient.setLongitude(latlng.longitude)	;
//				
//				Location dr = new Location("drGeo");
//				dr.setLatitude(DRMURPHY.latitude);
//				dr.setLongitude(DRMURPHY.longitude);
//			
//				double distance = patient.distanceTo(dr);
//				String dist = String.format("%2f",distance/1000);
//			
//				if((distance/1000) < 5)
//					map.addMarker(new MarkerOptions().position(latlng).title(name).snippet(dist));
//				else
//					map.addMarker(new MarkerOptions().position(latlng).title(name).snippet(dist).icon(BitmapDescriptorFactory
//				              .fromResource(R.drawable.ic_launcher)));
//			}

			// including some animation
			// Move the camera instantly to Tucson with a zoom of 15.
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(TUCSON, 15));

			// Zoom in, animating the camera.
			map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
}
