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
@WebServlet("/signInUser")
public class LoginUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String myLogin=request.getParameter("login");
        String myPassword=request.getParameter("password");
        myPassword= String.valueOf(myPassword.hashCode());


        session.setAttribute("login",myLogin );
        session.setAttribute("user_password",myPassword);


        boolean res;
        User myUser=new User();
        myUser.setLogin(myLogin);
        myUser.setPassword(myPassword);



        try {
            res = UserRepository.checkPass(myUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (res) {
            response.sendRedirect("account.jsp");
        }
        else{
            response.sendError(404,"something wrong");
        }
        out.close();
    }

}
