package karman.net;

public class MessageFormatter {

	public static String formatMessage(String message) {
		String formattedString;
		if (isJoinMessage(message)) {
			formattedString = message.substring(5) + " has joined.";
		} else if (isLeaveMessage(message)) {
			formattedString = message.substring(6) + " has left.";
		} else {
			int secondSpace = message.indexOf(" ", 4);
			String name = message.substring(4, secondSpace);
			formattedString = name + ": " + message.substring(secondSpace + 1);
		}

		return formattedString;

	}

	private static boolean isJoinMessage(String message) {
		return message.substring(0, 5).compareTo("JOIN ") == 0;
	}

	private static boolean isLeaveMessage(String message) {
		return message.substring(0, 6).compareTo("LEAVE ") == 0;
	}

}
