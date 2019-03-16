package db.database;

import java.sql.Date;
import java.util.Objects;

public class User_comment {
    private  int id_comment;
    private  int user_id;
    private  int post_id;
    private String user_comment;
    private Date date_of_coment ;

    public User_comment(int id_comment, int user_id, int post_id, String user_comment, Date date_of_coment) {
        this.id_comment = id_comment;
        this.user_id = user_id;
        this.post_id = post_id;
        this.user_comment = user_comment;
        this.date_of_coment = date_of_coment;
    }

    public User_comment(int user_id, int post_id, String user_comment) {
        this.user_id = user_id;
        this.post_id = post_id;
        this.user_comment = user_comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User_comment comment = (User_comment) o;
        return id_comment == comment.id_comment &&
                user_id == comment.user_id &&
                post_id == comment.post_id &&
                Objects.equals(user_comment, comment.user_comment) &&
                Objects.equals(date_of_coment, comment.date_of_coment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_comment, user_id, post_id, user_comment, date_of_coment);
    }

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getUser_comment() {
        return user_comment;
    }

    public void setUser_comment(String user_comment) {
        this.user_comment = user_comment;
    }

    public Date getDate_of_coment() {
        return date_of_coment;
    }

    public void setDate_of_coment(Date date_of_coment) {
        this.date_of_coment = date_of_coment;
    }
}
