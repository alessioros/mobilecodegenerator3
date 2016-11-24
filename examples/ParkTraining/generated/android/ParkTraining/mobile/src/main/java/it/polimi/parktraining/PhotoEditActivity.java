package it.polimi.parktraining;

import android.os.Bundle;
import android.content.DialogInterface;

import android.content.Intent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;

import android.widget.Button;
import android.widget.ImageView;

public class PhotoEditActivity extends AppCompatActivity {

	private Button deletePhotoButton;

	private ImageView mImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photoedit);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.photoedit_toolbar);
		setSupportActionBar(toolbar);

		this.showdeletePhotoDialog();

		this.deletePhotoButton = (Button) this
				.findViewById(R.id.deletePhotoButton);
		this.deletePhotoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//TODO implement the action
			}
		});

		this.mImageView = (ImageView) this.findViewById(R.id.mImageView);

	}

	private void showdeletePhotoDialog() {
		AlertDialog.Builder deletePhotoDialogBuilder = new AlertDialog.Builder(
				this);
		deletePhotoDialogBuilder.setTitle("Delete Photo");
		deletePhotoDialogBuilder.setMessage("Are you sure?");
		deletePhotoDialogBuilder.setPositiveButton("Ok",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//TODO implement the positive action
					}
				});
		deletePhotoDialogBuilder.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//TODO implement the negative action
					}
				});
		AlertDialog deletePhotoDialog = deletePhotoDialogBuilder.create();
		deletePhotoDialog.show();
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
