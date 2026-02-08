package com.akmaral.library_api.utils;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5435/library_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
