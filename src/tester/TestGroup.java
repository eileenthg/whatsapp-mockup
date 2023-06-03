package tester;

import java.util.ArrayList;

import controller.*;
import model.*;
import view.*;

public class TestGroup {
	
	public static void main(String[] args) {
		User user = new User("0103335555", "Kate");
		Friend friend = new Friend("0125556666", "Amy");
		Friend friend2 = new Friend("0106667777", "Sara");
		ArrayList<Friend> test = new ArrayList<>();
		test.add(user.getMyself());
		test.add(friend2);
		test.add(friend);
		
		Group group = new Group(test);
		ArrayList<Message> groupMessage = new ArrayList<>();
		groupMessage.add(new Message("Eyo", friend2));
		groupMessage.add(new Message("Yoo", friend));
		groupMessage.add(new Message("Good morning!", user.getMyself()));
		group.setMessageList(groupMessage);
		
		GroupMessageController control = new GroupMessageController(user, group);
		GroupMessageViewer view = new GroupMessageViewer(control);
	
	}
	
}
