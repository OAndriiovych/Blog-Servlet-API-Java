package view.controllersDTO.comment;

import db.database.User;
import db.database.User_comment;
import db.servises.UserServ;
import view.DTO.comment.CommentDTO;

import java.sql.SQLException;

public class CommentControl {
    public static final CommentDTO toCommentDTO(User_comment userComment) throws SQLException {
        CommentDTO comment = new CommentDTO(userComment.getDate_of_coment(), userComment.getUser_comment());
        UserServ userServ = new UserServ();
        userServ.connect();
        User user = userServ.getByID(userComment.getUser_id());
        userServ.closeConnection();
        comment.setLastname(user.getLastname());
        comment.setWay_to_author_photo(user.getWay_to_photo());
        return comment;
    }
}
