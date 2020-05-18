package com.geekbrains.server;

import java.sql.*;

public class SQLLiteAuthService implements AuthService {
    private static Connection connection;
    private static Statement stmt;

    @Override
    public void start() {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
            disconnect();
        }
    }

    public static void connect() {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:chat.db");
        stmt = connection.createStatement();
    }



    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        ResultSet rs = stmt.executeQuery("SELECT NickName FROM Users WHERE Login = " + login + " and Password = " + password+ ";");

        while(rs.next()) {
            return rs.getString("NickName");
        }
        return null;
    }

    public void changeNick(String login, String password, String NickName){
        stmt.executeUpdate("UPDATE Users SET NickName = "+ NickName + " WHERE Login = " + login + " and Password = " + password+ ";");
    }

    @Override
    public void stop() {
        disconnect();
    }

    public static void disconnect() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
