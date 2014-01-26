<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.google.appengine.api.utils.SystemProperty" %>

<html>
  <body>

<%
String url = null;
if (SystemProperty.environment.value() ==
    SystemProperty.Environment.Value.Production) {
  // Load the class that provides the new "jdbc:google:mysql://" prefix.
  Class.forName("com.mysql.jdbc.GoogleDriver");
  url = "jdbc:google:mysql://serious-flight-471:db1/guestbook?user=root";
} else {
  // Local MySQL instance to use during development.
  Class.forName("com.mysql.jdbc.Driver");
  url = "jdbc:mysql://127.0.0.1:3306/guestbook?user=root";
}

Connection conn = DriverManager.getConnection(url);
ResultSet rs = conn.createStatement().executeQuery(
    "SELECT username, userID, typeOfWager, reward, isJudge FROM entries");
%>

<table style="border: 1px solid black">
<tbody>
<tr>
<th width="35%" style="background-color: #CCFFCC; margin: 5px">Name</th>
<th style="background-color: #CCFFCC; margin: 5px">userID</th>
<th style="background-color: #CCFFCC; margin: 5px">Type of Bet</th>
<th style="background-color: #CCFFCC; margin: 5px">reward</th>
<th style="background-color: #CCFFCC; margin: 5px">isJudge</th>
</tr>

<%
while (rs.next()) {
    String username = rs.getString("username");
    int userID = rs.getInt("userID");
    String typeOfWager = rs.getString("typeOfWager");
    String reward = rs.getString("reward");
    boolean isJudge = rs.getBoolean("isJudge");
 %>
<tr>
<td><%= username %></td>
<td><%= userID %></td>
<td><%= typeOfWager %></td>
<td><%= reward %></td>
<td><%= isJudge %></td>
</tr>
<%
}
conn.close();
%>

</tbody>
</table>
<br />
No more messages!
<p><strong>Sign the guestbook!</strong></p>
<form action="/sign" method="post">
    <div>First Name: <input type="text" name="fname"></input></div>
    <div>Message:
    <br /><textarea name="content" rows="3" cols="60"></textarea>
    </div>
    <div><input type="submit" value="Post Greeting" /></div>
    <input type="hidden" name="guestbookName" />
  </form>
  </body>
</html>