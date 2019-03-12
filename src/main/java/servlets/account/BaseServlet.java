package servlets.account;

import db.database.Roles;
import db.database.Users;
import db.servises.UserServ;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

public abstract class BaseServlet extends HttpServlet {

    UserServ userServ;

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


    protected boolean checkSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            if (name.equals("id")) {
                try {
                    if (userServ.isUser((Integer) session.getAttribute(name))) {
                        resp.sendRedirect("have.html");
                        return true;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    protected boolean checkCookies(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookie = req.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {
                if (c.getName().equals("id")) {
                    if (Integer.valueOf(c.getValue()) != -1) {
                        try {
                            if (userServ.isUser(Integer.parseInt(c.getValue()))) {
                                resp.sendRedirect("have.html");
                                return true;
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return false;
    }
    void login(Users users, HttpSession session){
        if (users.getLogin() != null) {
            session.setAttribute("id", users.getId_user());
            session.setAttribute("lastname", users.getLastname());
            session.setMaxInactiveInterval((int) TimeUnit.DAYS.toSeconds(1));
            // resp.addCookie(new Cookie("id", Integer.toString(users.getId_user())));
            if (users.getUser_role() == Roles.ADMIN) {
                session.setMaxInactiveInterval((int) TimeUnit.HOURS.toSeconds(8));
                session.setAttribute("role", Roles.ADMIN.toString());
                //resp.addCookie(new Cookie("role", Roles.ADMIN.toString()));
            }
        }
    }

}
