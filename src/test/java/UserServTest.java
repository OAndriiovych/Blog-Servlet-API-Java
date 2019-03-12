import db.database.Roles;
import db.database.Users;
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
    public static List<Users> numbers() {
        return usersList;
    }
    private static List<Users> usersList= Arrays.asList(new Users("login1", "password", "lastname", Roles.ADMIN),
            new Users("login2", "password", "lastname", Roles.MODERATOR),
            new Users("login3", "password", "lastname", Roles.USER),
            new Users("login4", "password", "lastname")
    );

    public UserServTest(Users user) {
        this.user = user;
    }

    private Users user;

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
        Users cloneUser = userServ.getUser(user);
        equalsUsers(user,cloneUser);
    }

    @Test
    public void getByIdTest() throws SQLException {
        Users cloneUser = userServ.getUser(user);
        Users cloneUser2 = userServ.getByID(cloneUser.getId_user());
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

     void addTest() throws SQLException {
        userServ.add(user);
    }


     void deleteTest() throws SQLException {
        userServ.delete(user);
    }

    static void equalsUsers(Users user ,Users cloneUser) throws SQLException {
        assertEquals(user.getLogin(), cloneUser.getLogin());
        assertEquals(user.getPassw(), cloneUser.getPassw());
        assertEquals(user.getLastname(), cloneUser.getLastname());
    }
}
