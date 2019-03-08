package db.database;

import java.sql.Date;

public class Posts {
    private  int id_post;
    private String post;
    private  int user_id;
    private Date date_of_coment;

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDate_of_coment() {
        return date_of_coment;
    }

    public void setDate_of_coment(Date date_of_coment) {
        this.date_of_coment = date_of_coment;
    }
}
