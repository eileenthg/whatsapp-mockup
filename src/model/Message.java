package model;

public class Message {

	private String text;
	private Friend sender;

	public Message(String text, Friend sender){
		this.text = text;
		this.sender = sender;
	}
	
	public String getText() {
		return text;
	}
	
	public Friend getSender() {
		return sender;
	}

}
