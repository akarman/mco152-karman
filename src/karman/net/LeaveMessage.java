package karman.net;

public class LeaveMessage implements Message {

	private String name;

	@Override
	public boolean isMessage(String message) {
		return message.substring(0, 6).compareTo("LEAVE ") == 0;
	}

	@Override
	public void display(ChatGui gui) {
		ChatMembersPanel membersPanel = gui.getMembersPanel();
		gui.addText(name + " has left.");
		membersPanel.removeMember(name);
	}

	@Override
	public void setMessage(String message) {
		name = message.substring(6);
	}

}
