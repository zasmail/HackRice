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
    "SELECT userOne, userTwo, judge, wagerName, rewardOne, rewardTwo, whoWon FROM entries");
%>

<table style="border: 1px solid black">
<tbody>
<tr>
<th style="background-color: #CCFFCC; margin: 5px">User 1</th>
<th style="background-color: #CCFFCC; margin: 5px">User 2</th>
<th style="background-color: #CCFFCC; margin: 5px">Judge</th>
<th style="background-color: #CCFFCC; margin: 5px">Wager Name</th>
<th style="background-color: #CCFFCC; margin: 5px">Reward 1</th>
<th style="background-color: #CCFFCC; margin: 5px">Reward 2</th>
<th style="background-color: #CCFFCC; margin: 5px">Who Won</th>
</tr>

<%
while (rs.next()) {
    String userOne = rs.getString("userOne");
    String userTwo = rs.getString("userTwo");
    String judge = rs.getString("judge");
    String wagerName = rs.getString("wagerName");
    String rewardOne = rs.getString("rewardOne");
    String rewardTwo = rs.getString("rewardTwo");
    String whoWon = rs.getString("whoWon");
 %>
 
<tr>
<td><%= userOne %></td>
<td><%= userTwo %></td>
<td><%= judge %></td>
<td><%= wagerName %></td>
<td><%= rewardOne %></td>
<td><%= rewardTwo %></td>
<td><%= whoWon %></td>
</tr>
<%
}
conn.close();
%>

</tbody>
</table>
<br />


<p><strong>Enter a wager!</strong></p>
<form action="/socialdare" method="post">
    <div>Party 1: <input type="text" name="userOne"></input></div>
    <div>Party 2: <input type="text" name="userTwo"></input></div>
    <div>Judge: <input type="text" name="judge"></input></div>
    <div>Wager Name: <input type="text" name="wagerName"></input></div>
    <div>Reward 1: <input type="text" name="rewardOne"></input></div>
    <div>Reward 2: <input type="text" name="rewardTwo"></input></div>
    <div>Who Won: <input type="text" name="whoWon"></input></div>
    <div><input type="submit" value="Post Wager" /></div>
    <input type="hidden" name="socialdareName" />
  </form>
  </body>
</html>