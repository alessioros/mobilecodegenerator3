package it.polimi.bookshelf.model;

import java.util.List;

public class Shelf {

	private String name;
	private Integer BookCount;
	private List<String> BookIDs;

	// default empty constructor
	public Shelf() {
	}

	// class constructor
	public Shelf(String name,

			Integer BookCount) {
		this.name = name;
		this.BookCount = BookCount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setBookCount(Integer BookCount) {
		this.BookCount = BookCount;
	}

	public Integer getBookCount() {
		return this.BookCount;
	}

	public void setBookIDs(List<String> BookIDs) {
		this.BookIDs = BookIDs;
	}

	public List<String> getBookIDs() {
		return this.BookIDs;
	}

	public void addBookID(String BookID) {
		this.BookIDs.add(BookID);
	}
}
