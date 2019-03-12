import db.database.Users;
import db.servises.UserServ;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class GetAllMethodTest {


    @AfterClass
    public static void clearClass() {

    }
    @Test
    public void getAll() throws SQLException {
        UserServ userServ = new UserServ();
        userServ.connect();
        List<Users> usersList=UserServTest.numbers();
        for(Users u:usersList) {
            userServ.add(u);
        }
        List<Users> usersListClone = userServ.getAll();
        for(int i = 0;i<usersListClone.size();i++) {
            UserServTest.equalsUsers(usersList.get(i), usersListClone.get(i));
        }
        for(Users u:usersList) {
            userServ.delete(u);
        }
        userServ.closeConnection();
        userServ = null;
    }
}
