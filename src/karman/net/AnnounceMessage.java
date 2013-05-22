package karman.net;

public class AnnounceMessage implements Message {

	private String name;

	@Override
	public boolean isMessage(String message) {
		if (message.length() > 9) {
			return message.substring(0, 9).compareTo("ANNOUNCE ") == 0;
		} else
			return false;

	}

	@Override
	public void display(ChatGui gui) {
		ChatMembersPanel membersPanel = gui.getMembersPanel();
		if (!isMyself(gui)) {
			membersPanel.addMember(name);
		}
	}

	@Override
	public void setMessage(String message) {
		name = message.substring(9);

	}

	private boolean isMyself(ChatGui gui) {
		return name.compareTo(gui.getMemberName()) == 0;
	}

}
