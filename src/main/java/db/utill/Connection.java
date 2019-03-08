package db.utill;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.*;
import java.util.Properties;

public class Connection {

    private static String wayToProperty = "src/main/resources/config_db.properties";

    protected static java.sql.Connection getConnection() {
        Properties property = new Properties();
        java.sql.Connection conn = null;
        try {
            property.load(new FileInputStream(wayToProperty));
            conn = DriverManager.getConnection(property.getProperty("host"),
                    property.getProperty("login"),
                    property.getProperty("password"));
            Class.forName(property.getProperty("forname"));
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
