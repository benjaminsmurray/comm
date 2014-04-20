package handlers;

import java.util.List;

import messages.Message;
import comm.UserInterface;
import comm.User;
import comm.UserID;

public final class UserHandler {
	private static final UserHandler INSTANCE = new UserHandler();
	//UsersContainer is the DB of users. For now, a java object can hold them.
	private static UsersContainer usersContainer = new UsersContainer();
	
    // Private constructor prevents instantiation from other classes
	private UserHandler()
	{

	}
    
    public static UserHandler getInstance() {
        return INSTANCE;
    }

	public boolean sendMessage(User requestingUser, List<UserID> contacts, Message m) {
		// TODO perform message validation.
		//Assert m.author == requestingUser.UserID
		
		//TODO user authentication
		
		for (UserID recipient: contacts)
		{
				UserInterface callback = usersContainer.get(recipient);
				//TODO currently returns fail on first delivery failure. Think about that...?
				//retry logic
				if (!callback.receiveMessageCallback(contacts, m))
				{
					return false;
				}
		}
		return true;
	}

	//A new user must register it's "receiveMessage" callback in order to receive messages
	public boolean addNewUser(User user) {

			UserInterface callback = user;
			return usersContainer.put(user.getUserID(), callback);
	}

}
