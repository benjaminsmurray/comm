package comm.Conversations;

import java.util.List;

import comm.UserID;

public class ConversationIDGenerator {

public static int generateConversationID(List<UserID> contacts)
{
	//TODO the ID generated needs to be unique
	return contacts.hashCode();
}

}
