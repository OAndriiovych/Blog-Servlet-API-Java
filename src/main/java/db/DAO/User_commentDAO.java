package db.DAO;

import db.database.User_comment;

import java.sql.SQLException;
import java.util.List;

public interface User_commentDAO {
    void add(User_comment userComments) throws SQLException;

    List<User_comment> getAll() throws SQLException;

    User_comment getByID(int id) throws SQLException;

    void update(User_comment userComments) throws SQLException;

    void delete(User_comment userComments) throws SQLException;
}
