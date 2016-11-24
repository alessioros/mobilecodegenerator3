package it.polimi.parktraining;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.SeekBar;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class FirstActivity extends Activity {

	private Button firstNextButton;
	private SeekBar repsSlider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);

		final WatchViewStub stub = (WatchViewStub) this
				.findViewById(R.id.watch_view_stub);
		stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
			@Override
			public void onLayoutInflated(WatchViewStub stub) {

				firstNextButton = (Button) stub
						.findViewById(R.id.firstNextButton);
				firstNextButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(FirstActivity.this,
								SecondActivity.class);
						//use putExtra method of Intent here for passing additional information to SecondActivity
						startActivity(intent);
					}
				});
				repsSlider = (SeekBar) stub.findViewById(R.id.repsSlider);
				repsSlider
						.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
							@Override
							public void onProgressChanged(SeekBar seekBar,
									int progress, boolean fromUser) {
								Log.i("onProgressChanged",
										"repsSlider progress : " + progress);
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

			}

		});

	}

}
