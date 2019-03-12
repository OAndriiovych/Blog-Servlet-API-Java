package db.servises;

import db.DAO.PostsDAO;
import db.database.Posts;
import db.database.Roles;
import db.utill.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PostServ extends Connection implements PostsDAO {

    private java.sql.Connection connection;

    public void add(Posts posts) throws SQLException {

        String sql = "INSERT INTO posts (category, topic, post, user_id) VALUES (?,?,?,?)";

        PreparedStatement prpStat = connection.prepareStatement(sql);
        prpStat.setString(1, posts.getCategory());
        prpStat.setString(2, posts.getTopic());
        prpStat.setString(3, posts.getPost());
        prpStat.setInt(4, posts.getUser_id());

        prpStat.executeUpdate();
        prpStat.close();
    }

    /**have to do*/
    public List<Posts> getAll() throws SQLException {
        return null;
    }

    public Posts getByID(int id) throws SQLException {
        return null;
    }

    public List<Posts> last3() throws SQLException {
        List<Posts> list = new LinkedList<Posts>();
        Statement stmt = connection.createStatement();
        String sql = "select * from posts limit 3;";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            list.add(new Posts(rs.getInt("id_post"),
                    rs.getString("category"),
                    rs.getString("topic"),
                    rs.getString("post"),
                    rs.getInt("user_id "),
                    rs.getDate("date_of_post")));
        }
        rs.close();
        stmt.close();
        return list;
    }

    public Posts last() throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "select * from posts order by id_post DESC limit 1;";
        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
        Posts posts = new Posts(rs.getInt("id_post"),
                rs.getString("category"),
                rs.getString("topic"),
                rs.getString("post"),
                rs.getInt("user_id "),
                rs.getDate("date_of_post"));
        rs.close();
        stmt.close();
        return posts;
    }

    public String author(int id) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "select lastname from users left join  posts on users.id_user = posts.user_id where user_id = "+id;
        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
        String login = rs.getString("lastname");

        rs.close();
        stmt.close();
        return login;
    }
    /**have to do*/
    public void update(Posts posts) throws SQLException {

    }
    /**have to do*/
    public void delete(Posts posts) throws SQLException {

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
