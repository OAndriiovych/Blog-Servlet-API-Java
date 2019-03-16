import db.database.Post;
import db.database.User;
import db.database.User_comment;
import db.servises.UserServ;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CommentServTest {

    @Parameterized.Parameters
    public static List<User_comment> numbers() {
        return usersList;
    }

    private static List<User_comment> usersList = Arrays.asList(
            new User_comment(1,1,"first"),
            new User_comment(2,2,"second"),
            new User_comment(3,3,"first"),
            new User_comment(4,4,"first")
            );


    public static void equalsPost(User_comment user_comment, User_comment user_comment1) {
        user_comment.equals(user_comment1);
    }
}
