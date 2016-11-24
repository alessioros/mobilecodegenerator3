package it.polimi.parktraining;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Bundle;
import android.app.Activity;

import android.content.Intent;

import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class PhotoNewActivity extends AppCompatActivity {

	private Button savePhotoButton;

	private ImageButton photocameraButton;
	private static final int IMAGE_CAPTURE_ACTIVITY_REQUEST_CODE = 100;

	private ImageView takenPhoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photonew);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.photonew_toolbar);
		setSupportActionBar(toolbar);

		this.savePhotoButton = (Button) this.findViewById(R.id.savePhotoButton);
		this.savePhotoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//TODO implement the action
			}
		});

		this.photocameraButton = (ImageButton) this
				.findViewById(R.id.photocameraController);
		this.photocameraButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent takePictureIntent = new Intent(
						MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(takePictureIntent,
						IMAGE_CAPTURE_ACTIVITY_REQUEST_CODE);
			}
		});

		this.takenPhoto = (ImageView) this.findViewById(R.id.takenPhoto);

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			if (requestCode == IMAGE_CAPTURE_ACTIVITY_REQUEST_CODE) {
				Bitmap photo = (Bitmap) data.getExtras().get("data");
				String localImageFileUri = this.copyImageInImagesFolder(photo);
				this.takenPhoto.setImageBitmap(photo);
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
			String filename = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
					.format(new Date()) + ".png";
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
