package it.polimi.bookshelf.fragments;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import it.polimi.bookshelf.R;

public class LoginFragment extends Fragment {

	private View rootView;
	private Button loginButton;

	public LoginFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_login, container, false);
		this.rootView = rootView;

		this.loginButton = (Button) rootView.findViewById(R.id.loginButton);
		this.loginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), HomeActivity.class);
				//use putExtra method of Intent here for passing additional information to HomeActivity
				startActivity(intent);
			}
		});

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
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

}
