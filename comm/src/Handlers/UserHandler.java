package Handlers;

import java.util.List;

import comm.ReceiveMessageCallbackInterface;
import comm.User;
import comm.UserID;
import comm.UsersContainer;
import comm.Messages.Message;

public final class UserHandler {
	public static final UserHandler INSTANCE = new UserHandler();
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
				ReceiveMessageCallbackInterface callback = usersContainer.get(recipient);
				//TODO currently returns fail on first delivery failure. Think about that...?
				if (!callback.receiveMessageCallback(contacts, m))
				{
					return false;
				}
		}
		return true;
	}

	//A new user must register it's "receiveMessage" callback in order to receive messages
	public boolean addNewUser(User user) {

			ReceiveMessageCallbackInterface callback = user;
			return usersContainer.put(user.getuserID(), callback);
	}

}
