package it.polimi.parktraining;

import android.os.Bundle;
import android.content.DialogInterface;

import android.content.Intent;

import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;

import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoEditActivity extends AppCompatActivity {

	private Button deleteVideoButton;

	private VideoView mVideoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_videoedit);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.videoedit_toolbar);
		setSupportActionBar(toolbar);

		this.showdeleteVideoDialog();

		this.deleteVideoButton = (Button) this
				.findViewById(R.id.deleteVideoButton);
		this.deleteVideoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//TODO implement the action
			}
		});

		this.mVideoView = (VideoView) this.findViewById(R.id.mVideoView);
		/*
		 //TODO insert local file name
		 Uri mVideoViewVideoFileUri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.filename);
		 this.mVideoView.setVideoURI(mVideoViewVideoFileUri);
		 this.mVideoView.setMediaController(new MediaController(this));
		 this.mVideoView.requestFocus();
		 //this.mVideoView.start();
		 */

	}

	private void showdeleteVideoDialog() {
		AlertDialog.Builder deleteVideoDialogBuilder = new AlertDialog.Builder(
				this);
		deleteVideoDialogBuilder.setTitle("Delete Video");
		deleteVideoDialogBuilder.setMessage("Are you sure?");
		deleteVideoDialogBuilder.setPositiveButton("Ok",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//TODO implement the positive action
					}
				});
		deleteVideoDialogBuilder.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//TODO implement the negative action
					}
				});
		AlertDialog deleteVideoDialog = deleteVideoDialogBuilder.create();
		deleteVideoDialog.show();
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
