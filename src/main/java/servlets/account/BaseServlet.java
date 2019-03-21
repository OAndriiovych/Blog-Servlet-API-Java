package servlets.account;

import db.database.Roles;
import db.database.User;
import db.servises.UserServ;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

public abstract class BaseServlet extends HttpServlet {

    static UserServ userServ;

    @Override
    public void init() throws ServletException {
        super.init();
        userServ = new UserServ();
        userServ.connect();
    }

    @Override
    public void destroy() {
        userServ.closeConnection();
        super.destroy();
    }


    public static boolean checkSession(HttpServletRequest req) throws IOException {
        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            if (name.equals("id")) {
                try {
                    if (userServ.isUser((Integer) session.getAttribute(name))) {
                        return true;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    public static Roles getRole(HttpServletRequest req) throws IOException {
        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            if (name.equals("id")) {
                try {
                    return userServ.getByID((Integer) session.getAttribute(name)).getUser_role();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return Roles.USER;
    }

    public static boolean checkCookies(HttpServletRequest req) throws IOException {
        Cookie[] cookie = req.getCookies();
        int id = 0;
        String pass = null;
        if (cookie == null) {
            return false;
        }
        for (Cookie c : cookie) {
            if (c.getName().equals("id")) {
                id = Integer.parseInt(c.getValue());
            }
            else if(c.getName().equals("password")){
                pass=c.getValue();
            }
        }
        if (id == 0 || pass==null){
            return false;
        }
        try {
            if(userServ.isUser(id,pass)) {
                login(id, req.getSession());
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    static void login(int id, HttpSession session) {
        session.setAttribute("id", id);
        session.setMaxInactiveInterval((int) TimeUnit.DAYS.toSeconds(1));
    }

}
