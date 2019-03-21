package db.utill;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connection {

    private static String wayToProperty = "d:/SS/blog/src/main/resources/config_db.properties";

    protected static java.sql.Connection getConnection() {
         java.sql.Connection conn = null;

            Properties property = new Properties();
            try {
                try {
                    property.load(new FileInputStream(wayToProperty));
                } catch (IOException e) {
                    System.err.println("ОШИБКА: Файл свойств отсуствует!");
                }
                Class.forName(property.getProperty("forname"));
                conn = DriverManager.getConnection(property.getProperty("host"),
                        property.getProperty("login"),
                        property.getProperty("password"));

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return conn;
    }

}
