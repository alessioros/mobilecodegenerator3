package it.polimi.parktraining;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;

import android.content.Intent;

import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.Manifest;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoNewActivity extends AppCompatActivity {

	private Button saveVideoButton;

	private ImageButton videocameraButton;
	private Uri videoFileUri;
	private static final int VIDEO_CAPTURE_ACTIVITY_REQUEST_CODE = 200;
	private static final int REQUEST_CODE_READ_EXTERNAL_STORAGE = 300;
	private VideoView takenVideo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_videonew);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.videonew_toolbar);
		setSupportActionBar(toolbar);

		this.saveVideoButton = (Button) this.findViewById(R.id.saveVideoButton);
		this.saveVideoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//TODO implement the action
			}
		});

		//Request permissions to save the video at runtime ONLY for API >= 23
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			requestPermissions(
					new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
					REQUEST_CODE_READ_EXTERNAL_STORAGE);
		} else {
			this.setUpCameraRecorder();
		}

	}

	private void setUpCameraRecorder() {
		this.takenVideo = (VideoView) this.findViewById(R.id.takenVideo);
		this.videocameraButton = (ImageButton) this
				.findViewById(R.id.videocameraController);
		this.videocameraButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent takeVideoIntent = new Intent(
						MediaStore.ACTION_VIDEO_CAPTURE);
				startActivityForResult(takeVideoIntent,
						VIDEO_CAPTURE_ACTIVITY_REQUEST_CODE);
			}
		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			if (requestCode == VIDEO_CAPTURE_ACTIVITY_REQUEST_CODE) {
				this.videoFileUri = data.getData();
				String localVideoFileUri = this
						.copyVideoInVideosFolder(this.videoFileUri);
				this.takenVideo.setVideoURI(this.videoFileUri);
				this.takenVideo.setMediaController(new MediaController(this));
				this.takenVideo.requestFocus();
				this.takenVideo.start();
			}
		} else if (resultCode == Activity.RESULT_CANCELED) {
			//TODO implement the cancel action
		}
	}

	private String copyVideoInVideosFolder(Uri sourceVideoFileUri) {
		String localVideoPath = null;
		try {
			AssetFileDescriptor videoAsset = getContentResolver()
					.openAssetFileDescriptor(sourceVideoFileUri, "r");
			FileInputStream fis = videoAsset.createInputStream();
			String videosPath = getFilesDir().getAbsolutePath() + "/videos";
			File videosDirectory = new File(videosPath);
			videosDirectory.mkdir();
			String filename = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
					.format(new Date()) + ".3gp";
			localVideoPath = videosPath + "/" + filename;
			File localVideoFile = new File(localVideoPath);
			FileOutputStream fos = new FileOutputStream(localVideoFile);
			byte[] buf = new byte[10240];
			int len;
			while ((len = fis.read(buf)) > 0) {
				fos.write(buf, 0, len);
			}
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return localVideoPath;
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,
			String[] permissions, int[] grantResults) {
		switch (requestCode) {
			case REQUEST_CODE_READ_EXTERNAL_STORAGE : {
				if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					this.setUpCameraRecorder();
				} else {
					//TODO No permissions
				}
				return;
			}
		}
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
