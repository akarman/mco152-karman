package karman.net;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatGui extends JFrame implements WindowListener {
	private JButton sendButton;
	private JTextField composeField;
	private JTextArea chatTextArea;
	private JPanel buttonPanel;
	private Socket socket;
	private OutputStream out;
	private String name;

	public ChatGui() {

		name = JOptionPane.showInputDialog("Enter your name:");

		setUpSocket();
		sendJoinMessage();

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
		addWindowListener(this);

		setVisible(true);
	}

	private void sendJoinMessage() {
		try {
			out.write("JOIN ".getBytes());
			out.write(name.getBytes());
			out.write("\n".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setUpSocket() {
		try {
			this.socket = new Socket("192.168.117.105", 8080);
			out = socket.getOutputStream();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
				composeField.setText("");
				try {
					String message = "SAY " + name + " " + newText + "\n";
					out.write(message.getBytes());
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

	}

	@Override
	public void windowActivated(WindowEvent arg0) {

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		String message = "LEAVE " + name + "\n";
		try {
			out.write(message.getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {

	}

	@Override
	public void windowIconified(WindowEvent arg0) {

	}

	@Override
	public void windowOpened(WindowEvent arg0) {

	}

}
