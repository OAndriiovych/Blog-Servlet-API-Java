package db.database;

import java.sql.Date;

public class Post {
    private  int id_post;
    private String category;
    private String topic;
    private String post;
    private String way_to_photo;
    private int user_id;
    private Date date_of_post;



    public Post(int id_post, String category, String topic, String post, String way_to_photo, int user_id, Date date_of_post) {
        this.id_post = id_post;
        this.category = category;
        this.topic = topic;
        this.post = post;
        this.way_to_photo = way_to_photo;
        this.user_id = user_id;
        this.date_of_post = date_of_post;
    }

    /**
     * will be delete
     * */
    public Post(String category, String topic, String post, String way_to_photo, int user_id) {
        this.category = category;
        this.topic = topic;
        this.post = post;
        this.way_to_photo = way_to_photo;
        this.user_id = user_id;
    }

    public Post(String category, String topic, String post, String way_to_photo) {
        this.category = category;
        this.topic = topic;
        this.post = post;
        this.way_to_photo = way_to_photo;
    }

    public String getWay_to_photo() {
        return way_to_photo;
    }

    public void setWay_to_photo(String way_to_photo) {
        this.way_to_photo = way_to_photo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDate_of_post() {
        return date_of_post;
    }

    public void setDate_of_post(Date date_of_post) {
        this.date_of_post = date_of_post;
    }

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

    public Date getdate_of_post() {
        return date_of_post;
    }

    public void setdate_of_post(Date date_of_post) {
        this.date_of_post = date_of_post;
    }
}
