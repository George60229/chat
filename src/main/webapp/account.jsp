<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/7/2022
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="styles/styles.less">
</head>
<body>
<h1>Login:<%=session.getAttribute("login")%></h1>
<form method="post" action="createRoom">
    Name room:<input type="text" name="name">
    <br><br> <br><br>
    Password: <input type="password" name="password">
    <br><br> <br><br>

    <button name="button">Create Room</button>



</form>

<form action="list_rooms.jsp">
    <button name="button">Enter Room</button>
</form>
</body>
</html>
