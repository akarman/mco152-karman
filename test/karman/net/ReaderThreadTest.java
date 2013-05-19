package karman.net;

import static org.mockito.Mockito.times;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Socket;

import org.junit.Test;
import org.mockito.Mockito;

public class ReaderThreadTest {

	@Test
	public void testReadAndUpdate() throws IOException {

		// mockito fools java into thinking that it really has instances of the
		// classes.
		// mocks return default ex. if returns object, returns null
		// ex. if returns boolean, returns false
		// can tell mocks to do certain things

		Socket socket = Mockito.mock(Socket.class);
		ChatGui gui = Mockito.mock(ChatGui.class);
		ChatMembersPanel membersPanel = Mockito.mock(ChatMembersPanel.class);
		Mockito.when(gui.getMembersPanel()).thenReturn(membersPanel);
		Mockito.when(gui.getMemberName()).thenReturn("Stein");

		ByteArrayInputStream in = new ByteArrayInputStream(
				"JOIN Karman\n".getBytes());

		Mockito.when(socket.getInputStream()).thenReturn(in);

		ReaderThread thread = new ReaderThread(socket, gui);

		thread.run();

		// verify that on a certain instance, a certain method with certain
		// params was called x times
		Mockito.verify(gui, times(1)).addText("Karman has joined."); // or
																		// Mockito.anyString();
		// an announce message should be sent
		Mockito.verify(gui, times(1)).sendAnnounceMessage();
	}

	@Test
	public void testReadAndNoUpdate() throws IOException {

		Socket socket = Mockito.mock(Socket.class);
		ChatGui gui = Mockito.mock(ChatGui.class);
		ChatMembersPanel membersPanel = Mockito.mock(ChatMembersPanel.class);

		Mockito.when(gui.getMembersPanel()).thenReturn(membersPanel);
		Mockito.when(gui.getMemberName()).thenReturn("Karman");

		ByteArrayInputStream in = new ByteArrayInputStream(
				"ANNOUNCE Karman\n".getBytes());

		Mockito.when(socket.getInputStream()).thenReturn(in);

		ReaderThread thread = new ReaderThread(socket, gui);

		thread.run();

		Mockito.verify(gui, times(0)).addText(Mockito.anyString());
		// with an announce message, no text should be added

	}

}
