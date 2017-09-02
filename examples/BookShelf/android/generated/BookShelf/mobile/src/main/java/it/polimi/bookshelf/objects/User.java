package it.polimi.bookshelf.objects;

public class User {

	public String access_email;
	public String password;
	public String user_name;
	public String user_surname;

	public User() {

	}

	public User(String access_email, String password, String user_name, String user_surname) {
		this.access_email = access_email;
		this.password = password;
		this.user_name = user_name;
		this.user_surname = user_surname;
	}

	public void setAccess_email(String access_email) {
		this.access_email = access_email;
	}

	public String getAccess_email() {
		return this.access_email;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_name() {
		return this.user_name;
	}
	public void setUser_surname(String user_surname) {
		this.user_surname = user_surname;
	}

	public String getUser_surname() {
		return this.user_surname;
	}
}
