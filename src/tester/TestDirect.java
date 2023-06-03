package tester;

import model.*;
import view.*;
import controller.*;

import java.util.ArrayList;



public class TestDirect {
	public static void main(String[] args) {
		User user = new User("0103335555", "Kate");
		Friend friend = new Friend("0125556666", "Amy");
		
		Direct direct = new Direct(user.getMyself(), friend);
		ArrayList<Message> directMessage = new ArrayList<Message>();
		directMessage.add(new Message("Heyo", user.getMyself()));
		directMessage.add(new Message("Hi :)", user.getMyself()));
		directMessage.add(new Message("Wanna go out for coffee?", friend));
		directMessage.add(new Message("Sure", user.getMyself()));
		directMessage.add(new Message("Nice", friend));
		direct.setMessageList(directMessage);
				
		MessageController control = new DirectMessageController(user, direct);
		MessageViewer view = new DirectMessageViewer(control);
	}
}
