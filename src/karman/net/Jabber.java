package karman.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Jabber {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		Socket socket = new Socket("localhost", 8080);
		OutputStream out = socket.getOutputStream();
		int lineNumber = 1;
		String message;

		while (lineNumber < 1000) {
			message = "This is line #" + lineNumber++ + "\n";
			out.write(message.getBytes());
			out.flush();
			Thread.sleep(1000);
		}
		socket.close();
	}

}
