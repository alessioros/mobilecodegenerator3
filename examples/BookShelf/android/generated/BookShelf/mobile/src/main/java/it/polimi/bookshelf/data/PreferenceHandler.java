package it.polimi.bookshelf.data;

import android.content.Context;
import android.content.SharedPreferences;
import it.polimi.bookshelf.R;

public class PreferenceHandler {

	private SharedPreferences sp;
	private SharedPreferences.Editor editor;
	private String PREFERENCE_NAME = "default";
	private Context context;

	public PreferenceHandler(Context context) {
		SharedPreferences sharedPref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		this.context = context;
		this.sp = sharedPref;
	}

	public String getAccessEmail() {

		String defaultValue = context.getResources().getString(R.string.accessEmail_default);
		return sp.getString(context.getResources().getString(R.string.accessEmail), defaultValue);
	}

	public void setAccessEmail(String value) {

		editor = sp.edit();
		editor.putString(context.getResources().getString(R.string.accessEmail), value);
		editor.apply();
	}

	public void resetAccessEmail() {

		editor = sp.edit();
		String defaultValue = context.getResources().getString(R.string.accessEmail_default);
		editor.putString(context.getResources().getString(R.string.accessEmail), defaultValue);
		editor.apply();
	}

	public void deleteAccessEmail() {

		editor = sp.edit();
		editor.remove(context.getResources().getString(R.string.accessEmail));
		editor.apply();
	}
	public String getPassword() {

		String defaultValue = context.getResources().getString(R.string.password_default);
		return sp.getString(context.getResources().getString(R.string.password), defaultValue);
	}

	public void setPassword(String value) {

		editor = sp.edit();
		editor.putString(context.getResources().getString(R.string.password), value);
		editor.apply();
	}

	public void resetPassword() {

		editor = sp.edit();
		String defaultValue = context.getResources().getString(R.string.password_default);
		editor.putString(context.getResources().getString(R.string.password), defaultValue);
		editor.apply();
	}

	public void deletePassword() {

		editor = sp.edit();
		editor.remove(context.getResources().getString(R.string.password));
		editor.apply();
	}
	public String getUserSurname() {

		String defaultValue = context.getResources().getString(R.string.userSurname_default);
		return sp.getString(context.getResources().getString(R.string.userSurname), defaultValue);
	}

	public void setUserSurname(String value) {

		editor = sp.edit();
		editor.putString(context.getResources().getString(R.string.userSurname), value);
		editor.apply();
	}

	public void resetUserSurname() {

		editor = sp.edit();
		String defaultValue = context.getResources().getString(R.string.userSurname_default);
		editor.putString(context.getResources().getString(R.string.userSurname), defaultValue);
		editor.apply();
	}

	public void deleteUserSurname() {

		editor = sp.edit();
		editor.remove(context.getResources().getString(R.string.userSurname));
		editor.apply();
	}
	public String getUserName() {

		String defaultValue = context.getResources().getString(R.string.userName_default);
		return sp.getString(context.getResources().getString(R.string.userName), defaultValue);
	}

	public void setUserName(String value) {

		editor = sp.edit();
		editor.putString(context.getResources().getString(R.string.userName), value);
		editor.apply();
	}

	public void resetUserName() {

		editor = sp.edit();
		String defaultValue = context.getResources().getString(R.string.userName_default);
		editor.putString(context.getResources().getString(R.string.userName), defaultValue);
		editor.apply();
	}

	public void deleteUserName() {

		editor = sp.edit();
		editor.remove(context.getResources().getString(R.string.userName));
		editor.apply();
	}
	public int getBookCount() {

		int defaultValue = Integer.parseInt(context.getResources().getString(R.string.bookCount_default));
		return sp.getInt(context.getResources().getString(R.string.bookCount), defaultValue);
	}

	public void setBookCount(int value) {

		editor = sp.edit();
		editor.putInt(context.getResources().getString(R.string.bookCount), value);
		editor.apply();
	}

	public void resetBookCount() {

		editor = sp.edit();
		int defaultValue = Integer.parseInt(context.getResources().getString(R.string.bookCount_default));
		editor.putInt(context.getResources().getString(R.string.bookCount), defaultValue);
		editor.apply();
	}

	public void deleteBookCount() {

		editor = sp.edit();
		editor.remove(context.getResources().getString(R.string.bookCount));
		editor.apply();
	}
}
