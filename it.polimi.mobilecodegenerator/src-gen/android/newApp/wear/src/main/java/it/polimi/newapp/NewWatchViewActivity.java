package it.polimi.newapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;

public class NewWatchViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newwatchview);

		final WatchViewStub stub = (WatchViewStub) this.findViewById(R.id.watch_view_stub);
		stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
			@Override
			public void onLayoutInflated(WatchViewStub stub) {

			}

		});

	}

}
