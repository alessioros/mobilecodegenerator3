package it.polimi.parktraining;

import android.os.Bundle;
import android.content.DialogInterface;

import android.content.Intent;

import android.support.v7.app.AlertDialog;
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

public class ExerciseEditActivity extends AppCompatActivity {

	private Button editSaveButton;
	private Button editDeleteButton;

	private AppCompatEditText editNameEditText;
	private AppCompatSpinner editRepsSpinner;
	private AppCompatSpinner editSetsSpinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exerciseedit);
		Toolbar toolbar = (Toolbar) this
				.findViewById(R.id.exerciseedit_toolbar);
		setSupportActionBar(toolbar);

		this.showdeleteExerciseDialog();

		this.editSaveButton = (Button) this.findViewById(R.id.editSaveButton);
		this.editSaveButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//TODO implement the action
			}
		});
		this.editDeleteButton = (Button) this
				.findViewById(R.id.editDeleteButton);
		this.editDeleteButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//TODO implement the action
			}
		});

		this.editNameEditText = (AppCompatEditText) this
				.findViewById(R.id.editNameEditText);
		this.editNameEditText.setText("");

		this.editRepsSpinner = (AppCompatSpinner) this
				.findViewById(R.id.editRepsSpinner);
		//Change these values to choose options
		final String[] editRepsSpinnerContents = {"Option A", "Option B",
				"Option C"};
		ArrayAdapter<String> editRepsSpinnerAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_dropdown_item,
				editRepsSpinnerContents);
		this.editRepsSpinner.setAdapter(editRepsSpinnerAdapter);
		this.editRepsSpinner
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						Log.i("onItemSelected", "editRepsSpinner : "
								+ editRepsSpinnerContents[position]);
					}
					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						//TODO implement the action
					}
				});
		this.editSetsSpinner = (AppCompatSpinner) this
				.findViewById(R.id.editSetsSpinner);
		//Change these values to choose options
		final String[] editSetsSpinnerContents = {"Option A", "Option B",
				"Option C"};
		ArrayAdapter<String> editSetsSpinnerAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_dropdown_item,
				editSetsSpinnerContents);
		this.editSetsSpinner.setAdapter(editSetsSpinnerAdapter);
		this.editSetsSpinner
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						Log.i("onItemSelected", "editSetsSpinner : "
								+ editSetsSpinnerContents[position]);
					}
					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						//TODO implement the action
					}
				});

	}

	private void showdeleteExerciseDialog() {
		AlertDialog.Builder deleteExerciseDialogBuilder = new AlertDialog.Builder(
				this);
		deleteExerciseDialogBuilder.setTitle("Delete Exercise");
		deleteExerciseDialogBuilder.setMessage("Are you sure?");
		deleteExerciseDialogBuilder.setPositiveButton("Ok",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//TODO implement the positive action
					}
				});
		deleteExerciseDialogBuilder.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//TODO implement the negative action
					}
				});
		AlertDialog deleteExerciseDialog = deleteExerciseDialogBuilder.create();
		deleteExerciseDialog.show();
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
