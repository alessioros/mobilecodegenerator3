package it.polimi.parktraining;

import android.os.Bundle;
import android.content.DialogInterface;

import android.content.Intent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;

import android.widget.Button;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationEditActivity extends AppCompatActivity
		implements
			OnMapReadyCallback {

	private Button deleteLocationButton;

	private MapView mMapView;
	private GoogleMap mMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_locationedit);
		Toolbar toolbar = (Toolbar) this
				.findViewById(R.id.locationedit_toolbar);
		setSupportActionBar(toolbar);

		this.showdeleteLocationDialog();

		this.deleteLocationButton = (Button) this
				.findViewById(R.id.deleteLocationButton);
		this.deleteLocationButton
				.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//TODO implement the action
					}
				});

		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.mMap);
		mapFragment.getMapAsync(this);

	}

	private void showdeleteLocationDialog() {
		AlertDialog.Builder deleteLocationDialogBuilder = new AlertDialog.Builder(
				this);
		deleteLocationDialogBuilder.setTitle("Delete Location");
		deleteLocationDialogBuilder.setMessage("Are you sure?");
		deleteLocationDialogBuilder.setPositiveButton("Ok",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//TODO implement the positive action
					}
				});
		deleteLocationDialogBuilder.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//TODO implement the negative action
					}
				});
		AlertDialog deleteLocationDialog = deleteLocationDialogBuilder.create();
		deleteLocationDialog.show();
	}

	@Override
	public void onMapReady(GoogleMap googleMap) {
		this.mMap = googleMap;
		LatLng pos = new LatLng(45.478, 9.227);
		this.mMap.addMarker(new MarkerOptions().position(pos).title(
				"MARKER TITLE HERE"));
		this.mMap.moveCamera(CameraUpdateFactory.newLatLng(pos));
		this.mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 1000, null);
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
