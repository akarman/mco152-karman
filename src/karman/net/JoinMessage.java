package karman.net;

public class JoinMessage implements Message {

	private String name;

	@Override
	public boolean isMessage(String message) {
		return message.substring(0, 5).compareTo("JOIN ") == 0;
	}

	@Override
	public void display(ChatGui gui) {
		gui.addText(name + " has joined");

		ChatMembersPanel membersPanel = gui.getMembersPanel();
		membersPanel.addMember(name);

		if (!isMyself(gui)) {
			gui.sendAnnounceMessage();
		}

	}

	private boolean isMyself(ChatGui gui) {
		return name.compareTo(gui.getMemberName()) == 0;
	}

	@Override
	public void setMessage(String message) {
		name = message.substring(5);
	}

}
