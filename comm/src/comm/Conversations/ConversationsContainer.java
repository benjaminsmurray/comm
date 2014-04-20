package comm.Conversations;

import java.util.HashMap;
import java.util.List;

import comm.UserID;
import comm.Messages.Message;

public class ConversationsContainer {
	private HashMap<Integer, Conversation> conversations;
	
	public ConversationsContainer()
	{
		conversations = new HashMap<Integer, Conversation>();
	}
	
	public boolean receiveMessage(List<UserID> contacts, Message message)
	{
		Integer conversationID = ConversationIDGenerator.generateConversationID(contacts);
		if (!conversations.containsKey(conversationID))
		{
			conversations.put(conversationID, new Conversation(contacts));
		}
		Conversation conversation = conversations.get(conversationID);
		return conversation.writeMessage(message);

	}

	public void remove(List<UserID> contacts) {
		Integer conversationID = ConversationIDGenerator.generateConversationID(contacts);
		conversations.remove(conversationID);
	}

	public Conversation get(List<UserID> contacts) {
		Integer conversationID = ConversationIDGenerator.generateConversationID(contacts);
		return conversations.get(conversationID);
	}
	
}
