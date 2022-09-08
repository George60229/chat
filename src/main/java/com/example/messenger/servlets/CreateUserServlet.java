package com.example.messenger.servlets;

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

@WebServlet("/signUpUser")
public class CreateUserServlet extends HttpServlet {

    //todo httpSession

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String myLogin=request.getParameter("login");
        String myPassword=request.getParameter("password");
        myPassword= String.valueOf(myPassword.hashCode());


        session.setAttribute("login",myLogin );
        session.setAttribute("password",myPassword);
        int res=0;
        User myUser=new User();
        myUser.setLogin((String) session.getAttribute("login"));
        myUser.setPassword((String) session.getAttribute("password"));



            try {
                res = UserRepository.save(myUser);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        if (res > 0) {
            response.sendRedirect("index.jsp");
        }
        else{
            response.sendError(404,"User is not created");
        }
        out.close();
    }

}
