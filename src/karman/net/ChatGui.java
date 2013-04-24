package karman.net;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatGui extends JFrame {
	private JButton sendButton;
	private JTextField composeField;
	private JTextArea chatTextArea;
	private JPanel buttonPanel;
	private Socket socket;
	private OutputStream out;

	public ChatGui() {

		setUpSocket();

		this.setSize(400, 400);
		this.setTitle("Chat Buddy");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));

		this.sendButton = new JButton("SEND");
		this.composeField = new JTextField();

		buttonPanel.add(composeField);
		buttonPanel.add(sendButton);
		sendButton.addActionListener(new ButtonListener());

		this.chatTextArea = new JTextArea();
		chatTextArea.setMinimumSize(new Dimension(getWidth(), 350));
		chatTextArea.setEditable(false);
		chatTextArea.setLineWrap(true);

		this.add(chatTextArea, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	private void setUpSocket() {
		try {
			this.socket = new Socket("192.168.117.195", 1025);
			out = socket.getOutputStream();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addText(String newText) {
		if (chatTextArea.getText().equals("")) {
			chatTextArea.setText(newText);
		} else {
			chatTextArea.setText(chatTextArea.getText() + "\n" + newText);
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public static void main(String[] args) {
		//can initialize Socket here diff for client and server and pass into ChatGui constructor
		ChatGui gui = new ChatGui();
		ReaderThread reader = new ReaderThread(gui.getSocket(), gui);
		reader.start();

	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			JButton theButton = (JButton) ae.getSource();

			if (theButton.equals(sendButton)) {
				String newText = composeField.getText();
				if (newText != "") {
					addText(newText);
				}
				composeField.setText("");
				try {
					newText+="\n";
					out.write(newText.getBytes());
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

}
