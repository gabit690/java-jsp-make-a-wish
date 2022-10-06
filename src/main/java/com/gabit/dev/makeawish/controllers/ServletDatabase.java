package com.gabit.dev.makeawish.controllers;

import com.gabit.dev.makeawish.models.OperationResult;
import com.gabit.dev.makeawish.models.Wish;
import com.gabit.dev.makeawish.models.WishRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ServletDatabase", value = "/ServletDatabase")
public class ServletDatabase extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private WishRepository repository;

    public ServletDatabase() {
        this.repository = new WishRepository();
    }

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

        // Get info from Form
        String username = request.getParameter("username");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // Save on Database

        Wish newWish = new Wish(username, title, content);
        this.repository.create(newWish);

        // Redirect response to JSP
        request.setAttribute("operationType", OperationResult.CREATED);
        request.setAttribute("operationMessage", "Your wish was " + OperationResult.CREATED + " correctly!");
        try {
            request.getRequestDispatcher("requestResult.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
