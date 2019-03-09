package servlets.account;

import db.servises.UserServ;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public abstract class BaseServlet extends HttpServlet {

    UserServ userServ;

    @Override
    public void init() throws ServletException {
        super.init();
        userServ =new UserServ();
        userServ.connect();
    }

    @Override
    public void destroy() {
        userServ.closeConnection();
        super.destroy();
    }
    public boolean checkCookies(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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

}
