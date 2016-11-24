package it.polimi.parktraining;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class ExercisesActivity extends AppCompatActivity {

	private SectionsPagerAdapter mSectionsPagerAdapter;
	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercises);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.exercises_toolbar);
		setSupportActionBar(toolbar);

		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());
		mViewPager = (ViewPager) this.findViewById(R.id.exercises_container);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		TabLayout tabLayout = (TabLayout) this
				.findViewById(R.id.exercises_tabs);
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
					return new ExercisesFragment();
				case 1 :
					return new PhotosFragment();
				case 2 :
					return new VideosFragment();
				case 3 :
					return new LocationsFragment();
			}
			return null;
		}

		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
				case 0 :
					return "EXERCISES";
				case 1 :
					return "PHOTOS";
				case 2 :
					return "VIDEOS";
				case 3 :
					return "LOCATIONS";
			}
			return null;
		}
	}

}
