package com.example.messenger.servlets;

import com.example.messenger.Room;
import com.example.messenger.RoomRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/createRoom")
public class CreateRoomServlet extends HttpServlet {

    //todo httpSession

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        String myName=request.getParameter("name");
        String myPassword=request.getParameter("password");
        myPassword= String.valueOf(myPassword.hashCode());



        int res=0;
        Room myRoom=new Room();
        myRoom.setName(myName);
        myRoom.setPassword(myPassword);



        try {

            res = RoomRepository.save(myRoom);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (res > 0) {
            response.sendRedirect("index.jsp");
        }
        else{
            response.sendError(404,"Room is not created");
        }
        out.close();
    }

}

