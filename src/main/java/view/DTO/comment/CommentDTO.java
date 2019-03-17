package view.DTO.comment;

import java.util.Date;

public class CommentDTO {

    private String lastname;
    private Date date_of_coment;
    private String user_comment;
    private String way_to_author_photo;

    public String getWay_to_author_photo() {
        return way_to_author_photo;
    }

    public void setWay_to_author_photo(String way_to_author_photo) {
        this.way_to_author_photo = way_to_author_photo;
    }

    public CommentDTO(Date date_of_coment, String user_comment) {
        this.date_of_coment = date_of_coment;
        this.user_comment = user_comment;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDate_of_coment() {
        return date_of_coment;
    }

    public void setDate_of_coment(Date date_of_coment) {
        this.date_of_coment = date_of_coment;
    }

    public String getUser_comment() {
        return user_comment;
    }

    public void setUser_comment(String user_comment) {
        this.user_comment = user_comment;
    }
}
