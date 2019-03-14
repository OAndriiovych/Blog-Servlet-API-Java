package controllersDTO.post;

import DTO.post.PostAllDTO;
import db.database.Post;

public class PostControll {
    private PostAllDTO postOutput;

    public PostAllDTO convertToLittle(Post postInput){
        postInput.getPost();
        init(postInput);
        postOutput.setPost(postInput.getPost());
        return postOutput;
    }
    public PostAllDTO convertToLong(Post postInput){
        postInput.getPost();
        init(postInput);
        postOutput.setPost(postInput.getPost().substring(0,100)+"...");
        return postOutput;
    }
    private PostAllDTO init(Post postInput){
        postInput.getPost();
        postOutput = new PostAllDTO(postInput.getCategory(),
                postInput.getTopic(),
                postInput.getPost(),
                postInput.getWay_to_photo(),
                postInput.getDate_of_post());

        return postOutput;
    }


}
