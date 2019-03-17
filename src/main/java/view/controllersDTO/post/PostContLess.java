package view.controllersDTO.post;


import db.database.Post;
import db.database.User;
import db.servises.UserServ;
import view.DTO.post.PostLessDTO;

import java.sql.SQLException;

public class PostContLess  {

    public static final PostLessDTO getPostLess(Post postInput) throws SQLException {
        PostLessDTO postLessDTO=new PostLessDTO(
                postInput.getId_post(),
                postInput.getTopic(),
                postInput.getDate_of_post(),
                postInput.getWay_to_photo());
        User user = null;
        UserServ userServ = new UserServ();
        userServ.connect();

            user = userServ.getByID(postInput.getUser_id());

        userServ.closeConnection();
        postLessDTO.setAuthor(user.getLastname());
        postLessDTO.setWay_to_author_photo(user.getWay_to_photo());

        return postLessDTO;
    }
}
