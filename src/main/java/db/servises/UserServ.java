package db.servises;

import db.DAO.UserDAO;
import db.database.Roles;
import db.database.User;
import db.utill.Connection;
import servlets.account.HashPassword;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserServ extends Connection implements UserDAO {

    private java.sql.Connection connection;

    public void add(User user) throws SQLException {
        String sql = "INSERT INTO users (login, passw,lastname,way_to_photo) VALUES (?,?,?,?)";

        PreparedStatement prpStat = connection.prepareStatement(sql);
        prpStat.setString(1, user.getLogin());
        prpStat.setString(2, HashPassword.hash(user.getPassw()));
        prpStat.setString(3, user.getLastname());
        prpStat.setString(4, user.getWay_to_photo());

        prpStat.executeUpdate();
        prpStat.close();
    }

    public List<User> getAll() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from users");
        List<User> list = new LinkedList<User>();
        while (rs.next()) {
            list.add(new User(rs.getInt("id_user"),
                    rs.getString("login"),
                    rs.getString("passw"),
                    rs.getString("lastname"),
                    rs.getDate("date_of_reg"),
                    rs.getString("way_to_photo"),
                    Roles.valueOf(rs.getString("user_role").toUpperCase())));
        }
        stmt.close();
        rs.close();
        return list;

    }

    public User getByID(int id) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "select * from users where id_user = " + id;
        ResultSet rs = stmt.executeQuery(sql);
        User user = null;
        while (rs.next()) {
            user = new User(rs.getInt("id_user"),
                    rs.getString("login"),
                    rs.getString("passw"),
                    rs.getString("lastname"),
                    rs.getDate("date_of_reg"),
                    rs.getString("way_to_photo"),
                    Roles.valueOf(rs.getString("user_role").toUpperCase()));
        }
        rs.close();
        stmt.close();
        return user;
    }

    public User getUser(User user) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "select * from users where login = '" + user.getLogin()
                + "' and passw='" + HashPassword.hash(user.getPassw()) + "';";
        ResultSet rs = stmt.executeQuery(sql);
        user = null;
        while (rs.next()) {
            user = new User(rs.getInt("id_user"),
                    rs.getString("login"),
                    rs.getString("passw"),
                    rs.getString("lastname"),
                    rs.getDate("date_of_reg"),
                    rs.getString("way_to_photo"),
                    Roles.valueOf(rs.getString("user_role").toUpperCase()));
        }
        rs.close();
        stmt.close();
        return user;
    }

    public Integer getID(String s) throws SQLException {
        int id = -1;
        String sql = "select id_user from users where login = '" + s + "';";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            id = rs.getInt("id_user");
        }
        rs.close();
        stmt.close();
        return id;
    }

    public boolean isUser(String s) throws SQLException {
        String sql = "select * from users where login = '" + s + "'";
        return is(sql);
    }

    public boolean isUser(int id, String passwor) throws SQLException {
        String sql = "select * from users where id_user = " + id + " and passw = '" + passwor + "'";
        return is(sql);
    }

    public boolean isUser(int id) throws SQLException {
        String sql = "select * from users where id_user = " + id;
        return is(sql);
    }

    private boolean is(String sql) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        boolean b = rs.next();

        rs.close();
        stmt.close();
        return b;
    }

    public void update(int id, User user) throws SQLException {
        String s = "'user'";
        if (user.getUser_role() == Roles.ADMIN) {
            s = "'admin'";
        } else if (user.getUser_role() == Roles.MODERATOR) {
            s = "'moderator'";
        }
        String sql = "UPDATE users set login=?, passw=?, lastname=?, " +
                "way_to_photo=?,user_role=" + s + " where id_user = " + id;
        PreparedStatement prpStat = connection.prepareStatement(sql);

        prpStat.setString(1, user.getLogin());
        prpStat.setString(2, HashPassword.hash(user.getPassw()));
        prpStat.setString(3, user.getLastname());
        prpStat.setString(4, user.getWay_to_photo());
        prpStat.executeUpdate();
        prpStat.close();
    }

    public void delete(User user) throws SQLException {
        if (user.getId_user() == 0) {
            user = getUser(user);
        }
        String sql = "DELETE FROM users WHERE id_user = ? ;";
        PreparedStatement prpStat = connection.prepareStatement(sql);
        prpStat.setInt(1, user.getId_user());

        prpStat.executeUpdate();
        prpStat.close();
    }

    public void connect() {
        connection = getConnection();
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
