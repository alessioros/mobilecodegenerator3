package it.polimi.swifttranslation;

import android.os.Bundle;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.CardView;
import android.util.Log;

import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FifthViewActivity extends AppCompatActivity {

	private CardView smiiaCard;
	private ImageView smiiaCardImageView;
	private Button smiiaCardButton1;
	private Button smiiaCardButton2;
	private Button smiiaCardButton3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fifthview);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.fifthview_toolbar);
		setSupportActionBar(toolbar);

		this.smiiaCard = (CardView) this.findViewById(R.id.smiiaCard);
		this.smiiaCardImageView = (ImageView) this.findViewById(R.id.smiiaCardImageView);
		this.setUpCardView(R.id.smiiaCard, R.id.smiiaCardImageView, R.id.smiiaCardTitle, R.id.smiiaCardSubtitle,
				R.id.smiiaCardButtons);

		this.smiiaCardButton1 = (Button) this.findViewById(R.id.smiiaCardButton1);
		this.smiiaCardButton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("Button " + v.getId(), "Clicked");
			}
		});

		this.smiiaCardButton2 = (Button) this.findViewById(R.id.smiiaCardButton2);
		this.smiiaCardButton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("Button " + v.getId(), "Clicked");
			}
		});

		this.smiiaCardButton3 = (Button) this.findViewById(R.id.smiiaCardButton3);
		this.smiiaCardButton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("Button " + v.getId(), "Clicked");
			}
		});

	}

	private void setUpCardView(int cardId, int cardImageId, int cardTitleId, int cardSubtitleId, int cardButtonsId) {

		CardView c = (CardView) this.findViewById(cardId);
		ImageView iv = (ImageView) this.findViewById(cardImageId);

		ViewGroup.LayoutParams cardLp = c.getLayoutParams();
		ViewGroup.LayoutParams cardImageViewLp = iv.getLayoutParams();

		//Card side margin
		float screenWidthPx = getResources().getDisplayMetrics().widthPixels;
		float cardViewLMarginPx = ((RelativeLayout.LayoutParams) cardLp).leftMargin;
		float cardViewRMarginPx = ((RelativeLayout.LayoutParams) cardLp).rightMargin;
		float cardWidthPx = screenWidthPx - cardViewLMarginPx - cardViewRMarginPx;

		//Card image height (dynamic)
		float aspectRatio = (float) 16 / 9;
		float cardImageHeightPx = cardWidthPx / aspectRatio;

		//Card extra height (fixed)
		float titleHeightPx = this.cardTextHeight(cardTitleId);
		float subtitleHeightPx = this.cardTextHeight(cardSubtitleId);
		float cardButtonsHeightPx = this.cardButtonsHeight(cardButtonsId);
		float extraHeightPx = titleHeightPx + subtitleHeightPx + cardButtonsHeightPx;

		//Card height (dynamic)
		float cardHeightPx = cardImageHeightPx + extraHeightPx;

		cardLp.height = (int) cardHeightPx;
		cardImageViewLp.height = (int) cardImageHeightPx;

		c.setLayoutParams(cardLp);
		iv.setLayoutParams(cardImageViewLp);

	}

	private float cardTextHeight(int id) {
		TextView title = (TextView) this.findViewById(id);
		ViewGroup.LayoutParams titleLp = title.getLayoutParams();
		float titleTopMarginPx = ((LinearLayout.LayoutParams) titleLp).topMargin;
		float titleBottomMarginPx = ((LinearLayout.LayoutParams) titleLp).bottomMargin;
		float titleSizePx = title.getTextSize();
		return titleTopMarginPx + titleBottomMarginPx + titleSizePx;
	}

	private float cardButtonsHeight(int id) {
		LinearLayout cardButtons = (LinearLayout) this.findViewById(id);
		ViewGroup.LayoutParams cardButtonsLp = cardButtons.getLayoutParams();
		float cardButtonsTopMarginPx = ((LinearLayout.LayoutParams) cardButtonsLp).topMargin;
		float cardButtonsBottomMarginPx = ((LinearLayout.LayoutParams) cardButtonsLp).bottomMargin;
		float cardButtonsSizePx = ((LinearLayout.LayoutParams) cardButtonsLp).height;
		return cardButtonsTopMarginPx + 2 * cardButtonsBottomMarginPx + cardButtonsSizePx;
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
