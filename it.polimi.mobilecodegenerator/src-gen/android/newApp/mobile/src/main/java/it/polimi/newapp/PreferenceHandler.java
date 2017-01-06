package it.polimi.newapp;

public class PreferenceHandler {

	private SharedPreferences sp;
	private SharedPreferences.Editor editor;

	public PreferenceHandler(Context context) {
		SharedPreferences sharedPref = context.getSharedPreferences(Context.MODE_PRIVATE);
		this.sp = sharedPref;
		this.editor = sp.edit();
	}

	public String getNewKey() {

		String defaultValue = getString(R.string.newKey_default);
		return sp.getString(getString(R.string.newKey), defaultValue);
	}

	public void setNewKey(String value) {

		editor.putString(getString(R.string.newKey), value);
		editor.commit();
	}

	public void resetNewKey() {

		String defaultValue = getString(R.string.newKey_default);
		editor.putString(getString(R.string.newKey), defaultValue);
		editor.commit();
	}
	public String getNewKey1() {

		String defaultValue = getString(R.string.newKey1_default);
		return sp.getString(getString(R.string.newKey1), defaultValue);
	}

	public void setNewKey1(String value) {

		editor.putString(getString(R.string.newKey1), value);
		editor.commit();
	}

	public void resetNewKey1() {

		String defaultValue = getString(R.string.newKey1_default);
		editor.putString(getString(R.string.newKey1), defaultValue);
		editor.commit();
	}
	public String getNewKey2() {

		String defaultValue = getString(R.string.newKey2_default);
		return sp.getString(getString(R.string.newKey2), defaultValue);
	}

	public void setNewKey2(String value) {

		editor.putString(getString(R.string.newKey2), value);
		editor.commit();
	}

	public void resetNewKey2() {

		String defaultValue = getString(R.string.newKey2_default);
		editor.putString(getString(R.string.newKey2), defaultValue);
		editor.commit();
	}
	public String getNewKey3() {

		String defaultValue = getString(R.string.newKey3_default);
		return sp.getString(getString(R.string.newKey3), defaultValue);
	}

	public void setNewKey3(String value) {

		editor.putString(getString(R.string.newKey3), value);
		editor.commit();
	}

	public void resetNewKey3() {

		String defaultValue = getString(R.string.newKey3_default);
		editor.putString(getString(R.string.newKey3), defaultValue);
		editor.commit();
	}
	public int getNewKey4() {

		int defaultValue = getResources().getInteger(R.string.newKey4_default);
		return sp.getInt(getString(R.string.newKey4), defaultValue);
	}

	public void setNewKey4(int value) {

		editor.putInt(getString(R.string.newKey4), value);
		editor.commit();
	}

	public void resetNewKey4() {

		int defaultValue = getResources().getInteger(R.string.newKey4_default);
		editor.putInt(getString(R.string.newKey4), defaultValue);
		editor.commit();
	}
}
