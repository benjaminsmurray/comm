package comm;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import messages.Message;

import org.junit.Test;

public class SendMessageTest {

	@Test
	public void test() {
		UserID user1Name = new UserID("user1");
		UserID user2Name = new UserID("user2");
		String message1String = "message1";
		String message2String = "message2";
		int message1Type = 1;
		int message2Type = 2;
		
		User user1 = new User(user1Name);
		User user2 = new User(user2Name);
		
		Message m1 = new Message(message1Type, message1String, user1Name);
		Message m2 = new Message(message2Type, message2String, user2Name);
		List<UserID> contacts = new LinkedList<UserID>();
		contacts.add(user1Name);
		contacts.add(user2Name);
		user1.sendMessage(contacts, m1);
		user2.sendMessage(contacts, m2);
		
		assertEquals(user1.getConversation(contacts).getMessages().get(0).getBody(), message1String);
		assertEquals(user2.getConversation(contacts).getMessages().get(0).getBody(), message1String);

		assertEquals(user1.getConversation(contacts).getMessages().get(0).getType(), message1Type);
		assertEquals(user2.getConversation(contacts).getMessages().get(0).getType(), message1Type);

		assertEquals(user1.getConversation(contacts).getMessages().get(0).getAuthor(), user1Name);
		assertEquals(user2.getConversation(contacts).getMessages().get(0).getAuthor(), user1Name);
		
		assertEquals(user1.getConversation(contacts).getMessages().get(1).getBody(), message2String);
		assertEquals(user2.getConversation(contacts).getMessages().get(1).getBody(), message2String);

		assertEquals(user1.getConversation(contacts).getMessages().get(1).getType(), message2Type);
		assertEquals(user2.getConversation(contacts).getMessages().get(1).getType(), message2Type);

		assertEquals(user1.getConversation(contacts).getMessages().get(1).getAuthor(), user2Name);
		assertEquals(user2.getConversation(contacts).getMessages().get(1).getAuthor(), user2Name);
	}

}
