package com.example.application.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConfig {
    private static final String PROPERTIES_FILE = "config.properties";
    private static final String DB_URL_PROPERTY = "db.url";
    private static final String DB_USERNAME_PROPERTY = "db.username";
    private static final String DB_PASSWORD_PROPERTY = "db.password";

    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        try (InputStream inputStream = DataBaseConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            // Manejar la excepción de lectura de propiedades
            e.printStackTrace();
        }

        String dbUrl = properties.getProperty(DB_URL_PROPERTY);
        String dbUsername = properties.getProperty(DB_USERNAME_PROPERTY);
        String dbPassword = properties.getProperty(DB_PASSWORD_PROPERTY);

        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }
}
