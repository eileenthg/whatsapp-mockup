package controller;

import java.util.List;

import model.*;

public abstract class MessageController {
	protected User user;
	protected Contact recipient;
	protected List<Message> messageList;

	public MessageController(User user, Contact recipient) {
		this.user = user;
		this.recipient = recipient;
		this.messageList = recipient.getMessageList();
	}

	public int getMessageCount() {
		return messageList.size();
	}

	public Message getMessage(int index) {
		return messageList.get(index);
	}
	
	public Friend getMessageSender(int index) {
		return messageList.get(index).getSender();
	}
	
	public String getMessageSenderName(int index) {
		return messageList.get(index).getSender().getName();
	}
	
	public String getMessageText(int index) {
		return messageList.get(index).getText();
	}

	public void sendMessage(String message) {
		while(!recipient.newMessage(message, user)) {
			try {
				recipient.newMessage(message, user);
			} catch(Exception e) {
				System.out.println("Something went wrong in MessageController.sendMessage()");
				System.out.println(e.getMessage());
			}
		}
		this.messageList = recipient.getMessageList();
	}

	public abstract String getHeader();

	public User getUser() {
		return user;
	}
	
	public Friend getUserSelf() {
		return user.getMyself();
	}

}
