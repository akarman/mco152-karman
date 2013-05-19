package karman.net;

public class MessageFormatter {

	public static String formatMessage(String message, ChatGui gui) {
		String formattedString;
		ChatMembersPanel membersPanel = gui.getMembersPanel();
		if (isJoinMessage(message)) {
			String memberName = message.substring(5);
			formattedString = memberName + " has joined.";
			membersPanel.addMember(memberName);
			if (!isMyself(gui, memberName)) {
				gui.sendAnnounceMessage();
			}

		} else if (isLeaveMessage(message)) {
			String memberName = message.substring(6);
			formattedString = memberName + " has left.";
			membersPanel.removeMember(memberName);
		} else if (isAnnounceMessage(message)) {
			String memberName = message.substring(9);
			formattedString = null;
			if (!isMyself(gui, memberName)) {
				membersPanel.addMember(memberName);
			}
		} else {
			int secondSpace = message.indexOf(" ", 4);
			String name = message.substring(4, secondSpace);
			formattedString = name + ": " + message.substring(secondSpace + 1);
		}

		return formattedString;

	}

	private static boolean isMyself(ChatGui gui, String memberName) {
		return memberName.compareTo(gui.getMemberName()) == 0;
	}

	private static boolean isAnnounceMessage(String message) {
		try {
			return message.substring(0, 9).compareTo("ANNOUNCE ") == 0;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}

	}

	private static boolean isJoinMessage(String message) {
		try {
			return message.substring(0, 5).compareTo("JOIN ") == 0;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	private static boolean isLeaveMessage(String message) {
		try {
			return message.substring(0, 6).compareTo("LEAVE ") == 0;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

}
