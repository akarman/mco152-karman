package karman.net;

import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class ChatMembersPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private DefaultListModel listModel;
	private JList membersList;
	private JScrollPane membersPane;
	private HashMap<String, String> membersMap;

	public ChatMembersPanel() {
		listModel = new DefaultListModel();
		membersList = new JList(listModel);
		membersPane = new JScrollPane(membersList);

		this.setBorder(new EmptyBorder(10, 10, 10, 10));

		this.add(membersPane);
		membersMap = new HashMap<String, String>();
	}

	public void addMember(String member) {
		if (!membersMap.containsKey(member)) {
			membersMap.put(member, member);
			listModel.addElement(member);
		}
	}

	public void removeMember(String member) {
		membersMap.remove(member);
		listModel.removeElement(member);
	}

}
