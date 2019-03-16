package controllersDTO.post;

import DTO.post.PostLessDTO;
import db.database.Post;

public class PostContLess  {
    private PostLessDTO postOutput;


    public PostLessDTO getPostLess(Post postInput) {
        postOutput = new PostLessDTO(postInput.getTopic(),postInput.getDate_of_post(),postInput.getWay_to_photo());
        return postOutput;
    }


}
