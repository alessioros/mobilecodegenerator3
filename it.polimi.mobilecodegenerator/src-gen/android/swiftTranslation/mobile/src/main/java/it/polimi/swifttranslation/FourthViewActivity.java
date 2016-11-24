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
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;

import android.view.View;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.support.annotation.NonNull;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import java.util.Calendar;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

public class FourthViewActivity extends AppCompatActivity implements OnItemClickListener {

	private FloatingActionButton imvnAudioPlayerPlayButton;
	private FloatingActionButton imvnAudioPlayerPauseButton;
	private FloatingActionButton imvnAudioPlayerStopButton;
	private MediaPlayer imvnAudioPlayer;

	private ImageButton photocameraButton;
	private static final int IMAGE_CAPTURE_ACTIVITY_REQUEST_CODE = 100;

	private Button videocameraButton;
	private Uri videoFileUri;
	private static final int VIDEO_CAPTURE_ACTIVITY_REQUEST_CODE = 200;
	private static final int REQUEST_CODE_READ_EXTERNAL_STORAGE = 300;
	private MaterialCalendarView slkqDatepickerPicker;
	private GridView stjrGridView;
	private MyGridAdapter stjrGridViewAdapter;

	private Integer[] stjrGridViewImages;

	private String[] stjrGridViewContents;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fourthview);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.fourthview_toolbar);
		setSupportActionBar(toolbar);

		this.photocameraButton = (ImageButton) this.findViewById(R.id.jadPhotocameraController);
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

		this.slkqDatepickerPicker = (MaterialCalendarView) this.findViewById(R.id.slkqDatepickerPicker);
		this.slkqDatepickerPicker.setSelectedDate(Calendar.getInstance());
		this.slkqDatepickerPicker.setOnDateChangedListener(new OnDateSelectedListener() {
			@Override
			public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date,
					boolean selected) {
				Log.i("slkqDatepicker date", date.getDay() + "/" + (date.getMonth() + 1) + "/" + date.getYear());
			}
		});

		//Change this to set a specific image id for each row
		this.stjrGridViewImages = new Integer[]{R.drawable.grid_image, R.drawable.grid_image, R.drawable.grid_image,
				R.drawable.grid_image,};

		this.stjrGridViewContents = new String[]{"newGridCell", "newGridCell", "newGridCell", "newGridCell",};

		this.stjrGridViewAdapter = new MyGridAdapter(this, this.stjrGridViewContents, this.stjrGridViewImages);
		this.stjrGridView = (GridView) this.findViewById(R.id.stjrGridView);
		this.stjrGridView.setAdapter(this.stjrGridViewAdapter);

	}

	@Override
	public void onItemClick(AdapterView<?> l, View v, int position, long id) {
	}

	private void setUpCameraRecorder() {
		this.videocameraButton = (Button) this.findViewById(R.id.lnanhVideocameraController);
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
			this.imvnAudioPlayer = new MediaPlayer();
			this.imvnAudioPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			this.imvnAudioPlayer.setDataSource(getAssets().openFd("provam.mp3").getFileDescriptor());
			this.imvnAudioPlayer.prepare();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.imvnAudioPlayerPlayButton = (FloatingActionButton) this.findViewById(R.id.imvnAudioPlayer_playButton);
		this.imvnAudioPlayerPlayButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				imvnAudioPlayer.start();
			}
		});

		this.imvnAudioPlayerPauseButton = (FloatingActionButton) this.findViewById(R.id.imvnAudioPlayer_pauseButton);
		this.imvnAudioPlayerPauseButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				imvnAudioPlayer.pause();
			}
		});

		this.imvnAudioPlayerStopButton = (FloatingActionButton) this.findViewById(R.id.imvnAudioPlayer_stopButton);
		this.imvnAudioPlayerStopButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				imvnAudioPlayer.pause();
				imvnAudioPlayer.seekTo(0);
			}
		});
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (this.imvnAudioPlayer != null) {
			this.imvnAudioPlayer.release();
			this.imvnAudioPlayer = null;
		}
	}

	@Override
	protected void onStop() {
		super.onStop();
	}
}
