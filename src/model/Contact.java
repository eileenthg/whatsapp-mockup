package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Contact {
	private ArrayList<Message> messageList = new ArrayList<>();
	protected ArrayList<Friend> memberList = new ArrayList<>();
	

	
	//newest message at last entry
	public boolean newMessage(String text, User sender) {
		try {
			messageList.add(new Message(text, sender.getMyself()));
			return true;
		}catch (Exception e) {
			System.out.println("Something went wrong in Contact.sendMessage");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public List<Message> getMessageList() {
		return Collections.unmodifiableList(new ArrayList<Message>(messageList)); //make it list is read only
	} 
	
	public List<Friend> getFriends() {
		return Collections.unmodifiableList(new ArrayList<Friend>(memberList)); //make it list is read only
	}; 
	
	//ONLY FOR TEST PURPOSES AND PROTOTYPING
	public void setMessageList(ArrayList<Message> messageList) {
		this.messageList = messageList;
	}
}
