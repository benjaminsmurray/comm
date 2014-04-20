package comm;

import java.util.List;

import Handlers.UserHandler;
import comm.Conversations.Conversation;
import comm.Conversations.ConversationsContainer;
import comm.Messages.Message;

public class User implements ReceiveMessageCallbackInterface{
	private UserID userID;
	private ConversationsContainer conversationContainer;
	private UserHandler userHandler;

	public User(UserID userID) {
		// a user has 3 components: a userID, a container holding all current
		// conversations, and a receiveMessage callback.
		this.setuserID(userID);
		conversationContainer = new ConversationsContainer();
		userHandler = UserHandler.getInstance();
		// TODO what if this returns false?
		// A new user must be register a receiveMessage callback
		userHandler.addNewUser(this);
	}

	// send a message to a list of contacts. return true on success
	//TODO contacts must contain at least the calling user, cannot be empty
	public boolean sendMessage(List<UserID> contacts, Message message) {

		// contacts is a parameter because it is used as the index for a
		// conversation by the destination user
		return userHandler.sendMessage(this, contacts, message);

	}

	// delete conversation with list of users from the container. Return true on
	// success
	public boolean deleteConversation(List<UserID> contacts) {
		conversationContainer.remove(contacts);
		return true;
	}

	public boolean receiveMessageCallback(List<UserID> contacts, Message m) {
		return conversationContainer.receiveMessage(contacts, m);
	}

	// return entire conversation with contacts
	public Conversation getConversation(List<UserID> contacts) {
		return conversationContainer.get(contacts);
	}

	public UserID getuserID() {
		return userID;
	}

	public void setuserID(UserID userID) {
		this.userID = userID;
	}
}
