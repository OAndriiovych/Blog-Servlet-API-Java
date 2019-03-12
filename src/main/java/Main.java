import db.database.Posts;
import db.database.Users;
import db.servises.PostServ;
import db.servises.UserServ;
import servlets.account.Registration;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserServ userServ = new UserServ();
        userServ.connect();

        userServ.add(new Users("firstuser@email","qwerty123456","firstuser"));

        PostServ postServ = new PostServ();
        postServ.connect();
   //     ppo.add(new Posts("123432141324",1));
        postServ.add(new Posts("knowledge","My own blog","\n" +
                "        Lorem, ipsum dolor sit amet consectetur adipisicing elit. Assumenda dolorem voluptas " +
                "voluptates in officiis quos aperiam impedit consequuntur ut recusandae? Sint libero eligendi " +
                "consequuntur ratione sit quos quasi eveniet ad rem ipsum voluptas voluptatum accusantium officia " +
                "ipsam commodi, corrupti minus.",1));
        Posts p = postServ.last();
        System.out.println(p.getCategory());
        System.out.println(p.getTopic());
        System.out.println(p.getPost());
        System.out.println(postServ.author(p.getUser_id()));


    }
}
