package it.polimi.swifttranslation;

import android.os.Bundle;

import android.content.Intent;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;

import android.view.View;

import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class SecondViewActivity extends AppCompatActivity {

	private FloatingActionButton pnesAudioPlayerPlayButton;
	private FloatingActionButton pnesAudioPlayerPauseButton;
	private FloatingActionButton pnesAudioPlayerStopButton;
	private MediaPlayer pnesAudioPlayer;

	private ImageView rrrImageView;
	private ImageView lkihpImageView;
	private VideoView hbgvaVideoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secondview);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.secondview_toolbar);
		setSupportActionBar(toolbar);

		this.rrrImageView = (ImageView) this.findViewById(R.id.rrrImageView);

		this.lkihpImageView = (ImageView) this.findViewById(R.id.lkihpImageView);
		this.lkihpImageView.setTag("http://www.prova.it/prova.jpg");
		//download the bitmap and set the ImageView
		new ImageDownloadingTask().execute(this.lkihpImageView);

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
