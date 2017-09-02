package it.polimi.bookshelf.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import java.util.ArrayList;
import java.util.List;

import it.polimi.bookshelf.model.Book;
import it.polimi.bookshelf.model.Shelf;

public class DatabaseHandler {

	private DBHelper dbhelper;

	public DatabaseHandler(Context context) {
		dbhelper = new DBHelper(context);
	}

	public void insertBook(Book book) {
		SQLiteDatabase db = dbhelper.getWritableDatabase();

		ContentValues cv = new ContentValues();

		cv.put(DatabaseStrings.BOOK_ID, book.getISBN());

		cv.put(DatabaseStrings.BOOK_TITLE, book.getTitle());

		cv.put(DatabaseStrings.BOOK_DESCRIPTION, book.getDescription());

		cv.put(DatabaseStrings.BOOK_PAGECOUNT, book.getPageCount());

		cv.put(DatabaseStrings.BOOK_PUBLISHER, book.getPublisher());

		cv.put(DatabaseStrings.BOOK_PUBLISHEDDATE, book.getPublishedDate());

		cv.put(DatabaseStrings.BOOK_AUTHOR, book.getAuthor());

		cv.put(DatabaseStrings.SHELF_ID, book.getShelfID());
		try {
			db.insert(DatabaseStrings.TBL_BOOK, null, cv);
		} catch (SQLiteException sqle) {
			sqle.printStackTrace();
		}
	}
	public void insertShelf(Shelf shelf) {
		SQLiteDatabase db = dbhelper.getWritableDatabase();

		ContentValues cv = new ContentValues();

		cv.put(DatabaseStrings.SHELF_ID, shelf.getName());

		cv.put(DatabaseStrings.SHELF_BOOKCOUNT, shelf.getBookCount());

		try {
			db.insert(DatabaseStrings.TBL_SHELF, null, cv);
		} catch (SQLiteException sqle) {
			sqle.printStackTrace();
		}
	}
	public boolean deleteBook(String ISBN) {
		SQLiteDatabase db = dbhelper.getWritableDatabase();
		try {
			return db.delete(DatabaseStrings.TBL_BOOK, DatabaseStrings.BOOK_ID + "=?", new String[]{ISBN}) > 0;
		} catch (SQLiteException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	public boolean deleteShelf(String name) {
		SQLiteDatabase db = dbhelper.getWritableDatabase();
		try {
			return db.delete(DatabaseStrings.TBL_SHELF, DatabaseStrings.SHELF_ID + "=?", new String[]{name}) > 0;
		} catch (SQLiteException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	public Book queryBook(String ISBN) {
		Cursor crs;
		Book book = new Book();
		SQLiteDatabase db = dbhelper.getWritableDatabase();

		String tableName = DatabaseStrings.TBL_BOOK;
		String primaryKey = DatabaseStrings.BOOK_ID;
		String[] whereArgs = new String[]{ISBN};

		try {
			String SQL_QUERY = "SELECT * FROM " + tableName + " WHERE " + primaryKey + " = ?";
			crs = db.rawQuery(SQL_QUERY, whereArgs);
		} catch (SQLiteException sqle) {
			sqle.printStackTrace();
			return null;
		}

		crs.moveToFirst();
		while (!crs.isAfterLast()) {
			book.setTitle(crs.getString(0));
			book.setDescription(crs.getString(1));
			book.setPageCount(crs.getInt(2));
			book.setPublisher(crs.getString(3));
			book.setPublishedDate(crs.getString(4));
			book.setAuthor(crs.getString(5));
			crs.moveToNext();
		}
		crs.close();

		return book;
	}
	public Shelf queryShelf(String name) {
		Cursor crs;
		Shelf shelf = new Shelf();
		SQLiteDatabase db = dbhelper.getWritableDatabase();

		String tableName = DatabaseStrings.TBL_SHELF;
		String primaryKey = DatabaseStrings.SHELF_ID;
		String[] whereArgs = new String[]{name};

		try {
			String SQL_QUERY = "SELECT * FROM " + tableName + " WHERE " + primaryKey + " = ?";
			crs = db.rawQuery(SQL_QUERY, whereArgs);
		} catch (SQLiteException sqle) {
			sqle.printStackTrace();
			return null;
		}

		crs.moveToFirst();
		while (!crs.isAfterLast()) {
			shelf.setBookCount(crs.getInt(0));
			crs.moveToNext();
		}
		crs.close();

		return shelf;
	}
	public List<Book> getBookList() {
		SQLiteDatabase db = dbhelper.getWritableDatabase();

		Cursor crs;
		List<Book> bookList = new ArrayList<>();

		String tableName = DatabaseStrings.TBL_BOOK;

		try {
			String SQL_QUERY = "SELECT * FROM " + tableName;
			crs = db.rawQuery(SQL_QUERY, null);
		} catch (SQLiteException sqle) {
			sqle.printStackTrace();
			return null;
		}

		crs.moveToFirst();
		while (!crs.isAfterLast()) {

			Book book = new Book();

			book.setISBN(crs.getString(0));

			book.setTitle(crs.getString(0));
			book.setDescription(crs.getString(1));
			book.setPageCount(crs.getInt(3));
			book.setPublisher(crs.getString(3));
			book.setPublishedDate(crs.getString(4));
			book.setAuthor(crs.getString(5));

			bookList.add(book);
			crs.moveToNext();
		}
		crs.close();

		return bookList;

	}
	public List<Shelf> getShelfList() {
		SQLiteDatabase db = dbhelper.getWritableDatabase();

		Cursor crs;
		List<Shelf> shelfList = new ArrayList<>();

		String tableName = DatabaseStrings.TBL_SHELF;

		try {
			String SQL_QUERY = "SELECT * FROM " + tableName;
			crs = db.rawQuery(SQL_QUERY, null);
		} catch (SQLiteException sqle) {
			sqle.printStackTrace();
			return null;
		}

		crs.moveToFirst();
		while (!crs.isAfterLast()) {

			Shelf shelf = new Shelf();

			shelf.setName(crs.getString(0));

			shelf.setBookCount(crs.getInt(1));

			shelfList.add(shelf);
			crs.moveToNext();
		}
		crs.close();

		return shelfList;

	}
}
