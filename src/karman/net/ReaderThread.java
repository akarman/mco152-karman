package karman.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReaderThread extends Thread {

	private Scanner scanner;
	private ChatGui gui;
	private Message[] messages;

	public ReaderThread(Socket socket, ChatGui gui) {
		this.gui = gui;
		try {
			InputStream in = socket.getInputStream();
			Scanner scanner = new Scanner(in);
			this.scanner = scanner;
		} catch (IOException e) {
			e.printStackTrace();
		}

		messages = new Message[] { new JoinMessage(), new SayMessage(),
				new AnnounceMessage(), new LeaveMessage() };

	}

	@Override
	public void run() {
		while (scanner.hasNextLine()) {
			String message = scanner.nextLine();

			for (Message m : messages) {
				if (m.isMessage(message)) {
					m.setMessage(message);
					m.display(gui);
				}
			}
		}
	}

}
