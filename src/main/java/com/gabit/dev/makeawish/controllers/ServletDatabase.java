package com.gabit.dev.makeawish.controllers;

import com.gabit.dev.makeawish.models.OperationResult;
import com.gabit.dev.makeawish.models.Wish;
import com.gabit.dev.makeawish.models.WishRepository;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletDatabase", value = "/ServletDatabase")
public class ServletDatabase extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private WishRepository repository;

    public ServletDatabase() {
        this.repository = new WishRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String operation = request.getParameter("operation");
        if (operation == null) {
            this.showWishes(request, response);
        } else {
            HttpSession session = request.getSession();
            if (operation.equals("update")) {
                this.repository.incrementScore((Integer.parseInt(request.getParameter("id"))));
                session.setAttribute("operationType", OperationResult.UPDATED);
                session.setAttribute("operationMessage", "Your wish was " + OperationResult.UPDATED + " correctly!");
            } else {
                this.repository.delete((Integer.parseInt(request.getParameter("id"))));
                session.setAttribute("operationType", OperationResult.DELETED);
                session.setAttribute("operationMessage", "Your wish was " + OperationResult.DELETED + " correctly!");
            }
            try {
                response.sendRedirect("/requestResult.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void showWishes(HttpServletRequest request, HttpServletResponse response) {
        List<Wish> wishes = this.repository.getAllWishes();
        response.setContentType("text/jsp");
        HttpSession session = request.getSession();
        session.setAttribute("wishes", wishes);
        try {
            response.sendRedirect("/wishes.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

        if (!request.getParameter("operation").equals("create")) {
            return;
        }

        // Get info from Form
        String username = request.getParameter("username");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // Save on Database
        Wish newWish = new Wish(username, title, content);
        this.repository.create(newWish);

        // Redirect response to JSP
        HttpSession session = request.getSession();
        session.setAttribute("operationType", OperationResult.CREATED);
        session.setAttribute("operationMessage", "Your wish was " + OperationResult.CREATED + " correctly!");
        try {
            response.sendRedirect("/requestResult.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
