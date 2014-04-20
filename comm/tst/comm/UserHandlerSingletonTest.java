package comm;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import Handlers.UserHandler;

public class UserHandlerSingletonTest {

	@Test
	public void test() {
		UserHandler handler1 = UserHandler.getInstance();
		UserHandler handler2 = UserHandler.getInstance();
		assertEquals(handler1, handler2);
	}

}
