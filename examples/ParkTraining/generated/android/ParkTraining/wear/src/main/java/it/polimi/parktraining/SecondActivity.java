package it.polimi.parktraining;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.SeekBar;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class SecondActivity extends Activity {

	private Button secondNextButton;
	private SeekBar setsSlider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		final WatchViewStub stub = (WatchViewStub) this
				.findViewById(R.id.watch_view_stub);
		stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
			@Override
			public void onLayoutInflated(WatchViewStub stub) {

				secondNextButton = (Button) stub
						.findViewById(R.id.secondNextButton);
				secondNextButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(SecondActivity.this,
								ThirdActivity.class);
						//use putExtra method of Intent here for passing additional information to ThirdActivity
						startActivity(intent);
					}
				});
				setsSlider = (SeekBar) stub.findViewById(R.id.setsSlider);
				setsSlider
						.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
							@Override
							public void onProgressChanged(SeekBar seekBar,
									int progress, boolean fromUser) {
								Log.i("onProgressChanged",
										"setsSlider progress : " + progress);
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
