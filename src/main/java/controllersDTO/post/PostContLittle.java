package controllersDTO.post;

import DTO.post.PostLessDTO;
import DTO.post.PostLittleDTO;
import db.database.Post;

public class PostContLittle {

    public static final PostLittleDTO getPostLittle(Post postInput) {
        PostLittleDTO postOutput = new PostLittleDTO(
                postInput.getTopic(),
                postInput.getDate_of_post(),
                postInput.getWay_to_photo());
        return postOutput;
    }
}
