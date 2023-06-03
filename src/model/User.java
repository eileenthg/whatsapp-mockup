package model;

public class User {
	private Friend myself;
	
	//placeholder for login
	public User(String contactNum, String name) {
		this.myself = new Friend(contactNum, name);
	}
	
	public Friend getMyself() {
		return myself;
	}

	
}
