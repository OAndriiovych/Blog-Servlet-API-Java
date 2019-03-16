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
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class UserServTest {

    @Parameterized.Parameters
    public static List<User> numbers() {
        return usersList;
    }
    private static List<User> usersList= Arrays.asList(new User("login1", "password", "lastname","D:\\SS\\blog\\web\\images\\deff.jpg", Roles.ADMIN),
            new User("login2", "password", "lastname","D:\\SS\\blog\\web\\images\\deff.jpg", Roles.MODERATOR),
            new User("login3", "password", "lastname","D:\\SS\\blog\\web\\images\\deff.jpg", Roles.USER),
            new User("login4", "password", "lastname","D:\\SS\\blog\\web\\images\\deff.jpg",Roles.USER)
    );

    public UserServTest(User user) {
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
    public  void init() throws SQLException {
        addTest();
    }

    @After
    public void clear() throws SQLException {
        deleteTest();
    }

    @Test
    public void getUserTest() throws SQLException {
        User cloneUser = userServ.getUser(user);
        equalsUsers(user,cloneUser);
    }

    @Test
    public void getIDTest() throws SQLException {
        int id =userServ.getID(user.getLogin());
        assertEquals(id,userServ.getUser(user).getId_user());
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

    @Test
    public void updateTest() throws SQLException {
        User userClone = new User(user.getId_user(),
                "lool",
                "pass",
                "last",
                new java.sql.Date(System.currentTimeMillis()),
                "//",
                Roles.USER);
        int id=userServ.getID(user.getLogin());
        userServ.update(id,userClone);
        User newU = userServ.getByID(id);
        equalsUsers(userServ.getByID(id),userClone);
        //assertEquals(userClone,userServ.getByID(id));
        userServ.update(id,user);
    }

     void addTest() throws SQLException {
        userServ.add(user);
    }


     void deleteTest() throws SQLException {
        userServ.delete(user);
    }

    static void equalsUsers(User user , User cloneUser) throws SQLException {
        assertEquals(user.getLogin(), cloneUser.getLogin());
        assertEquals(user.getPassw(), cloneUser.getPassw());
        assertEquals(user.getLastname(), cloneUser.getLastname());
    }
}
