package comm;

import java.util.List;

import messages.Message;

public interface UserInterface {
	//RecieveMessage needs to take the users involved in the conversation, and the new message.
	//Return true on success, false on fail
	public boolean receiveMessageCallback(List<UserID> contacts, Message m);
	
	public UserID getUserID();
}
