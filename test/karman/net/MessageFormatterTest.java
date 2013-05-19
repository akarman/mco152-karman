package karman.net;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MessageFormatterTest {
	ChatGui gui;
	ChatMembersPanel membersPanel;

	@Before
	public void setUp() {
		gui = Mockito.mock(ChatGui.class);
		membersPanel = Mockito.mock(ChatMembersPanel.class);

		Mockito.when(gui.getMembersPanel()).thenReturn(membersPanel);
		Mockito.when(gui.getMemberName()).thenReturn("Karman");
	}

	@Test
	public void testJoin() {
		String joinMessage = "JOIN Karman";
		String formattedMssg = MessageFormatter.formatMessage(joinMessage, gui);
		assertTrue("Karman has joined.".compareTo(formattedMssg) == 0);
	}

	@Test
	public void testSay() {
		String joinMessage = "SAY Karman hello hi ";
		String formattedMssg = MessageFormatter.formatMessage(joinMessage, gui);
		assertTrue("Karman: hello hi ".compareTo(formattedMssg) == 0);
	}

	@Test
	public void testLeave() {
		String joinMessage = "LEAVE Karman";
		String formattedMssg = MessageFormatter.formatMessage(joinMessage, gui);
		assertTrue("Karman has left.".compareTo(formattedMssg) == 0);
	}

	@Test
	public void testAnnounce() {
		String announceMessage = "ANNOUNCE Stein";
		String formattedMssg = MessageFormatter.formatMessage(announceMessage,
				gui);
		assertTrue(formattedMssg == null);
	}

}
