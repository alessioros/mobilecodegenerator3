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

public class VideosFragment extends Fragment implements OnItemClickListener {

	private View rootView;
	private Button videoButton;

	private GridView videosGrid;
	private MyGridAdapter videosGridAdapter;

	private Integer[] videosGridImages;

	private String[] videosGridContents;

	public VideosFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_videos, container,
				false);
		this.rootView = rootView;

		this.videoButton = (Button) rootView.findViewById(R.id.videoButton);
		this.videoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),
						VideoNewActivity.class);
				//use putExtra method of Intent here for passing additional information to VideoNewActivity
				startActivity(intent);
			}
		});

		//Change this to set a specific image id for each row
		this.videosGridImages = new Integer[]{R.drawable.grid_image,
				R.drawable.grid_image, R.drawable.grid_image,
				R.drawable.grid_image, R.drawable.grid_image,
				R.drawable.grid_image,};

		this.videosGridContents = new String[]{"00:00", "00:00", "00:00",
				"00:00", "00:00", "00:00",};

		this.videosGridAdapter = new MyGridAdapter(getActivity(),
				this.videosGridContents, this.videosGridImages);
		this.videosGrid = (GridView) rootView.findViewById(R.id.videosGrid);
		this.videosGrid.setAdapter(this.videosGridAdapter);
		this.videosGrid.setOnItemClickListener(this);

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
		if (l.getId() == R.id.videosGrid) {

			String clickedImageId = this.videosGridImages[position].toString();
			Intent intent = new Intent(getActivity(), VideoEditActivity.class);
			//use putExtra method of Intent here for passing additional information to VideoEditActivity
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
