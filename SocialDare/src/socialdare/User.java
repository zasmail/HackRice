package socialdare;

import java.sql.SQLException;
import java.util.ArrayList;

public class User {
	
	private String myName;
	private ArrayList<String> myWagers;
	
	public User(){
		this("");
	}
	
	public User(String myName){
		this.myName = myName;
	}
	
	public void getMyWagers(DBLinker link) throws SQLException{
		myWagers = link.getWagersForUser(myName);
	}
	
	
}
