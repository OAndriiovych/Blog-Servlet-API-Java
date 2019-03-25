import db.database.Post;
import db.database.User;
import db.database.User_comment;
import db.servises.CommentServ;
import db.servises.PostServ;
import db.servises.UserServ;
import org.junit.AfterClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class GetAllMethodTest {


    @AfterClass
    public static void clearClass() {

    }

    @Test
    public void getAllUser() throws SQLException {
        UserServ userServ = new UserServ();
        userServ.connect();
        List<User> usersList = UserServTest.numbers();
        for (User u : usersList) {
            userServ.add(u);
        }
        List<User> usersListClone = userServ.getAll();
        for (int i = 0; i < usersListClone.size(); i++) {
            UserServTest.equalsUsers(usersList.get(i), usersListClone.get(i));
        }
        for (User u : usersList) {
            userServ.delete(u);
        }
        userServ.closeConnection();
        userServ = null;
    }

    @Test
    public void getAllPost() throws SQLException {
        PostServ postServ = new PostServ();
        postServ.connect();
        List<Post> postsList = PostServTest.numbers();
        for (Post p : postsList) {
            postServ.add(p);
        }
        List<Post> postsListClone = postServ.getAll();
        for (int i = 0; i < postsListClone.size(); i++) {
            PostServTest.equalsPost(postsList.get(i), postsListClone.get(i));
        }
//        for (Post p : postsList) {
//            postServ.delete(p);
//        }
        postServ.closeConnection();
        postServ = null;
    }

    @Test
    public void getAllComment() throws SQLException {
        CommentServ commentServ = new CommentServ();
        commentServ.connect();
        List<User_comment> commentList = CommentServTest.numbers();
        for (User_comment comment : commentList) {
            commentServ.add(comment);
        }
        List<User_comment> commentListClone = commentServ.getAll();
        for (int i = 0; i < commentListClone.size(); i++) {
            CommentServTest.equalsPost(commentList.get(i), commentListClone.get(i));
        }
        for (User_comment comment : commentList) {
            commentServ.delete(comment);
        }
        commentServ.closeConnection();
        commentServ = null;
    }
}
