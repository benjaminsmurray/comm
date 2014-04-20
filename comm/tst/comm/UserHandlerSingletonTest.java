package comm;

import static org.junit.Assert.*;
import handlers.UserHandler;
import junit.framework.Assert;

import org.junit.Test;

public class UserHandlerSingletonTest {

	@Test
	public void test() {
		UserHandler handler1 = UserHandler.getInstance();
		UserHandler handler2 = UserHandler.getInstance();
		assertEquals(handler1, handler2);
	}

}
