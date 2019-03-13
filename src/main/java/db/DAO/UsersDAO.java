package db.DAO;

import db.database.Users;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO {

    void add(Users users) throws SQLException;

    List<Users> getAll() throws SQLException;

    Users getByID(int id) throws SQLException;

    void update(int id, Users users) throws SQLException;

    void delete(Users users) throws SQLException;
}
