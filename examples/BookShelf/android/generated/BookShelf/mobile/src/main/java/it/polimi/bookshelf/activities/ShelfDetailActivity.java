package it.polimi.bookshelf.activities;

import android.os.Bundle;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import it.polimi.bookshelf.R;

public class ShelfDetailActivity extends AppCompatActivity implements OnItemClickListener {

	private ListView bookList;
	private MyListAdapter bookListAdapter;
	private String[] bookListContents;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shelfdetail);
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.shelfdetail_toolbar);
		setSupportActionBar(toolbar);

		this.bookListContents = new String[]{};

		this.bookListAdapter = new MyListAdapter(this, R.layout.booklist_simple_layout, this.bookListContents);
		this.bookList = (ListView) this.findViewById(R.id.bookList);
		this.bookList.setAdapter(this.bookListAdapter);
		this.bookList.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> l, View v, int position, long id) {
		if (l.getId() == R.id.bookList) {
			String clickedItem = this.bookListContents[position];
			Intent intent = new Intent(ShelfDetailActivity.this, BookDetailActivity.class);
			//use putExtra method of Intent here for passing additional information to BookDetailActivity
			startActivity(intent);
		}
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
