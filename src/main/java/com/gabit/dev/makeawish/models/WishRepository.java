package com.gabit.dev.makeawish.models;

import java.sql.*;
import java.util.List;

public class WishRepository {

    private Connection myConnection;

    public WishRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create(Wish wish) {
        //Todo: Save wish in Database

        int myResult = 0;

        try {

            PreparedStatement myStatement = myConnection.prepareStatement("INSERT INTO wishes VALUES (DEFAULT, ?, ?, ?, DEFAULT, DEFAULT)");

            myStatement.setString(1, wish.getUsername());
            myStatement.setString(2, wish.getTitle());
            myStatement.setString(3, wish.getContent());

            myResult = myStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Wish> getAllWishes() {
        return null;
    }

    public void incrementScore(Long id) {
        // Todo: Increment in one the wish' score with id
    }

    public void delete(Long id) {
        //Todo: Set to true the column deleted for the wish with id entered
    }
}
