package handlers;

import java.util.concurrent.ConcurrentHashMap;

import comm.UserInterface;
import comm.UserID;

public class UsersContainer {
	private static ConcurrentHashMap<UserID, UserInterface> Users = new ConcurrentHashMap<UserID, UserInterface>();

	private boolean userExists(UserID userID) {
		return Users.containsKey(userID);
	}

	public UserInterface get(UserID recipient) {
		if (userExists(recipient)) {
			return Users.get(recipient);
		}
		return null;
	}

	public boolean put(UserID userID,
			UserInterface callback) {
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
