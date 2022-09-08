package com.example.messenger.servlets;

import com.example.messenger.Mail;
import com.example.messenger.RoomRepository;
import com.example.messenger.User;
import com.example.messenger.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
//todo it
@WebServlet("/writeMessage")
public class WriteMessageServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

HttpSession session=request.getSession();
        String myMessage=request.getParameter("message");
        String myLogin= (String) session.getAttribute("login");
        String myRoom= (String) session.getAttribute("room");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        int res=0;
        Mail myMail=new Mail();
        myMail.setText(myMessage);
        myMail.setAuthor(myLogin);
        myMail.setRoom(myRoom);


        try {
            res = RoomRepository.write(myMail);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (res > 0) {
            response.sendRedirect("room.jsp");
        }
        else{
            response.sendError(404,"Wrong message");
        }
        out.close();
    }

}
