package handlers;

import java.util.concurrent.ConcurrentHashMap;

import comm.ReceiveMessageCallbackInterface;
import comm.UserID;

public class UsersContainer {
	private static ConcurrentHashMap<UserID, ReceiveMessageCallbackInterface> Users = new ConcurrentHashMap<UserID, ReceiveMessageCallbackInterface>();

	private boolean userExists(UserID userID) {
		return Users.containsKey(userID);
	}

	public ReceiveMessageCallbackInterface get(UserID recipient) {
		if (userExists(recipient)) {
			return Users.get(recipient);
		}
		return null;
	}

	public boolean put(UserID userID,
			ReceiveMessageCallbackInterface callback) {
		if (!userExists(userID))
		{
			return Users.put(userID, callback) != null;
		}
		//user already exists, must have a unique ID
		else
		{
			return false;
		}
	}
}
