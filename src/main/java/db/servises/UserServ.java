package db.servises;


import db.DAO.UsersDAO;
import db.database.Roles;
import db.database.Users;
import db.utill.Connection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserServ extends Connection implements UsersDAO {

    java.sql.Connection connection = getConnection();

    public void add(Users users) throws SQLException {

        String s;
        PreparedStatement prpStat = null;
       if(users.getUser_role()==Roles.ADMIN){
            s ="'admin'";
        }
        else if(users.getUser_role()==Roles.MODERATOR){
           s ="'moderator'";
       }
        else {
           s ="'user'";
        }
        prpStat = connection.prepareStatement("INSERT INTO users (login, passw,user_role) VALUES (?,?,"+s+")");
        prpStat.setString(1, users.getLogin());
        prpStat.setString(2, users.getPassw());

        prpStat.executeUpdate();
        prpStat.close();


    }

    public List<Users> getAll() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from users");
        List<Users> list = new LinkedList<Users>();
        while (rs.next()) {
            list.add(new Users(rs.getInt("id_user"),
                    rs.getString("login"),
                    rs.getString("passw"),
                    rs.getDate("date_of_reg"),
                    Roles.valueOf(rs.getString("user_role").toUpperCase())));
        }
        stmt.close();
        rs.close();
        return list;

    }

    public Users getByID(int id) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "select * from users where id_user = " + id;
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        Users users = new Users(rs.getInt("id_user"),
                rs.getString("login"),
                rs.getString("passw"),
                rs.getDate("date_of_reg"),
                Roles.valueOf(rs.getString("user_role").toUpperCase()));
        stmt.close();
        rs.close();
        return users;


    }

    public void update(Users users) throws SQLException {

    }

    public void delete(Users users) throws SQLException {

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

    @Override
    protected void finalize() throws Throwable {
        closeConnection();
    }
}
