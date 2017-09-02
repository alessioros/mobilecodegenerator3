package it.polimi.bookshelf.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	// If you change the database schema, you must increment the database version.
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "SQLITE_DB";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String CREATE_BOOK = "CREATE TABLE " + DatabaseStrings.TBL_BOOK + " (" + DatabaseStrings.BOOK_ID
				+ " TEXT PRIMARY KEY," +

				DatabaseStrings.BOOK_TITLE + " TEXT," + DatabaseStrings.BOOK_DESCRIPTION + " TEXT,"
				+ DatabaseStrings.BOOK_PAGECOUNT + " INT," + DatabaseStrings.BOOK_PUBLISHER + " TEXT,"
				+ DatabaseStrings.BOOK_PUBLISHEDDATE + " TEXT," + DatabaseStrings.BOOK_AUTHOR + " TEXT,"
				+ DatabaseStrings.SHELF_ID + " TEXT," + " FOREIGN KEY (" + DatabaseStrings.SHELF_ID + ") REFERENCES "
				+ DatabaseStrings.TBL_SHELF + "(" + DatabaseStrings.SHELF_ID + "));";

		db.execSQL(CREATE_BOOK);

		String CREATE_SHELF = "CREATE TABLE " + DatabaseStrings.TBL_SHELF + " (" + DatabaseStrings.SHELF_ID
				+ " TEXT PRIMARY KEY," +

				DatabaseStrings.SHELF_BOOKCOUNT + " INT)";

		db.execSQL(CREATE_SHELF);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DBHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion
				+ ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + DatabaseStrings.TBL_BOOK);
		db.execSQL("DROP TABLE IF EXISTS " + DatabaseStrings.TBL_SHELF);
		onCreate(db);
	}
}
