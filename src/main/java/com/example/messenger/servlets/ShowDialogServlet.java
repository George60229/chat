package com.example.messenger.servlets;

import com.example.messenger.Mail;
import com.example.messenger.RoomRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showDialog")
public class ShowDialogServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<Mail> list = RoomRepository.getAllMails();

        for (Mail myMail : list) {

            out.println("<html><body>");
            out.println("<h1>" + myMail + "</h1>");
            out.println("</body></html>");


        }
        out.close();
    }
}


