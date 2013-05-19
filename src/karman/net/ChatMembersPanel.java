package karman.net;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ChatMembersPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private DefaultListModel listModel;
	private JList membersList;
	private JScrollPane membersPane;

	public ChatMembersPanel() {
		listModel = new DefaultListModel();
		membersList = new JList(listModel);
		membersPane = new JScrollPane(membersList);
		this.add(membersPane);
	}

	public void addMember(String member) {
		listModel.add(listModel.getSize(), member);
	}

	public void removeMember(String member) {
		listModel.removeElement(member);
	}

}
