import java.util.*;

public class Notifier {
	ArrayList<String> recipients;
	public Notifier (ArrayList<String> recipients) {
		this.recipients = recipients;
	}
	public void notify (int status, ArrayList<Object> record) {
		ArrayList<String> messages = new ArrayList<String>();
		if ((status & 8) > 0) {
			messages.add("QPM for user " + record.get(0) + " is CRITICAL.");
		}
		else if ((status & 4) > 0) {
			messages.add("QPM for user " + record.get(0) + " is WARNING.");
		}
		if ((status & 2) > 0) {
			messages.add("QPM for endpoint " + record.get(2) + " is CRITICAL.");
		}
		else if ((status & 1) > 0) {
			messages.add("QPM for endpoint " + record.get(2) + " is WARNING.");
		}
		System.out.println(messages.toString());
	}
}
