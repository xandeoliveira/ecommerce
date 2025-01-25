package com.ecstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{
    private static final String URL = "jdbc:postgresql://localhost:5432/ecstore";
    private static final String USER = "postgres";
    private static final String PASSWORD = "5432";

    public static Connection getConnection() throws SQLException {
        try {
        	Class.forName("org.postgresql.Driver");
        	return DriverManager.getConnection(URL, USER, PASSWORD);
        	
        } catch (SQLException e) {
        	System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        	throw new RuntimeException("Falha ao conectar ao banco de dados", e);
        	
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return null;
    }
    
}