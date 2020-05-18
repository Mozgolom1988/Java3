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

    public static void connect() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:chat.db");
        stmt = connection.createStatement();
    }



    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT NickName FROM Users WHERE Login = '" + login + "' and Password = '" + password+ "';");
            while(rs.next()) {
                return rs.getString("NickName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void changeNick(String oldNickName, String NickName){
        try {
            stmt.executeUpdate("UPDATE Users SET NickName = '"+ NickName + "' WHERE NickName = '" + oldNickName + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
