<%@ page import="com.example.messenger.RoomRepository" %>
<%@ page import="com.example.messenger.Room" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/7/2022
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
  Login:<%=session.getAttribute("login")%>
</h1>
<table id="myTable" class="display" border="1" cellpadding="20%">

  <tr>

    <th>Rooms</th>


  </tr>

  <tbody>
    <%

   List<Room> list = RoomRepository.getAllRooms();
   request.setAttribute("myList",list);
   int counter=0;

%>
  <c:forEach items="${requestScope.myList}" var="rooms">


  <tr>

      <td>
        <form action="enterRoom">


          <%request.setAttribute("login",session.getAttribute("login"));%>


          <button value=<c:out value="${rooms.name}"/> name="room">
            <c:out value="${rooms.name}"/>
          </button>

          Password: <input type="password" name="password" required>
          <%counter++;%>

        </form>
      </td>
  </tr>
    <%--        </c:if>--%>
  </c:forEach>

</body>
</html>
