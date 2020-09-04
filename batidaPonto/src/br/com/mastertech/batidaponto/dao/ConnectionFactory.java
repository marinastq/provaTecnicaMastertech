package br.com.mastertech.batidaponto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException {
        try {
        	//Class.forName("com.mysql.jdbc.Driver");
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	String BD_URL = "jdbc:mysql://localhost:3306/WORKHOURS?useTimezone=true&serverTimezone=UTC";
            return DriverManager.getConnection(
            		BD_URL, //url
            		"root", //user
            		""); //password
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
