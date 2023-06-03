package controller;


import model.*;

public class DirectMessageController extends MessageController {

	public DirectMessageController(User user, Direct recipient) {
		super(user, recipient);
	}
	

	@Override
	public String getHeader() {
		for(Friend x:recipient.getFriends()) {
			if(!(user.getMyself().equals(x))){
				return x.getName();
			}
		}
		
		return null;
	}

}
