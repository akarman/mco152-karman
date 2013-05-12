package karman.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriterThread extends Thread {

	private LinkedBlockingQueue<String> messages;
	private LinkedList<OutputStream> outs;
	public final static Logger logger = Logger.getLogger(WriterThread.class
			.getName());

	public WriterThread() {

		this.messages = new LinkedBlockingQueue<String>();
		this.outs = new LinkedList<OutputStream>();

	}

	public void addMessage(String message) {
		logger.log(Level.INFO, "Received message from client - " + message);
		messages.add(message);
	}

	public void writeMessage() throws InterruptedException {
		String message = messages.take();
		Iterator<OutputStream> iter = outs.iterator();
		OutputStream outputStream;
		while (iter.hasNext()) {
			outputStream = iter.next();
			
			try {
				logger.log(Level.INFO, "Writing out first message in queue - "
						+ message);
				writeToStream(message, outputStream);
			} catch (IOException e) {
				iter.remove();
			}
		}

	}

	private void writeToStream(String message, OutputStream outputStream)
			throws IOException {
		outputStream.write(message.getBytes());
		outputStream.write("\n".getBytes());
		outputStream.flush();
	}

	public void addSocket(Socket socket) throws IOException {
		OutputStream out = socket.getOutputStream();
		outs.add(out);
		logger.log(Level.INFO, "New socket added");
	}

	public void addSocket(OutputStream out) {
		outs.add(out);
	}

	public void run() {
		while (true) {
			try {

				writeMessage();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
