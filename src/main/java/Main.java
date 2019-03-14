import db.database.Post;
import db.servises.PostServ;
import db.servises.UserServ;

import java.io.File;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserServ userServ = new UserServ();
        userServ.connect();

      //  userServ.add(new User("firstuser@email","qwerty123456","firstuser"));

        PostServ postServ = new PostServ();
        postServ.connect();
   //     ppo.add(new Post("123432141324",1));
//        postServ.add(new Post("knowledge","My own blog",
//                "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Assumenda dolorem voluptas " +
//                "voluptates in officiis quos aperiam impedit consequuntur ut recusandae? Sint libero eligendi " +
//                "consequuntur ratione sit quos quasi eveniet ad rem ipsum voluptas voluptatum accusantium officia " +
//                "ipsam commodi, corrupti minus.","D:\\SS\\blog\\out\\artifacts\\new_war_exploded\\images\\img_2.jpg",1));

        Post p = postServ.last();
        System.out.println(p.getCategory());
        System.out.println(p.getTopic());
        String post = p.getPost();
        post = post.substring(0,100);
        post+="...";
        System.out.println( post);
        System.out.println( post.length());
        System.out.println( p.getWay_to_photo());
        System.out.println(new File(p.getWay_to_photo()));
        System.out.println(postServ.author(p.getUser_id()));


    }
}
