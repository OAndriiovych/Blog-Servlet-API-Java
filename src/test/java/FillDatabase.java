import db.database.Post;
import db.database.Roles;
import db.database.User;
import db.database.User_comment;
import db.servises.CommentServ;
import db.servises.PostServ;
import db.servises.UserServ;

import java.sql.SQLException;

public class FillDatabase {
    public static void main(String[] args) throws SQLException {
        addPost();
    }
    public static void addUser() throws SQLException {
        UserServ userServ = new UserServ();
        userServ.connect();
        for(int i =1;i<7;i++){
            userServ.add(
                    new User("login"+i, "password", "lastname","\\images\\person_"+i+".jpg", Roles.ADMIN));
        }
        userServ.closeConnection();
        System.out.println("added users");
    }
    public static void addPost() throws SQLException {
        PostServ postServ = new PostServ();
        postServ.connect();
        for(int i =1;i<13;i++){
            postServ.add(new Post("knowledge", "My own blog",
                    "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Assumenda dolorem voluptas " +
                            "voluptates in officiis quos aperiam impedit consequuntur ut recusandae? Sint libero eligendi " +
                            "consequuntur ratione sit quos quasi eveniet ad rem ipsum voluptas voluptatum accusantium officia " +
                            "ipsam commodi, corrupti minus.", "\\images\\img_"+i+".jpg", 1));
        }
        postServ.closeConnection();
        System.out.println("added posts");
    }
    public static void addComent() throws SQLException {

        CommentServ commentServ = new CommentServ();
        commentServ.connect();
        for(int i =1;i<12;i++){
            int fina = (int) (Math.random() * (10 + 1));
            for(int count =1;count<fina;count++) {
                commentServ.add(new User_comment(1, i, "some text"+count));
            }
        }
        commentServ.closeConnection();
        System.out.println("added comments");
    }

}
