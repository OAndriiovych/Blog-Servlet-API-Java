package view.DTO.post;

import db.database.Post;

import java.util.Date;

public class PostLessDTO extends PostLittleDTO {

    protected String author;
    protected String way_to_author_photo;

    public PostLessDTO(int id_post, String topic, Date date_of_post, String way_to_photo) {
        super(id_post, topic, date_of_post, way_to_photo);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getWay_to_author_photo() {
        return way_to_author_photo;
    }

    public void setWay_to_author_photo(String way_to_author_photo) {
        this.way_to_author_photo = way_to_author_photo;
    }
}
