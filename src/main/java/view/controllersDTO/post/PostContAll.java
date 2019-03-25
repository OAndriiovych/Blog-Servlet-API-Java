package view.controllersDTO.post;


import db.database.Post;
import db.database.User;
import db.servises.CommentServ;
import db.servises.UserServ;
import view.DTO.post.PostAllDTO;

import java.sql.SQLException;

public class PostContAll {

    public static final PostAllDTO getPostAllLong(Post postInput) throws SQLException {
        PostAllDTO postOutput = makePostAllDTO(postInput);
        postOutput.setPost(postInput.getPost());
        return postOutput;
    }

    public static final PostAllDTO getPostAllLite(Post postInput) throws SQLException {
        PostAllDTO postOutput = makePostAllDTO(postInput);
        if (postInput.getPost().length() > 101) {
            postOutput.setPost(postInput.getPost().substring(0, 100) + "...");
        } else {
            postOutput.setPost(postInput.getPost());
        }
        return postOutput;
    }

    private static final PostAllDTO makePostAllDTO(Post postInput) throws SQLException {
        PostAllDTO postOutput = new PostAllDTO(
                postInput.getId_post(),
                postInput.getTopic(),
                postInput.getDate_of_post(),
                postInput.getWay_to_photo(),
                postInput.getCategory()
        );
        User user = null;
        UserServ userServ = new UserServ();
        userServ.connect();

        user = userServ.getByID(postInput.getUser_id());

        userServ.closeConnection();
        postOutput.setAuthor(user.getLastname());
        postOutput.setWay_to_author_photo(user.getWay_to_photo());
        CommentServ commentServ = new CommentServ();
        commentServ.connect();

        postOutput.setCountComment(commentServ.getCountComment(postInput.getId_post()));

        commentServ.closeConnection();
        return postOutput;

    }

}
