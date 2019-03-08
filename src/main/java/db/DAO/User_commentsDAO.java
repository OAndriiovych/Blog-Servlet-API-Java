package db.DAO;

import db.database.User_comments;

import java.sql.SQLException;
import java.util.List;

public interface User_commentsDAO {
    void add(User_comments userComments) throws SQLException;

    List<User_comments> getAll() throws SQLException;

    User_comments getByID(int id) throws SQLException;

    void update(User_comments userComments) throws SQLException;

    void delete(User_comments userComments) throws SQLException;
}
