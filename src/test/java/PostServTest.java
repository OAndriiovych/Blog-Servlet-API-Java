import db.database.Post;
import db.database.Roles;
import db.database.User;
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
public class PostServTest {

    @Parameterized.Parameters
    public static List<Post> numbers() {
        return usersList;
    }

    private static List<Post> usersList = Arrays.asList(
            new Post("knowledge", "My own blog",
                    "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Assumenda dolorem voluptas " +
                            "voluptates in officiis quos aperiam impedit consequuntur ut recusandae? Sint libero eligendi " +
                            "consequuntur ratione sit quos quasi eveniet ad rem ipsum voluptas voluptatum accusantium officia " +
                            "ipsam commodi, corrupti minus.", "D:\\SS\\blog\\out\\artifacts\\new_war_exploded\\images\\img_7.jpg", 2),
            new Post("knowledge", "My own blog",
                    "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Assumenda dolorem voluptas " +
                            "voluptates in officiis quos aperiam impedit consequuntur ut recusandae? Sint libero eligendi " +
                            "consequuntur ratione sit quos quasi eveniet ad rem ipsum voluptas voluptatum accusantium officia " +
                            "ipsam commodi, corrupti minus.", "D:\\SS\\blog\\out\\artifacts\\new_war_exploded\\images\\img_7.jpg", 2),
            new Post("knowledge", "My own blog",
                    "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Assumenda dolorem voluptas " +
                            "voluptates in officiis quos aperiam impedit consequuntur ut recusandae? Sint libero eligendi " +
                            "consequuntur ratione sit quos quasi eveniet ad rem ipsum voluptas voluptatum accusantium officia " +
                            "ipsam commodi, corrupti minus.", "D:\\SS\\blog\\out\\artifacts\\new_war_exploded\\images\\img_7.jpg", 2),
            new Post("knowledge", "My own blog",
                    "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Assumenda dolorem voluptas " +
                            "voluptates in officiis quos aperiam impedit consequuntur ut recusandae? Sint libero eligendi " +
                            "consequuntur ratione sit quos quasi eveniet ad rem ipsum voluptas voluptatum accusantium officia " +
                            "ipsam commodi, corrupti minus.", "D:\\SS\\blog\\out\\artifacts\\new_war_exploded\\images\\img_7.jpg", 2));


    public PostServTest(User user) {
        this.user = user;
    }

    private User user;

    private static UserServ userServ;

    @BeforeClass
    public static void initClass() {
        userServ = new UserServ();
        userServ.connect();
    }

    @AfterClass
    public static void clearClass() {
        userServ.closeConnection();
        userServ = null;
    }

    @Before
    public void init() throws SQLException {
        addTest();
    }

    @After
    public void clear() throws SQLException {
        deleteTest();
    }

//    @Test
//    public void getUserTest() throws SQLException {
//        User cloneUser = userServ.getUser(user);
//        equalsUsers(user, cloneUser);
//    }

    @Test
    public void getIDTest() throws SQLException {
        int id = userServ.getID(user.getLogin());
        assertEquals(id, userServ.getUser(user).getId_user());
    }

    @Test
    public void getByIdTest() throws SQLException {
        User cloneUser = userServ.getUser(user);
        User cloneUser2 = userServ.getByID(cloneUser.getId_user());
        assertEquals(cloneUser2, cloneUser);
    }


    @Test
    public void isUserS() throws SQLException {
        assertTrue(userServ.isUser(user.getLogin()));
    }

    @Test
    public void isUserId() throws SQLException {
        int id = userServ.getID(user.getLogin());
        assertTrue(userServ.isUser(id));
    }

    @Test
    public void isNotUserS() throws SQLException {
        assertTrue(!userServ.isUser("none"));
    }

    @Test
    public void isNotUserId() throws SQLException {
        assertTrue(!userServ.isUser(-1));
    }

//    @Test
//    public void updateTest() throws SQLException {
//        User userClone = new User(user.getId_user(),
//                "lool",
//                "pass",
//                "last",
//                new java.sql.Date(System.currentTimeMillis()),
//                "//",
//                Roles.USER);
//        int id = userServ.getID(user.getLogin());
//        userServ.update(id, userClone);
//        User newU = userServ.getByID(id);
//        equalsUsers(userServ.getByID(id), userClone);
//        //assertEquals(userClone,userServ.getByID(id));
//        userServ.update(id, user);
//    }

    void addTest() throws SQLException {
        userServ.add(user);
    }


    void deleteTest() throws SQLException {
        userServ.delete(user);
    }

    static void equalsPost(Post post, Post clonePost) throws SQLException {
        assertEquals(post, clonePost);

    }
}
