package model;

import java.util.ArrayList;

public class Group extends Contact{
	private String name;
	//addFriend and removeFriend methods

	public Group(ArrayList<Friend> friends) {
		this.name = "Placeholder name";
		this.memberList = friends;
	}
	public String getName() {
		return name;
	}
}