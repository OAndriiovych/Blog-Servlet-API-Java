package db.servises;

import db.DAO.User_commentDAO;
import db.database.Post;
import db.database.User_comment;
import db.utill.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CommentServ extends Connection implements User_commentDAO {

    private java.sql.Connection connection;


    @Override
    public void add(User_comment userComments) throws SQLException {
        String sql = "INSERT INTO user_comments (user_id, post_id, user_comment) VALUES (?,?,?)";

        PreparedStatement prpStat = connection.prepareStatement(sql);
        prpStat.setInt(1, userComments.getUser_id());
        prpStat.setInt(2, userComments.getPost_id());
        prpStat.setString(3, userComments.getUser_comment());

        prpStat.executeUpdate();
        prpStat.close();
    }
    public int getCountComment(int id) throws SQLException {
        int count = 0;
        String sql="select count(*) from user_comments where post_id ="+id;
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        count=rs.getInt("count");

        return count;
    }

    /**have to do*/
    public List<User_comment> getAll() throws SQLException {
        return last(-1);
    }
    public List<User_comment> last(int post_id) throws SQLException {
        List<User_comment> list = new LinkedList();
        Statement stmt = connection.createStatement();
        String sql = null;
        if (post_id > 0) {
            sql = "select * from user_comments where post_id = "+post_id+" order by id_comment DESC limit 150";
        }
        else {
            sql = "select * from user_comments order by id_comment DESC limit 150";
        }
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            list.add(new User_comment(rs.getInt("id_comment"),
                    rs.getInt("user_id"),
                    rs.getInt("post_id"),
                    rs.getString("user_comment"),
                    rs.getDate("date_of_coment")
                    ));
        }
        rs.close();
        stmt.close();
        return list;
    }

    public User_comment getByID(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(User_comment userComments) throws SQLException {

    }

    @Override
    public void delete(User_comment userComments) throws SQLException {

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
