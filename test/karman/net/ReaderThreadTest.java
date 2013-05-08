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

		ByteArrayInputStream in = new ByteArrayInputStream(
				"JOIN Karman\n".getBytes());

		Mockito.when(socket.getInputStream()).thenReturn(in);

		ReaderThread thread = new ReaderThread(socket, gui);

		thread.run();

		// verify that on a certain instance, a certain method with certain
		// params was called x times
		Mockito.verify(gui, times(1)).addText("Karman has joined."); // or
																		// Mockito.anyString();

	}

}
