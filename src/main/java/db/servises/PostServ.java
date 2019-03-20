package db.servises;

import db.DAO.PostDAO;
import db.database.Post;
import db.utill.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class PostServ extends Connection implements PostDAO {

    private java.sql.Connection connection;

    public void add(Post post) throws SQLException {
        String sql = "INSERT INTO posts (category, topic, post, way_to_photo, user_id) VALUES (?,?,?,?,?)";

        PreparedStatement prpStat = connection.prepareStatement(sql);
        prpStat.setString(1, post.getCategory());
        prpStat.setString(2, post.getTopic());
        prpStat.setString(3, post.getPost());
        prpStat.setString(4, post.getWay_to_photo());
        prpStat.setInt(5, post.getUser_id());

        prpStat.executeUpdate();
        prpStat.close();
    }

    public List<Post> getAll() throws SQLException {
        return last(-1, 0);
    }

    public Post getByID(int id) throws SQLException {
        Post post = null;
        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM posts WHERE id_post = " + id;

        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
        post = new Post(rs.getInt("id_post"),
                rs.getString("category"),
                rs.getString("topic"),
                rs.getString("post"),
                rs.getString("way_to_photo"),
                rs.getInt("user_id"),
                rs.getDate("date_of_post"));

        rs.close();
        stmt.close();
        return post;
    }

    public Post findLike() throws SQLException {
        return null;
    }

    public int count() throws SQLException {
        int count = 0;
        String sql = "SELECT count(*) FROM posts";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        count = rs.getInt("count");
        rs.close();
        return count;
    }


    public List<Post> last(int from, int to) throws SQLException {
        List<Post> list = new LinkedList();
        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM posts ORDER BY id_post  ";
        if (from >= 0) {
            sql += "DESC offset " + from + " limit " + to;
        }
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            list.add(new Post(rs.getInt("id_post"),
                    rs.getString("category"),
                    rs.getString("topic"),
                    rs.getString("post"),
                    rs.getString("way_to_photo"),
                    rs.getInt("user_id"),
                    rs.getDate("date_of_post")));
        }
        rs.close();
        stmt.close();
        return list;
    }


    public String getAuthor(int id) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "SELECT lastname FROM users LEFT JOIN  posts ON users.id_user = posts.user_id WHERE user_id = " + id;
        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
        String login = rs.getString("lastname");

        rs.close();
        stmt.close();
        return login;
    }
    public List<Post> findLike(String like) throws SQLException {
        List<Post> listOfPosts = new LinkedList<>();
        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM posts WHERE LOWER(topic) LIKE LOWER('%"+like+"%'); ";

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            listOfPosts.add(new Post(rs.getInt("id_post"),
                    rs.getString("category"),
                    rs.getString("topic"),
                    rs.getString("post"),
                    rs.getString("way_to_photo"),
                    rs.getInt("user_id"),
                    rs.getDate("date_of_post")));
        }
        rs.close();
        stmt.close();
        return listOfPosts;
    }

    public void update(Post post) throws SQLException {

    }

    public void delete(Post post) throws SQLException {

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
