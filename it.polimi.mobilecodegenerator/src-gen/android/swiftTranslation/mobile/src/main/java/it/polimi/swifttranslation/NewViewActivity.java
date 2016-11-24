package it.polimi.swifttranslation;

import android.os.Bundle;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import android.view.View;

import java.util.Calendar;
import java.util.Date;
import picker.ugurtekbas.com.Picker.Picker;
import picker.ugurtekbas.com.Picker.TimeChangedListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class NewViewActivity extends AppCompatActivity implements OnMapReadyCallback {

	private MapView jaboaMapView;
	private GoogleMap jaboaMap;
	private Picker usrsTimepickerPicker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newview);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.newview_toolbar);
		setSupportActionBar(toolbar);

		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.jaboaMap);
		mapFragment.getMapAsync(this);

		Calendar calendar = Calendar.getInstance();
		int hours = calendar.get(Calendar.HOUR);
		int minutes = calendar.get(Calendar.MINUTE);
		this.usrsTimepickerPicker = (Picker) this.findViewById(R.id.usrsTimepickerPicker);
		this.usrsTimepickerPicker.setTime(hours, minutes);
		this.usrsTimepickerPicker.setTimeChangedListener(new TimeChangedListener() {
			@Override
			public void timeChanged(Date date) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int hours = calendar.get(Calendar.HOUR);
				int minutes = calendar.get(Calendar.MINUTE);
				String ampm = calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM";
				Log.i("usrsTimepicker time", hours + ":" + minutes + " " + ampm);
			}
		});

	}

	@Override
	public void onMapReady(GoogleMap googleMap) {
		this.jaboaMap = googleMap;
		LatLng pos = new LatLng(45.478, 9.227);
		this.jaboaMap.addMarker(new MarkerOptions().position(pos).title("MARKER TITLE HERE"));
		this.jaboaMap.moveCamera(CameraUpdateFactory.newLatLng(pos));
		this.jaboaMap.animateCamera(CameraUpdateFactory.zoomTo(15), 1000, null);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}
}
