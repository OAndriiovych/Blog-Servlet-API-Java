package view.controllersDTO.post;


import db.database.Post;
import view.DTO.post.PostLittleDTO;

public class PostContLittle {

    public static final PostLittleDTO getPostLittle(Post postInput) {
        PostLittleDTO postOutput = new PostLittleDTO(
                postInput.getId_post(),
                postInput.getTopic(),
                postInput.getDate_of_post(),
                postInput.getWay_to_photo());
        return postOutput;
    }
}
