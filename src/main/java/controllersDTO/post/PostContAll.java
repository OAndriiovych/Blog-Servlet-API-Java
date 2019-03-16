package controllersDTO.post;

import DTO.post.PostAllDTO;
import db.database.Post;

public class PostContAll extends PostContLess {

    private PostAllDTO postOutput;
    private PostContLess pcL = new PostContLess();

    public PostAllDTO getPostAllLong(Post postInput) {
        postOutput = new PostAllDTO(postInput.getTopic(),
                postInput.getDate_of_post(),
                postInput.getWay_to_photo(),
                postInput.getCategory()
        );
        postOutput.setPost(postInput.getPost());
        return postOutput;
    }

    public PostAllDTO getPostAllLite(Post postInput) {
        postOutput = new PostAllDTO(postInput.getTopic(),
                postInput.getDate_of_post(),
                postInput.getWay_to_photo(),
                postInput.getCategory()
        );
        postOutput.setPost(postInput.getPost().substring(0, 100) + "...");
        return postOutput;
    }

}
