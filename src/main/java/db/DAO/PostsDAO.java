package db.DAO;

import db.database.Posts;

import java.sql.SQLException;
import java.util.List;

public interface PostsDAO {

    void add(Posts posts) throws SQLException;

    List<Posts> getAll() throws SQLException;

    Posts getByID(int id) throws SQLException;

    void update(Posts posts) throws SQLException;

    void delete(Posts posts) throws SQLException;
}
