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
	
	public int getWhichWagerWon(String user) throws SQLException{
		int wagerID;
		ResultSet rs = myConn.createStatement().executeQuery("SELECT wagerID WHERE whoWon=" + user + " UNION "
				+ "SELECT wagerID WHERE whoWon="+ user);
		wagerID = rs.getInt(1);
		return wagerID;
	}
}
