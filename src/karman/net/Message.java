package karman.net;

public interface Message {

	public boolean isMessage(String message);

	public void display(ChatGui gui);

	public void setMessage(String message);

}
