package karman.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReaderThread extends Thread {

	private Socket socket;
	private Scanner scanner;
	private ChatGui gui;

	public ReaderThread(Socket socket, ChatGui gui) {
		this.gui = gui;
		this.socket = socket;
		try {
			InputStream in = socket.getInputStream();
			Scanner scanner = new Scanner(in);
			this.scanner = scanner;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		if (scanner.hasNextLine()) {
			String newText = scanner.nextLine();
			gui.addText(newText);

		}
	}

}
