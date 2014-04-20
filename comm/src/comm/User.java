package comm;

import handlers.UserHandler;

import java.util.List;

import messages.Message;
import conversations.Conversation;
import conversations.ConversationsContainer;

public class User implements UserInterface {
	private UserID userID;
	//ConversationContainer is a DB holding all conversations and messages owned by a User
	//This needs to be accessible by the User from anywhere. For now, a simple java object will do.
	private ConversationsContainer conversationContainer;
	private UserHandler userHandler;

	public User(UserID userID) {
		// a user has 3 components: a userID, a container holding all current
		// conversations, and a receiveMessage callback.
		// New User objects must be registered with the userHandler, so the
		// handler "knows"
		// about the receiveMessage callback to use when a message is incoming
		// for this user
		this.setUserID(userID);
		conversationContainer = new ConversationsContainer();
		userHandler = UserHandler.getInstance();
		// TODO what if this returns false?
		// A new user must register a receiveMessage callback
		userHandler.addNewUser(this);
	}

	// send a message to a list of contacts. return true on success
	// TODO contacts must contain at least the calling user, cannot be empty
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

	public UserID getUserID() {
		return userID;
	}

	public void setUserID(UserID userID) {
		this.userID = userID;
	}
}
