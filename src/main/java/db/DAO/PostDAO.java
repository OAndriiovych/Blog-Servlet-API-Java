package db.DAO;

import db.database.Post;

import java.sql.SQLException;
import java.util.List;

public interface PostDAO {

    void add(Post post) throws SQLException;

    List<Post> getAll() throws SQLException;

    Post getByID(int id) throws SQLException;

    void update(Post post) throws SQLException;

    void delete(Post post) throws SQLException;
}
