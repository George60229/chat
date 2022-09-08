<%@ page import="com.example.messenger.RoomRepository" %>
<%@ page import="com.example.messenger.Mail" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/7/2022
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Room</title>
</head>
<body>
<h1>
    Login:<%=session.getAttribute("login")%>
    <br><br>
    Room:<%=session.getAttribute("room")%>

    <form action="writeMessage" method="post">
        Enter message:<input type="text" name="message">

        <button>Send message</button>
    </form>
</h1>
<table id="myTable" class="display" border="1" cellpadding="20%">

    <tr>

        <th>Text</th>

        <th>Author</th>


    </tr>

    <tbody>
        <%

   List<Mail> list = RoomRepository.getAllMails();
   request.setAttribute("myList",list);
   int counter=0;

%>
    <c:forEach items="${requestScope.myList}" var="mail">


    <tr>

        <td>
                    <c:out value="${mail.text}"/>

        </td>
        <td>
            <c:out value="${mail.author}"/>
        </td>
    </tr>
        <%--        </c:if>--%>
    </c:forEach>
</body>
</html>
