package karman.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer {

	public final static Logger logger = Logger.getLogger(ChatServer.class
			.getName());

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		WriterThread writer = new WriterThread();
		writer.start();

		Socket socket;
		// instead of while(true) which is an infinite loop and can easily go
		// wrong
		while ((socket = server.accept()) != null) {
			logger.log(Level.INFO, "Socket accepted");

			ClientHandler aClientHandler = new ClientHandler(socket, writer);
			writer.addSocket(socket);
			aClientHandler.start();

		}
	}

}
