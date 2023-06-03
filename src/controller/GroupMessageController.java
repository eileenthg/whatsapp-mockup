package controller;

import model.*;

public class GroupMessageController extends MessageController{

	public GroupMessageController(User user, Group recipient) {
		super(user, recipient);
	}

	@Override
	public String getHeader() {
		Group recipientGroup = (Group) recipient;
		return recipientGroup.getName();
	}

}
