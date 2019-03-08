import db.database.Users;
import db.servises.UserServ;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServ us = new UserServ();
        Users users = us.getByID(1);
        us.add(new Users("1","11"));
        List list = us.getAll();
        System.out.println(users);
        System.out.println(list);
    }
}
