package it.polimi.bookshelf.model;

public class Book {

	private String ISBN;
	private String Title;
	private String Description;
	private Integer PageCount;
	private String Publisher;
	private String PublishedDate;
	private String Author;
	private String ShelfID;

	// default empty constructor
	public Book() {
	}

	// class constructor
	public Book(String ISBN,

			String Title, String Description, Integer PageCount, String Publisher, String PublishedDate, String Author,
			String ShelfID

	) {
		this.ISBN = ISBN;
		this.Title = Title;
		this.Description = Description;
		this.PageCount = PageCount;
		this.Publisher = Publisher;
		this.PublishedDate = PublishedDate;
		this.Author = Author;
		this.ShelfID = ShelfID;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getISBN() {
		return this.ISBN;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getTitle() {
		return this.Title;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getDescription() {
		return this.Description;
	}
	public void setPageCount(Integer PageCount) {
		this.PageCount = PageCount;
	}

	public Integer getPageCount() {
		return this.PageCount;
	}
	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	}

	public String getPublisher() {
		return this.Publisher;
	}
	public void setPublishedDate(String PublishedDate) {
		this.PublishedDate = PublishedDate;
	}

	public String getPublishedDate() {
		return this.PublishedDate;
	}
	public void setAuthor(String Author) {
		this.Author = Author;
	}

	public String getAuthor() {
		return this.Author;
	}

	public void setShelfID(String ShelfID) {
		this.ShelfID = ShelfID;
	}

	public String getShelfID() {
		return this.ShelfID;
	}
}
