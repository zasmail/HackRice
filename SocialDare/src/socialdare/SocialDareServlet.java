package socialdare;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import com.google.appengine.api.utils.SystemProperty;

public class SocialDareServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String url = null;
		try {
			if (SystemProperty.environment.value() ==
					SystemProperty.Environment.Value.Production) {
				// Load the class that provides the new "jdbc:google:mysql://" prefix.
				Class.forName("com.mysql.jdbc.GoogleDriver");
				url = "jdbc:google:mysql://serious-flight-471:db1/socialdare?user=root";
			} else {
				// Local MySQL instance to use during development.
				Class.forName("com.mysql.jdbc.Driver");
				url = "jdbc:mysql://127.0.0.1:3306/socialdare?user=root";

				// Alternatively, connect to a Google Cloud SQL instance using:
				// jdbc:mysql://ip-address-of-google-cloud-sql-instance:3306/socialdare?user=root
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		PrintWriter out = resp.getWriter();
		try {
			Connection conn = DriverManager.getConnection(url);
			try {
				String userOne = req.getParameter("userOne");
				String userTwo = req.getParameter("userTwo");
				String judge = req.getParameter("judge");
				String wagerName = req.getParameter("wagerName");
				String rewardOne = req.getParameter("rewardOne");
				String rewardTwo = req.getParameter("rewardTwo");
				String whoWon = req.getParameter("whoWon");
				
				if (userOne == "" || userTwo == "" || judge == "" || wagerName == "" || rewardOne == "" ||
						 rewardTwo == "" || whoWon == "") {
					out.println(
							"<html><head></head><body>You are missing something! Try again! " +
							"Redirecting in 3 seconds...</body></html>");
				} else {
					String statement = "INSERT INTO entries (userOne, userTwo, judge, wagerName, rewardOne, rewardTwo, whoWon) "
							+ "VALUES( ? , ? , ? , ? , ? , ? , ? )";
					PreparedStatement stmt = conn.prepareStatement(statement);
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
						out.println(
								"<html><head></head><body>Success! Redirecting in 3 seconds...</body></html>");
					} else if (success == 0) {
						out.println(
								"<html><head></head><body>Failure! Please try again! " +
								"Redirecting in 3 seconds...</body></html>");
					}
				}
			} finally {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.setHeader("Refresh", "3; url=/socialdare.jsp");
	}
}
