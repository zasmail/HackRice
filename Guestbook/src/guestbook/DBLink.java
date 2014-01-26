package guestbook;
import java.util.ArrayList;
import java.sql.*;

public class DBLink {
	Connection myConn;
	public DBLink(String url) throws SQLException{
		myConn = DriverManager.getConnection(url);
	}
	
	public ArrayList<String> getUsersInWager(int wagerID) throws SQLException{
		ArrayList<String>outList = new ArrayList<String>();
		ResultSet rs = myConn.createStatement().executeQuery("SELECT userOne, userTwo WHERE wagerID=" + wagerID);
		while(rs.next()){
			outList.add(rs.getString("userOne"));
			outList.add(rs.getString("userTwo"));
		}
		return outList;
	}
	
	/*
	 * gets the wagerID of the wager the user has won, if any, otherwise returns -1
	 */
	public int getWhichWagerWon(String user) throws SQLException{
		int wagerID;
		ResultSet rs = myConn.createStatement().executeQuery("SELECT wagerID WHERE whoWon=" + user + " UNION "
				+ "SELECT wagerID WHERE whoWon="+ user);
		if(rs.next()){
			wagerID = rs.getInt(1);
			return wagerID;
		}
		return -1;
	}
	
	/*
	 * adds a wager to the database given the arguments userOne, userTwo, judge, wagerName, rewardOne, 
	 * rewardTwo, and whoWon.  Returns true if successful, otherwise false
	 */
	public boolean addWager(String userOne, String userTwo, String judge, String wagerName, String rewardOne, String rewardTwo,
			String whoWon) throws SQLException{
		String statement = "INSERT INTO entries (userOne, userTwo, judge, wagerName, rewardOne, rewardTwo, whoWon) "
				+ "VALUES( ? , ? , ? , ? , ?, ?, ?)";
		PreparedStatement stmt = myConn.prepareStatement(statement);
		stmt.setString(1, userOne);
		stmt.setString(2, userTwo);
		stmt.setString(3, judge);
		stmt.setString(4, wagerName);
		stmt.setString(5, rewardOne);
		stmt.setString(6, rewardTwo);
		stmt.setString(7, whoWon);
		int success = 2;
		success = stmt.executeUpdate();
		if (success == 1) {
			return true;
		}
		return false;
	}
	
	
}
