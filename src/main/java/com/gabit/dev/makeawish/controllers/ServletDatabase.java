package com.gabit.dev.makeawish.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "ServletDatabase", value = "/ServletDatabase")
public class ServletDatabase extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter output = response.getWriter();
//        response.setContentType("text/plain");
//
//        ResultSet myResult = null;
//        try {
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee", "root", "");
//            Statement myStatement = myConnection.createStatement();
//            String query = "SELECT * FROM wishes";
//            myResult = myStatement.executeQuery(query);
//
//            while (myResult.next()) {
//                //String title = myResult.getString(2);
//                output.println(myResult);
//            }
//
//            myResult.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Data from database

//        PrintWriter output = response.getWriter();
//
//        output.println("Name: " + request.getParameter("name"));
//        String[] names = {"a", "b", "c"};
//
//        request.setAttribute("users", names);
//
//        RequestDispatcher myDispatcher = request.getRequestDispatcher("/requestResult.jsp");
//
//        myDispatcher.forward(request, response);
    }
}
