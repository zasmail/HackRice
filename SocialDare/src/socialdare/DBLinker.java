package socialdare;

import java.sql.*;
import java.util.ArrayList;

import org.datanucleus.store.connection.ConnectionManager;

public class DBLinker {
	
	private String myUrl;
	private Connection myConn = null;
	
	public DBLinker(){
		this("");
	}
	public DBLinker(String url){
		myUrl = url;
	}
	public void setConnection(Connection conn){
		myConn = conn;
	}
	public void setConnection() throws SQLException{
		if(myConn != null){
			myConn = DriverManager.getConnection(myUrl);
		}
	}
	
	public ArrayList<String> getWagersForUser(String name) throws SQLException{
		ArrayList<String> outList = new ArrayList<String>();
		ResultSet rs = myConn.createStatement().executeQuery(
				"SELECT wagerName FROM entries WHERE userOne=\'" + name + "\' UNION "
						+ "SELECT wagerName FROM entries WHERE userTwo =\'" + name + "\' "
								+ "ORDER BY wagerName");
		while(rs.next()){
			outList.add(rs.getString(1));
		}
		return outList;
	}
	
	

}
