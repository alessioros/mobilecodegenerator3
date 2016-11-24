package it.polimi.parktraining;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ExercisesFragment extends Fragment implements OnItemClickListener {

	private View rootView;
	private Button newExerciseButton;

	private ListView exercisesList;
	private MyListAdapter exercisesListAdapter;

	private Integer[] exercisesListImages;

	private String[] exercisesListSubcontents;
	private Integer[] exercisesListIcons;
	private String[] exercisesListContents;

	public ExercisesFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_exercises,
				container, false);
		this.rootView = rootView;

		this.newExerciseButton = (Button) rootView
				.findViewById(R.id.newExerciseButton);
		this.newExerciseButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),
						ExerciseNewActivity.class);
				//use putExtra method of Intent here for passing additional information to ExerciseNewActivity
				startActivity(intent);
			}
		});

		//Change this to set a specific image id for each row
		this.exercisesListImages = new Integer[]{R.drawable.ic_stars_white,
				R.drawable.ic_stars_white, R.drawable.ic_stars_white,
				R.drawable.ic_stars_white, R.drawable.ic_stars_white,
				R.drawable.ic_stars_white, R.drawable.ic_stars_white,
				R.drawable.ic_stars_white, R.drawable.ic_stars_white,
				R.drawable.ic_stars_white, R.drawable.ic_stars_white,
				R.drawable.ic_stars_white, R.drawable.ic_stars_white,};

		//Change this to set a specific icon id for each row
		this.exercisesListIcons = new Integer[]{
				R.drawable.ic_chevron_right_black_36dp,
				R.drawable.ic_chevron_right_black_36dp,
				R.drawable.ic_chevron_right_black_36dp,
				R.drawable.ic_chevron_right_black_36dp,
				R.drawable.ic_chevron_right_black_36dp,
				R.drawable.ic_chevron_right_black_36dp,
				R.drawable.ic_chevron_right_black_36dp,
				R.drawable.ic_chevron_right_black_36dp,
				R.drawable.ic_chevron_right_black_36dp,
				R.drawable.ic_chevron_right_black_36dp,
				R.drawable.ic_chevron_right_black_36dp,
				R.drawable.ic_chevron_right_black_36dp,
				R.drawable.ic_chevron_right_black_36dp,};
		this.exercisesListSubcontents = new String[]{"Content", "Content",
				"Content", "Content", "Content", "Content", "Content",
				"Content", "Content", "Content", "Content", "Content",
				"Content",};
		this.exercisesListContents = new String[]{"newListItem", "newListItem",
				"newListItem", "newListItem", "newListItem", "newListItem",
				"newListItem", "newListItem", "newListItem", "newListItem",
				"newListItem", "newListItem", "newListItem",};

		this.exercisesListAdapter = new MyListAdapter(getActivity(),
				R.layout.exerciseslist_detailed_layout,
				this.exercisesListContents, this.exercisesListSubcontents,
				this.exercisesListImages, this.exercisesListIcons);
		this.exercisesList = (ListView) rootView
				.findViewById(R.id.exercisesList);
		this.exercisesList.setAdapter(this.exercisesListAdapter);
		this.exercisesList.setOnItemClickListener(this);

		return rootView;
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);

		if (isVisibleToUser) {

		} else {

		}

	}

	@Override
	public void onItemClick(AdapterView<?> l, View v, int position, long id) {
		if (l.getId() == R.id.exercisesList) {
			String clickedItem = this.exercisesListContents[position];
			Intent intent = new Intent(getActivity(),
					ExerciseEditActivity.class);
			//use putExtra method of Intent here for passing additional information to ExerciseEditActivity
			startActivity(intent);
		}
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

}
