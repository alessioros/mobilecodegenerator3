package it.polimi.bookshelf.activities;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import it.polimi.bookshelf.R;

import it.polimi.bookshelf.fragments.HomeFragment;
import it.polimi.bookshelf.fragments.LibraryFragment;
import it.polimi.bookshelf.fragments.AboutFragment;
import it.polimi.bookshelf.fragments.SettingsFragment;
import it.polimi.bookshelf.fragments.LoginFragment;

public class LoginActivity extends AppCompatActivity {

	private SectionsPagerAdapter mSectionsPagerAdapter;
	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.login_toolbar);
		setSupportActionBar(toolbar);

		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		mViewPager = (ViewPager) this.findViewById(R.id.login_container);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		TabLayout tabLayout = (TabLayout) this.findViewById(R.id.login_tabs);
		tabLayout.setupWithViewPager(mViewPager);
	}

	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
				case 0 :
					return new HomeFragment();
				case 1 :
					return new LibraryFragment();
				case 2 :
					return new AboutFragment();
				case 3 :
					return new SettingsFragment();
				case 4 :
					return new LoginFragment();
			}
			return null;
		}

		@Override
		public int getCount() {
			return 5;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
				case 0 :
					return "HOME";
				case 1 :
					return "LIBRARY";
				case 2 :
					return "ABOUT";
				case 3 :
					return "SETTINGS";
				case 4 :
					return "LOGOUT";
			}
			return null;
		}
	}

}
