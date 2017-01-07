package it.polimi.newapp;

import android.content.Context;

public class DataHandler {

	private Context context;
	private PreferenceHandler ph;
	private DatabaseHandler dbh;

	public DataHandler(Context context) {
		this.context = context;
		this.ph = new PreferenceHandler(this.context);
		this.dbh = new DatabaseHandler(this.context);
	}

	public PreferenceHandler getPreferencesHandler() {
		return this.ph;
	}
	public DatabaseHandler getDatabaseHandler() {
		return this.dbh;
	}

}
