package DTO.post;

import java.util.Date;

public class PostLittleDTO {
    protected String topic;
    protected Date date_of_post;
    protected String way_to_photo;

    public PostLittleDTO(String topic, Date date_of_post, String way_to_photo) {
        this.topic = topic;
        this.date_of_post = date_of_post;
        this.way_to_photo = way_to_photo;
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

    public String getWay_to_photo() {
        return way_to_photo;
    }

    public void setWay_to_photo(String way_to_photo) {
        this.way_to_photo = way_to_photo;
    }
}
