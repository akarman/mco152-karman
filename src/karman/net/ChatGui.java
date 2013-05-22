package karman.net;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatGui extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	private JButton sendButton;
	private JTextField composeField;
	private JTextArea chatTextArea;
	private JPanel buttonPanel;
	private Socket socket;
	private OutputStream out;
	private String memberName;
	private JScrollPane scroll;

	private ChatMembersPanel membersPanel;

	public ChatGui() {

		memberName = JOptionPane.showInputDialog("Enter your name:");

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
		chatTextArea.setEditable(false);
		chatTextArea.setLineWrap(true);

		scroll = new JScrollPane(chatTextArea);

		this.membersPanel = new ChatMembersPanel();

		this.add(scroll, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(membersPanel, BorderLayout.EAST);
		addWindowListener(this);

		sendJoinMessage();
		setVisible(true);
	}

	private void sendJoinMessage() {
		try {
			out.write("JOIN ".getBytes());
			out.write(memberName.getBytes());
			out.write("\n".getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendAnnounceMessage() {
		try {
			out.write("ANNOUNCE ".getBytes());
			out.write(memberName.getBytes());
			out.write("\n".getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setUpSocket() {
		try {
			this.socket = new Socket("192.168.117.126", 8080);
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

	public ChatMembersPanel getMembersPanel() {
		return membersPanel;
	}

	public String getMemberName() {
		return memberName;
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			JButton theButton = (JButton) ae.getSource();

			if (theButton.equals(sendButton)) {
				String newText = composeField.getText();
				composeField.setText("");
				try {
					String message = "SAY " + memberName + " " + newText + "\n";
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
		String message = "LEAVE " + memberName + "\n";
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
