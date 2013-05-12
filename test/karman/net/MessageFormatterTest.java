package karman.net;

import static org.junit.Assert.*;

import org.junit.Test;

public class MessageFormatterTest {

	@Test
	public void testJoin() {
		String joinMessage = "JOIN Karman";
		String formattedMssg = MessageFormatter.formatMessage(joinMessage);
		assertTrue("Karman has joined.".compareTo(formattedMssg) == 0);
	}

	@Test
	public void testSay() {
		String joinMessage = "SAY Karman hello hi ";
		String formattedMssg = MessageFormatter.formatMessage(joinMessage);
		assertTrue("Karman: hello hi ".compareTo(formattedMssg) == 0);
	}

	@Test
	public void testLeave() {
		String joinMessage = "LEAVE Karman";
		String formattedMssg = MessageFormatter.formatMessage(joinMessage);
		assertTrue("Karman has left.".compareTo(formattedMssg) == 0);
	}

}
