package it.polimi.swifttranslation;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.SeekBar;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.speech.RecognizerIntent;
import android.support.wearable.activity.ConfirmationActivity;
import android.support.wearable.view.DelayedConfirmationView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Wearable;
import java.util.List;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class NewView2Activity extends Activity
		implements
			GoogleApiClient.ConnectionCallbacks,
			GoogleApiClient.OnConnectionFailedListener,
			DelayedConfirmationView.DelayedConfirmationListener {

	private SeekBar vtgnjWatchSlider;
	private Switch vaqWatchSwitchButton;
	private static final String MESSAGE_PATH = "/wear-app-message";
	private static final int SPEECH_REQUEST_CODE = 0;

	private Node mNode;
	private GoogleApiClient mGoogleApiClient;
	private boolean mResolvingError = false;
	private String voiceMessageContent;

	private DelayedConfirmationView.DelayedConfirmationListener mDelayedConfirmationListener;

	private Button rqmheWatchVoiceMessage;
	private RelativeLayout mDelayedViewContainer;
	private DelayedConfirmationView mDelayedView;
	private TextView mDelayedViewTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newview2);

		mDelayedConfirmationListener = this;

		mGoogleApiClient = new GoogleApiClient.Builder(this).addApi(Wearable.API).addConnectionCallbacks(this)
				.addOnConnectionFailedListener(this).build();

		final WatchViewStub stub = (WatchViewStub) this.findViewById(R.id.watch_view_stub);
		stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
			@Override
			public void onLayoutInflated(WatchViewStub stub) {

				vtgnjWatchSlider = (SeekBar) stub.findViewById(R.id.vtgnjWatchSlider);
				vtgnjWatchSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
					@Override
					public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
						Log.i("onProgressChanged", "vtgnjWatchSlider progress : " + progress);
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
				vaqWatchSwitchButton = (Switch) stub.findViewById(R.id.vaqWatchSwitchButton);
				vaqWatchSwitchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						Log.i("onCheckedChanged", "vaqWatchSwitchButton is checked : " + isChecked);
					}
				});
				mDelayedViewContainer = (RelativeLayout) stub.findViewById(R.id.delayed_confirm_container);
				mDelayedViewTextView = (TextView) stub.findViewById(R.id.delayed_confirm_text_view);
				mDelayedView = (DelayedConfirmationView) stub.findViewById(R.id.delayed_confirm);
				mDelayedView.setListener(mDelayedConfirmationListener);

				rqmheWatchVoiceMessage = (Button) stub.findViewById(R.id.rqmheWatchVoiceMessage);
				rqmheWatchVoiceMessage.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						displaySpeechRecognizer();
					}
				});

			}

		});

	}

	private void displayDelayedViewContainer() {
		mDelayedView.setTotalTimeMs(3000);
		mDelayedViewTextView.setText(voiceMessageContent);
		mDelayedViewContainer.animate().alpha(1.0f).setDuration(0).setListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				mDelayedView.start();
			}
		});

	}

	private void hideDelayedViewContainer() {
		mDelayedViewContainer.animate().translationX(-mDelayedViewContainer.getWidth()).alpha(0.0f).setDuration(500)
				.setListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						super.onAnimationEnd(animation);
						mDelayedViewContainer.animate().translationX(0);
						mDelayedView.reset();
					}
				});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
			List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			voiceMessageContent = results.get(0);
			displayDelayedViewContainer();
		}
	}

	@Override
	public void onTimerFinished(View view) {
		hideDelayedViewContainer();
		sendMessage(voiceMessageContent);
	}

	@Override
	public void onTimerSelected(View view) {
		hideDelayedViewContainer();
	}

	private void sendMessage(String message) {

		final byte[] messageData = message.getBytes();

		if (mNode != null && mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
			Wearable.MessageApi.sendMessage(mGoogleApiClient, mNode.getId(), MESSAGE_PATH, messageData)
					.setResultCallback(

							new ResultCallback<MessageApi.SendMessageResult>() {
								@Override
								public void onResult(MessageApi.SendMessageResult sendMessageResult) {

									if (!sendMessageResult.getStatus().isSuccess()) {
										displayFailureConfirmation("Message Failure");
									} else {
										displaySuccessConfirmation("Message Sent");
									}
								}
							});
		} else {
			displayFailureConfirmation("Connection Error");
		}

	}

	private void displaySuccessConfirmation(String extraMessage) {
		Intent intent = new Intent(this, ConfirmationActivity.class);
		intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, ConfirmationActivity.SUCCESS_ANIMATION);
		intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE, extraMessage);
		startActivity(intent);
	}

	private void displayFailureConfirmation(String extraMessage) {
		Intent intent = new Intent(this, ConfirmationActivity.class);
		intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, ConfirmationActivity.FAILURE_ANIMATION);
		intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE, extraMessage);
		startActivity(intent);
	}

	private void displaySpeechRecognizer() {
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		startActivityForResult(intent, SPEECH_REQUEST_CODE);
	}

	private void resolveNode() {
		Wearable.NodeApi.getConnectedNodes(mGoogleApiClient)
				.setResultCallback(new ResultCallback<NodeApi.GetConnectedNodesResult>() {
					@Override
					public void onResult(NodeApi.GetConnectedNodesResult nodes) {
						for (Node node : nodes.getNodes()) {
							mNode = node;
						}
					}
				});
	}

	@Override
	protected void onStart() {
		super.onStart();
		if (!mResolvingError) {
			mGoogleApiClient.connect();
		}
	}

	@Override
	public void onConnected(Bundle bundle) {
		resolveNode();
	}

	@Override
	public void onConnectionSuspended(int i) {
		//TODO implement the action
	}

	@Override
	public void onConnectionFailed(ConnectionResult connectionResult) {
		//TODO implement the action
	}

}
