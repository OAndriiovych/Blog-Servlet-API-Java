package view.DTO.post;

import java.util.Date;

public class PostAllDTO extends PostLessDTO{
    protected String category;
    protected String post;
    protected int countComment;

    @Override
    public String toString() {
        return "PostAllDTO{" +
                "category='" + category + '\'' +
                ", post='" + post + '\'' +
                ", countComment=" + countComment +
                ", author='" + author + '\'' +
                ", way_to_author_photo='" + way_to_author_photo + '\'' +
                ", topic='" + topic + '\'' +
                ", date_of_post=" + date_of_post +
                ", way_to_photo='" + way_to_photo + '\'' +
                '}';
    }

    public PostAllDTO(int id_post, String topic, Date date_of_post, String way_to_photo, String category) {
        super(id_post, topic, date_of_post, way_to_photo);
        this.category = category;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCountComment() {
        return countComment;
    }

    public void setCountComment(int countComment) {
        this.countComment = countComment;
    }
}
