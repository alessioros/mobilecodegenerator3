package it.polimi.parktraining;

import android.os.Bundle;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class ExerciseNewActivity extends AppCompatActivity {

	private Button newSaveButton;

	private AppCompatEditText newNameEditText;
	private AppCompatSpinner newSetsSpinner;
	private AppCompatSpinner newRepsSpinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercisenew);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.exercisenew_toolbar);
		setSupportActionBar(toolbar);

		this.newSaveButton = (Button) this.findViewById(R.id.newSaveButton);
		this.newSaveButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//TODO implement the action
			}
		});

		this.newNameEditText = (AppCompatEditText) this
				.findViewById(R.id.newNameEditText);
		this.newNameEditText.setText("");

		this.newSetsSpinner = (AppCompatSpinner) this
				.findViewById(R.id.newSetsSpinner);
		//Change these values to choose options
		final String[] newSetsSpinnerContents = {"Option A", "Option B",
				"Option C"};
		ArrayAdapter<String> newSetsSpinnerAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_dropdown_item,
				newSetsSpinnerContents);
		this.newSetsSpinner.setAdapter(newSetsSpinnerAdapter);
		this.newSetsSpinner
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						Log.i("onItemSelected", "newSetsSpinner : "
								+ newSetsSpinnerContents[position]);
					}
					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						//TODO implement the action
					}
				});
		this.newRepsSpinner = (AppCompatSpinner) this
				.findViewById(R.id.newRepsSpinner);
		//Change these values to choose options
		final String[] newRepsSpinnerContents = {"Option A", "Option B",
				"Option C"};
		ArrayAdapter<String> newRepsSpinnerAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_dropdown_item,
				newRepsSpinnerContents);
		this.newRepsSpinner.setAdapter(newRepsSpinnerAdapter);
		this.newRepsSpinner
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						Log.i("onItemSelected", "newRepsSpinner : "
								+ newRepsSpinnerContents[position]);
					}
					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						//TODO implement the action
					}
				});

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
