package guestbook;

public class MonetaryWager extends Wager {
	
	private int value;
	@Override
	public void setValue(Object obj) {
		value = Integer.parseInt((String)obj);
	}
	@Override
	public Object getValue() {
		return value;
	}

}
