package it.polimi.newapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class DatabaseHandler {

	private DBHelper dbhelper;

	public DatabaseHandler(Context context) {
		dbhelper = new DBHelper(context);
	}

	public void insertNewEntity(String fasfadf, String fdsf) {
		SQLiteDatabase db = dbhelper.getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put(DatabaseStrings.NEWENTITY_FASFADF, fasfadf);
		cv.put(DatabaseStrings.NEWENTITY_FDSF, fdsf);
		try {
			db.insert(DatabaseStrings.TBL_NEWENTITY, null, cv);
		} catch (SQLiteException sqle) {

		}
	}
	public void insertPerson(String Name, String Surname, int Age, boolean IsMarried, String Birthday) {
		SQLiteDatabase db = dbhelper.getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put(DatabaseStrings.PERSON_NAME, Name);
		cv.put(DatabaseStrings.PERSON_SURNAME, Surname);
		cv.put(DatabaseStrings.PERSON_AGE, Age);
		cv.put(DatabaseStrings.PERSON_ISMARRIED, IsMarried);
		cv.put(DatabaseStrings.PERSON_BIRTHDAY, Birthday);
		try {
			db.insert(DatabaseStrings.TBL_PERSON, null, cv);
		} catch (SQLiteException sqle) {

		}
	}
	public boolean delete(long id) {
		SQLiteDatabase db = dbhelper.getWritableDatabase();
		try {
			if (db.delete(DatabaseStrings.TBL_NEWENTITY, DatabaseStrings.NEWENTITY_ID + "=?",
					new String[]{Long.toString(id)}) > 0)
				return true;
			return false;
		} catch (SQLiteException sqle) {
			return false;
		}
	}
	public boolean delete(long id) {
		SQLiteDatabase db = dbhelper.getWritableDatabase();
		try {
			if (db.delete(DatabaseStrings.TBL_PERSON, DatabaseStrings.PERSON_ID + "=?",
					new String[]{Long.toString(id)}) > 0)
				return true;
			return false;
		} catch (SQLiteException sqle) {
			return false;
		}
	}
	public Cursor queryNewEntity() {
		Cursor crs = null;
		try {
			SQLiteDatabase db = dbhelper.getReadableDatabase();
			crs = db.query(DatabaseStrings.TBL_NEWENTITY, null, null, null, null, null, null, null);
		} catch (SQLiteException sqle) {
			return null;
		}
		return crs;
	}
	public Cursor queryPerson() {
		Cursor crs = null;
		try {
			SQLiteDatabase db = dbhelper.getReadableDatabase();
			crs = db.query(DatabaseStrings.TBL_PERSON, null, null, null, null, null, null, null);
		} catch (SQLiteException sqle) {
			return null;
		}
		return crs;
	}
}
