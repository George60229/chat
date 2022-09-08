package com.example.messenger.servlets;

import com.example.messenger.Room;
import com.example.messenger.RoomRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/enterRoom")
public class EnterRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();

        String myRoomName=request.getParameter("room");
        String myPassword=request.getParameter("password");

        myPassword= String.valueOf(myPassword.hashCode());





        boolean res;
        Room myRoom=new Room();
        myRoom.setName(myRoomName);
        myRoom.setPassword(myPassword);



        try {
            res = RoomRepository.checkPass(myRoom);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (res) {
            session.setAttribute("room",myRoom.getName());
            response.sendRedirect("room.jsp");
        }
        else{
            response.sendError(404,"something wrong");
        }
        out.close();
    }

}

