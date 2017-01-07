package it.polimi.newapp;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHandler {

	private SharedPreferences sp;
	private SharedPreferences.Editor editor;
	private PREFERENCE_NAME = 'default' 
	
	public PreferenceHandler(Context context){
		SharedPreferences sharedPref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		this.sp = sharedPref;
		this.editor = sp.edit();
	}

	public String getUsername() {

		String defaultValue = context.getResources().getString(R.string.username_default);
		return sp.getString(context.getResources().getString(R.string.username), defaultValue);
	}

	public void setUsername(String value) {

		editor.putString(context.getResources().getString(R.string.username), value);
		editor.commit();
	}

	public void resetUsername() {

		String defaultValue = context.getResources().getString(R.string.username_default);
		editor.putString(context.getResources().getString(R.string.username), defaultValue);
		editor.commit();
	}
	public int getAge() {

		int defaultValue = Integer.parseInt(context.getResources().getString(R.string.age_default));
		return sp.getInt(context.getResources().getString(R.string.age), defaultValue);
	}

	public void setAge(int value) {

		editor.putInt(context.getResources().getString(R.string.age), value);
		editor.commit();
	}

	public void resetAge() {

		int defaultValue = Integer.parseInt(context.getResources().getString(R.string.age_default));
		editor.putInt(context.getResources().getString(R.string.age), defaultValue);
		editor.commit();
	}
public float getAvgPoints(){
	
	float defaultValue = Float.parseFloat(context.getResources().getResources().getString(R.string.avgPoints_default));
	return sp.getFloat(context.getResources()getString(R.string.avgPoints), defaultValue);
}

	public void setAvgPoints(float value) {

		editor.putFloat(context.getResources().getString(R.string.avgPoints), value);
		editor.commit();
	}

	public void resetAvgPoints() {

		float defaultValue = Float
				.parseFloat(context.getResources().getResources().getString(R.string.avgPoints_default));
		editor.putFloat(context.getResources().getString(R.string.avgPoints), defaultValue);
		editor.commit();
	}
	public String getGender() {

		String defaultValue = context.getResources().getString(R.string.gender_default);
		return sp.getString(context.getResources().getString(R.string.gender), defaultValue);
	}

	public void setGender(String value) {

		editor.putString(context.getResources().getString(R.string.gender), value);
		editor.commit();
	}

	public void resetGender() {

		String defaultValue = context.getResources().getString(R.string.gender_default);
		editor.putString(context.getResources().getString(R.string.gender), defaultValue);
		editor.commit();
	}
	public Boolean getIsOkay() {

		Boolean defaultValue = Boolean
				.parseBoolen(context.getResources().getResources().getString(R.string.isOkay_default));
		return sp.getBoolean(context.getResources().getString(R.string.isOkay), defaultValue);
	}

	public void setIsOkay(Boolean value) {

		editor.putBoolean(context.getResources().getString(R.string.isOkay), value);
		editor.commit();
	}

	public void resetIsOkay() {

		Boolean defaultValue = Boolean
				.parseBoolen(context.getResources().getResources().getString(R.string.isOkay_default));
		editor.putBoolean(context.getResources().getString(R.string.isOkay), defaultValue);
		editor.commit();
	}
}
