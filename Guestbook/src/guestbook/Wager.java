package guestbook;

public abstract class Wager {
	private String wagerName;
	private String fromUser;
	
	public Wager(){
		
	}
	public Wager(String wagerName, String fromUser){
		this.wagerName = wagerName;
		this.fromUser = fromUser;
	}
	public String getFromUser(){
		return fromUser;
	}
	public String getWagerName(){
		return wagerName;
	}
	
	public abstract Object getValue();
	public abstract void setValue(Object obj);
}
