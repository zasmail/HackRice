package guestbook;

public class EmotionalWager extends Wager {

	private String value;
	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Object obj) {
		value = obj.toString();
	}

}
