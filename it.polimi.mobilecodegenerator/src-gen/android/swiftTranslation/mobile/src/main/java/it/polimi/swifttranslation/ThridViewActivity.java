package it.polimi.swifttranslation;

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
import android.graphics.Bitmap;
import android.Manifest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;

import android.view.View;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class ThridViewActivity extends AppCompatActivity implements OnItemClickListener {

	private FloatingActionButton vaiadAudioPlayerPlayButton;
	private FloatingActionButton vaiadAudioPlayerPauseButton;
	private FloatingActionButton vaiadAudioPlayerStopButton;
	private MediaPlayer vaiadAudioPlayer;
	private Button recordButton;
	private MediaRecorder audioRecorder;
	private String recordedAudioPath;
	private boolean isRecording = false;
	private static final int REQUEST_CODE_RECORD_AUDIO = 400;

	private Button photocameraButton;
	private static final int IMAGE_CAPTURE_ACTIVITY_REQUEST_CODE = 100;

	private ImageButton videocameraButton;
	private Uri videoFileUri;
	private static final int VIDEO_CAPTURE_ACTIVITY_REQUEST_CODE = 200;
	private static final int REQUEST_CODE_READ_EXTERNAL_STORAGE = 300;
	private ListView tjuekListView;
	private MyListAdapter tjuekListViewAdapter;

	private Integer[] tjuekListViewImages;

	private String[] tjuekListViewSubcontents;
	private Integer[] tjuekListViewIcons;
	private String[] tjuekListViewContents;
	private VideoView emlVideoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thridview);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.thridview_toolbar);
		setSupportActionBar(toolbar);

		this.photocameraButton = (Button) this.findViewById(R.id.sptPhotocameraController);
		this.photocameraButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(takePictureIntent, IMAGE_CAPTURE_ACTIVITY_REQUEST_CODE);
			}
		});

		//Request permissions to save the video at runtime ONLY for API >= 23
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
					REQUEST_CODE_READ_EXTERNAL_STORAGE);
		} else {
			this.setUpCameraRecorder();
		}
		//Request permissions to record audio at runtime ONLY for API >= 23
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_CODE_RECORD_AUDIO);
		} else {
			this.setUpAudioRecorder();
		}

		//Change this to set a specific image id for each row
		this.tjuekListViewImages = new Integer[]{R.drawable.ic_stars_white, R.drawable.ic_stars_white,
				R.drawable.ic_stars_white,};

		//Change this to set a specific icon id for each row
		this.tjuekListViewIcons = new Integer[]{R.drawable.ic_chevron_right_black_36dp,
				R.drawable.ic_chevron_right_black_36dp, R.drawable.ic_chevron_right_black_36dp,};
		this.tjuekListViewSubcontents = new String[]{"Content", "Content", "Content",};
		this.tjuekListViewContents = new String[]{"newListItem", "newListItem", "newListItem",};

		this.tjuekListViewAdapter = new MyListAdapter(this, R.layout.tjueklistview_detailed_layout,
				this.tjuekListViewContents, this.tjuekListViewSubcontents, this.tjuekListViewImages,
				this.tjuekListViewIcons);
		this.tjuekListView = (ListView) this.findViewById(R.id.tjuekListView);
		this.tjuekListView.setAdapter(this.tjuekListViewAdapter);

		this.emlVideoView = (VideoView) this.findViewById(R.id.emlVideoView);
		Uri emlVideoViewVideoFileUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.provamp4);
		this.emlVideoView.setVideoURI(emlVideoViewVideoFileUri);
		this.emlVideoView.setMediaController(new MediaController(this));
		this.emlVideoView.requestFocus();
		//this.emlVideoView.start();

	}

	@Override
	public void onItemClick(AdapterView<?> l, View v, int position, long id) {
	}

	private void setUpAudioRecorder() {
		this.recordButton = (Button) this.findViewById(R.id.rAudioRecorder);
		this.recordButton.setText("Rec");
		this.recordButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!isRecording) {
					startRecording();
				} else {
					stopRecording();
				}
				isRecording = !isRecording;
			}
		});
	}

private void startRecording() {
	//Stop audioplayer eventually
	try {
		this..pause();
		this..seekTo(0);
	} catch (Exception e) {
		e.printStackTrace();
	}

	String audiosPath = getFilesDir().getAbsolutePath() + "/audios";
	File audiosDirectory = new File(audiosPath);
	audiosDirectory.mkdir();
	String filename = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".mp3";
	String localAudioPath = audiosPath + "/" + filename;
	this.recordedAudioPath = localAudioPath;

	this.audioRecorder = new MediaRecorder();
	this.audioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
	this.audioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
	this.audioRecorder.setOutputFile(this.recordedAudioPath);
	this.audioRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
	try {
		this.audioRecorder.prepare();
		this.audioRecorder.start();
	} catch (IOException e) {
		e.printStackTrace();
	}
	this.recordButton.setText("Stop");
}

private void stopRecording() {
	this.audioRecorder.stop();
	this.audioRecorder.release();
	this.audioRecorder = null;
	try {
		this. = new MediaPlayer();
		this..setDataSource(new FileInputStream(this.recordedAudioPath).getFD());
		this..prepare();
	} catch (Exception e) {
		e.printStackTrace();
	}
	this.recordButton.setText("Rec");
}

	private void setUpCameraRecorder() {
		this.videocameraButton = (ImageButton) this.findViewById(R.id.oseetVideocameraController);
		this.videocameraButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
				startActivityForResult(takeVideoIntent, VIDEO_CAPTURE_ACTIVITY_REQUEST_CODE);
			}
		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			if (requestCode == IMAGE_CAPTURE_ACTIVITY_REQUEST_CODE) {
				Bitmap photo = (Bitmap) data.getExtras().get("data");
				String localImageFileUri = this.copyImageInImagesFolder(photo);
				//TODO use the photo
				//this.mImageView.setImageBitmap(photo);
			}
			if (requestCode == VIDEO_CAPTURE_ACTIVITY_REQUEST_CODE) {
				this.videoFileUri = data.getData();
				String localVideoFileUri = this.copyVideoInVideosFolder(this.videoFileUri);
			}
		} else if (resultCode == Activity.RESULT_CANCELED) {
			//TODO implement the cancel action
		}
	}

	private String copyImageInImagesFolder(Bitmap image) {
		String localImagePath = null;
		try {
			String imagesPath = getFilesDir().getAbsolutePath() + "/images";
			File imagesDirectory = new File(imagesPath);
			imagesDirectory.mkdir();
			String filename = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".png";
			localImagePath = imagesPath + "/" + filename;
			File localImageFile = new File(localImagePath);
			FileOutputStream outputStream = new FileOutputStream(localImageFile);
			image.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return localImagePath;
	}

	private String copyVideoInVideosFolder(Uri sourceVideoFileUri) {
		String localVideoPath = null;
		try {
			AssetFileDescriptor videoAsset = getContentResolver().openAssetFileDescriptor(sourceVideoFileUri, "r");
			FileInputStream fis = videoAsset.createInputStream();
			String videosPath = getFilesDir().getAbsolutePath() + "/videos";
			File videosDirectory = new File(videosPath);
			videosDirectory.mkdir();
			String filename = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".3gp";
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
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		switch (requestCode) {
			case REQUEST_CODE_READ_EXTERNAL_STORAGE : {
				if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					this.setUpCameraRecorder();
				} else {
					//TODO No permissions
				}
				return;
			}
			case REQUEST_CODE_RECORD_AUDIO : {
				if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					this.setUpAudioRecorder();
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
		try {
			this.vaiadAudioPlayer = new MediaPlayer();
			this.vaiadAudioPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			this.vaiadAudioPlayer.setDataSource("http://www.provam.mp3");
			this.vaiadAudioPlayer.prepare();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.vaiadAudioPlayerPlayButton = (FloatingActionButton) this.findViewById(R.id.vaiadAudioPlayer_playButton);
		this.vaiadAudioPlayerPlayButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				vaiadAudioPlayer.start();
			}
		});

		this.vaiadAudioPlayerPauseButton = (FloatingActionButton) this.findViewById(R.id.vaiadAudioPlayer_pauseButton);
		this.vaiadAudioPlayerPauseButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				vaiadAudioPlayer.pause();
			}
		});

		this.vaiadAudioPlayerStopButton = (FloatingActionButton) this.findViewById(R.id.vaiadAudioPlayer_stopButton);
		this.vaiadAudioPlayerStopButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				vaiadAudioPlayer.pause();
				vaiadAudioPlayer.seekTo(0);
			}
		});
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (this.audioRecorder != null) {
			this.audioRecorder.release();
			this.audioRecorder = null;
		}
		if (this.vaiadAudioPlayer != null) {
			this.vaiadAudioPlayer.release();
			this.vaiadAudioPlayer = null;
		}
	}

	@Override
	protected void onStop() {
		super.onStop();
	}
}
