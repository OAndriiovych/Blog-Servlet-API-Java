package DTO.post;

import java.util.Date;

public class PostAllDTO {
    private String category;
    private String topic;
    private String post;
    private String way_to_photo;
    private String author;
    private Date date_of_post;

    public PostAllDTO(String category, String topic,  String way_to_photo, String author, Date date_of_post) {
        this.category = category;
        this.topic = topic;
        this.way_to_photo = way_to_photo;
        this.author = author;
        this.date_of_post = date_of_post;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
