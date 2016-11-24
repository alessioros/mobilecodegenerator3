package it.polimi.swifttranslation;

import android.os.Bundle;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;

import android.view.View;

import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class FirstViewActivity extends AppCompatActivity {

	private Button bqbgtButton;

	private AppCompatEditText pdirEditText;
	private ImageView cquImageView;
	private AppCompatSeekBar eltsSlider;
	private AppCompatSpinner jlhtqSpinner;
	private SwitchCompat ukjpSwitchButton;
	private WebView audbWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_firstview);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.firstview_toolbar);
		setSupportActionBar(toolbar);

		this.bqbgtButton = (Button) this.findViewById(R.id.bqbgtButton);
		this.bqbgtButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FirstViewActivity.this, SecondViewActivity.class);
				//use putExtra method of Intent here for passing additional information to SecondViewActivity
				startActivity(intent);
			}
		});

		this.pdirEditText = (AppCompatEditText) this.findViewById(R.id.pdirEditText);
		this.pdirEditText.setText("gygyg");

		this.cquImageView = (ImageView) this.findViewById(R.id.cquImageView);

		this.eltsSlider = (AppCompatSeekBar) this.findViewById(R.id.eltsSliderBar);
		this.eltsSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				Log.i("onProgressChanged", "eltsSlider progress : " + progress);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				//TODO implement the action
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				//TODO implement the action
			}
		});

		this.jlhtqSpinner = (AppCompatSpinner) this.findViewById(R.id.jlhtqSpinner);
		//Change these values to choose options
		final String[] jlhtqSpinnerContents = {"Option A", "Option B", "Option C"};
		ArrayAdapter<String> jlhtqSpinnerAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, jlhtqSpinnerContents);
		this.jlhtqSpinner.setAdapter(jlhtqSpinnerAdapter);
		this.jlhtqSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Log.i("onItemSelected", "jlhtqSpinner : " + jlhtqSpinnerContents[position]);
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				//TODO implement the action
			}
		});

		this.ukjpSwitchButton = (SwitchCompat) this.findViewById(R.id.ukjpSwitchButton);
		this.ukjpSwitchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Log.i("onCheckedChanged", "ukjpSwitchButton is checked : " + isChecked);
			}
		});

		this.audbWebView = (WebView) this.findViewById(R.id.audbWebView);
		WebSettings audbWebViewSettings = audbWebView.getSettings();
		audbWebViewSettings.setDefaultTextEncodingName("utf-8");
		String audbWebViewHTMLContent = Utils
				.fromInputStreamToString(this.getResources().openRawResource(R.raw.provah));
		this.audbWebView.loadDataWithBaseURL("file:///android_asset/", audbWebViewHTMLContent, "text/html", "utf-8",
				null);
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
