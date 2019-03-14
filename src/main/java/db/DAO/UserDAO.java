package db.DAO;

import db.database.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    void add(User users) throws SQLException;

    List<User> getAll() throws SQLException;

    User getByID(int id) throws SQLException;

    void update(int id, User users) throws SQLException;

    void delete(User users) throws SQLException;
}
