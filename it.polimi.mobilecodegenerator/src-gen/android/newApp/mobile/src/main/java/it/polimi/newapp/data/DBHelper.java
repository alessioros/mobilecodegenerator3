package it.polimi.newapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	// If you change the database schema, you must increment the database version.
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "SQLITE_DB";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	String CREATE_NEWENTITY="CREATE TABLE "+DatabaseStrings.TBL_NEWENTITY+
                " (" + DatabaseStrings.NEWENTITY_ID + " INTEGER PRIMARY KEY," +
DatabaseStrings.[NEWENTITY]_[FASFADF]+" TEXT," +
DatabaseStrings.NEWENTITY_FDSF+" TEXT)";
  	db.execSQL(CREATE_NEWENTITY);

	String CREATE_PERSON="CREATE TABLE "+DatabaseStrings.TBL_PERSON+
                " (" + DatabaseStrings.PERSON_ID + " INTEGER PRIMARY KEY," +
DatabaseStrings.[PERSON, PERSON, PERSON, PERSON]_[NAME, SURNAME, AGE, ISMARRIED]+" TEXT," +
DatabaseStrings.[PERSON, PERSON, PERSON, PERSON]_[NAME, SURNAME, AGE, ISMARRIED]+" TEXT," +
DatabaseStrings.[PERSON, PERSON, PERSON, PERSON]_[NAME, SURNAME, AGE, ISMARRIED]+" INT," +
DatabaseStrings.[PERSON, PERSON, PERSON, PERSON]_[NAME, SURNAME, AGE, ISMARRIED]+" INT," +
DatabaseStrings.PERSON_BIRTHDAY+" TEXT)";
  	db.execSQL(CREATE_PERSON);
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}
