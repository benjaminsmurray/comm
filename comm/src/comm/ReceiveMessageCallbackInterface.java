package comm;

import java.util.List;

import comm.Messages.Message;

public interface ReceiveMessageCallbackInterface {
	//RecieveMessage needs to take the users involved in the conversation, and the new message.
	//Return true on success, false on fail
	public boolean receiveMessageCallback(List<UserID> contacts, Message m);
}
