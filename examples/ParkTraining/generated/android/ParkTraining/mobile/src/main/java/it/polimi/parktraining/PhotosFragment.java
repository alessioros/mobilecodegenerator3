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
import android.widget.GridView;

public class PhotosFragment extends Fragment implements OnItemClickListener {

	private View rootView;
	private Button photoButton;

	private GridView photosGrid;
	private MyGridAdapter photosGridAdapter;

	private Integer[] photosGridImages;

	public PhotosFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_photos, container,
				false);
		this.rootView = rootView;

		this.photoButton = (Button) rootView.findViewById(R.id.photoButton);
		this.photoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),
						PhotoNewActivity.class);
				//use putExtra method of Intent here for passing additional information to PhotoNewActivity
				startActivity(intent);
			}
		});

		//Change this to set a specific image id for each row
		this.photosGridImages = new Integer[]{R.drawable.grid_image,
				R.drawable.grid_image, R.drawable.grid_image,
				R.drawable.grid_image, R.drawable.grid_image,
				R.drawable.grid_image,};

		this.photosGridAdapter = new MyGridAdapter(getActivity(),
				this.photosGridImages);
		this.photosGrid = (GridView) rootView.findViewById(R.id.photosGrid);
		this.photosGrid.setAdapter(this.photosGridAdapter);
		this.photosGrid.setOnItemClickListener(this);

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
		if (l.getId() == R.id.photosGrid) {

			String clickedImageId = this.photosGridImages[position].toString();
			Intent intent = new Intent(getActivity(), PhotoEditActivity.class);
			//use putExtra method of Intent here for passing additional information to PhotoEditActivity
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
