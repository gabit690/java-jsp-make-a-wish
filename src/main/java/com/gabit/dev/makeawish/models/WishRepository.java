package com.gabit.dev.makeawish.models;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class WishRepository {

    private Connection myConnection;

    public WishRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.myConnection = DriverManager.getConnection(
                    "jdbc:mysql://us-east.connect.psdb.cloud/makeawish?sslMode=VERIFY_IDENTITY",
                    "zkmo32pyk0sbwfb0hdnk",
                    "pscale_pw_A8knPUS7QPbJngTrtnWdgPZoKCQZ0wF6dv52DmAOl4S"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create(Wish wish) {
        try {
            PreparedStatement myStatement = this.myConnection.prepareStatement("INSERT INTO wishes VALUES (DEFAULT, ?, ?, ?, DEFAULT, DEFAULT)");
            myStatement.setString(1, wish.getUsername());
            myStatement.setString(2, wish.getTitle());
            myStatement.setString(3, wish.getContent());
            myStatement.executeUpdate();
            myStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Wish> getAllWishes() {
        List<Wish> wishes = new LinkedList<>();
        try {
            Statement myStatement = this.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM wishes WHERE deleted = false ORDER BY score DESC");
            while (myResult.next()) {
                Wish wishSaved = new Wish(
                        myResult.getInt(1),
                        myResult.getString(2),
                        myResult.getString(3),
                        myResult.getString(4),
                        myResult.getInt(5),
                        myResult.getBoolean(6));
                wishes.add(wishSaved);
            }
            myResult.close();
            myStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wishes;
    }

    public void incrementScore(int id) {
        try {
            PreparedStatement myStatement = this.myConnection.prepareStatement("UPDATE wishes SET score = score + 1 WHERE id = ?");
            myStatement.setInt(1, id);
            myStatement.executeUpdate();
            myStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement myStatement = this.myConnection.prepareStatement("UPDATE wishes SET deleted = true WHERE id = ?");
            myStatement.setInt(1, id);
            myStatement.executeUpdate();
            myStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
