package it.polimi.newapp.data;

import android.content.Context;

public class DataHandler {

	private Context context;
	private StorageHandler sh;

	public DataHandler(Context context) {
		this.context = context;
		this.sh = new StorageHandler(this.context);
	}

	public StorageHandler getStorageHandler() {
		return this.sh;
	}

}
