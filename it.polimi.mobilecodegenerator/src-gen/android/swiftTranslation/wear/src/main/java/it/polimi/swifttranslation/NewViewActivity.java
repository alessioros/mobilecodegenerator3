package it.polimi.swifttranslation;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class NewViewActivity extends Activity {

	private Button qpikWatchButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newview);

		final WatchViewStub stub = (WatchViewStub) this.findViewById(R.id.watch_view_stub);
		stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
			@Override
			public void onLayoutInflated(WatchViewStub stub) {

				qpikWatchButton = (Button) stub.findViewById(R.id.qpikWatchButton);
				qpikWatchButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(NewViewActivity.this, NewView2Activity.class);
						//use putExtra method of Intent here for passing additional information to NewView2Activity
						startActivity(intent);
					}
				});

			}

		});

	}

}
