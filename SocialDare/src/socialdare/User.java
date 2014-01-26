package socialdare;

import java.sql.SQLException;
import java.util.ArrayList;

public class User {
	
	private String myName;
	private ArrayList<String> myWagers;
	private ArrayList<Integer> myWagerIDs;
	
	public User(){
		this("");
	}
	
	public User(String myName){
		this.myName = myName;
	}
	
	public void getMyWagers(DBLinker link) throws SQLException{
		myWagers = link.getWagersForUser(myName);
	}
	
	public void getMyWagerIDs(DBLinker link) throws SQLException{
		myWagerIDs = link.getWagerIDsForUser(myName);
	}
	
}
