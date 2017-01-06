package it.polimi.newapp;

public class DataHandler {

	private Context context;
	private PreferenceHandler ph;

	public DataHandler(Context context) {
		this.context = context;
		this.ph = new PreferenceHandler(this.context);
	}

	public PreferenceHandler getPreferencesHandler() {
		return this.ph;
	}

}
