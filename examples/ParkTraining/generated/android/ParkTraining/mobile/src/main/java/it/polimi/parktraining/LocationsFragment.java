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

public class LocationsFragment extends Fragment implements OnItemClickListener {

	private View rootView;
	private Button locationButton;

	private ListView locationsList;
	private MyListAdapter locationsListAdapter;

	private Integer[] locationsListImages;
	private String[] locationsListContents;

	public LocationsFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_locations,
				container, false);
		this.rootView = rootView;

		this.locationButton = (Button) rootView
				.findViewById(R.id.locationButton);
		this.locationButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//TODO implement the action
			}
		});

		//Change this to set a specific image id for each row
		this.locationsListImages = new Integer[]{R.drawable.ic_stars_white,
				R.drawable.ic_stars_white, R.drawable.ic_stars_white,
				R.drawable.ic_stars_white, R.drawable.ic_stars_white,
				R.drawable.ic_stars_white, R.drawable.ic_stars_white,
				R.drawable.ic_stars_white, R.drawable.ic_stars_white,
				R.drawable.ic_stars_white,};
		this.locationsListContents = new String[]{"newListItem", "newListItem",
				"newListItem", "newListItem", "newListItem", "newListItem",
				"newListItem", "newListItem", "newListItem", "newListItem",};

		this.locationsListAdapter = new MyListAdapter(getActivity(),
				R.layout.locationslist_image_layout,
				this.locationsListContents, this.locationsListImages);
		this.locationsList = (ListView) rootView
				.findViewById(R.id.locationsList);
		this.locationsList.setAdapter(this.locationsListAdapter);
		this.locationsList.setOnItemClickListener(this);

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
		if (l.getId() == R.id.locationsList) {
			String clickedItem = this.locationsListContents[position];
			Intent intent = new Intent(getActivity(),
					LocationEditActivity.class);
			//use putExtra method of Intent here for passing additional information to LocationEditActivity
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
