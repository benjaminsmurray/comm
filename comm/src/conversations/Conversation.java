package conversations;

import java.util.LinkedList;
import java.util.List;

import messages.Message;
import comm.UserID;

public class Conversation {
	//a conversation has 2 components.
	
	//contacts are users having the conversation. 
	//it is final because once a conversation starts, you cannot add or remove people.
	//a Conversation is unique, keyed on the list of contacts
	private final List<UserID> contacts;
	
	//messages are every message written to the conversation
	private List<Message> messages;



	//A new conversation must have at least one contact - a creating user can message him/herself
	//Every new conversation is given a conversation ID.
	public Conversation(List<UserID> contacts) {
		this.contacts = contacts;
		messages = new LinkedList<Message>();
	}

	public List<UserID> getContacts() {
		return contacts;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public boolean writeMessage(Message message) {
		return messages.add(message);
	}
	
}
