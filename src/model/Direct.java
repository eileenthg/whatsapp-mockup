package model;

import java.util.ArrayList;

public class Direct extends Contact{
	
	public Direct(Friend user1, Friend user2) {
		ArrayList<Friend> friends = new ArrayList<Friend>(2);
		friends.add(user1);
		friends.add(user2);
		this.memberList = friends;
	}


}
