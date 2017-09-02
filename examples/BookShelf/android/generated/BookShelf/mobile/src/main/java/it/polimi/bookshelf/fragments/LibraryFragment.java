package it.polimi.bookshelf.fragments;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import it.polimi.bookshelf.R;

public class LibraryFragment extends Fragment implements OnItemClickListener {

	private View rootView;

	private ListView trcjpListView;
	private MyListAdapter trcjpListViewAdapter;
	private String[] trcjpListViewContents;

	public LibraryFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_library, container, false);
		this.rootView = rootView;

		this.trcjpListViewContents = new String[]{"shelf1",};

		this.trcjpListViewAdapter = new MyListAdapter(getActivity(), R.layout.trcjplistview_simple_layout,
				this.trcjpListViewContents);
		this.trcjpListView = (ListView) rootView.findViewById(R.id.trcjpListView);
		this.trcjpListView.setAdapter(this.trcjpListViewAdapter);
		this.trcjpListView.setOnItemClickListener(this);

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
		if (l.getId() == R.id.trcjpListView) {
			String clickedItem = this.trcjpListViewContents[position];
			Intent intent = new Intent(getActivity(), ShelfDetailActivity.class);
			//use putExtra method of Intent here for passing additional information to ShelfDetailActivity
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
