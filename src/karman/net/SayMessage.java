package karman.net;

public class SayMessage implements Message {

	private String name;
	private String text;

	@Override
	public boolean isMessage(String message) {
		return message.substring(0, 4).compareTo("SAY ") == 0;
	}

	@Override
	public void display(ChatGui gui) {
		gui.addText(name + ": " + text);
	}

	@Override
	public void setMessage(String message) {
		int secondSpace = message.indexOf(" ", 4);
		name = message.substring(4, secondSpace);
		text = message.substring(secondSpace + 1);
	}

}
