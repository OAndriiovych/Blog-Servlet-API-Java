package servlets.account;

import db.database.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class Registration extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("email");
        try {
            if (userServ.isUser(name)) {
                resp.sendRedirect(req.getContextPath() + "/");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user = new User(name, req.getParameter("psw"), req.getParameter("lastname"));
        User userLogin = null;
        HttpSession session = req.getSession();
        try {
            userServ.add(user);
            userLogin = userServ.getUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        login(userLogin.getId_user(), session);
        resp.sendRedirect(req.getContextPath() + "/account");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (BaseServlet.checkSession(req) || BaseServlet.checkCookies(req)) {
            resp.sendRedirect(req.getContextPath() + "/account");
            return;
        }
        RequestDispatcher view = req.getRequestDispatcher("WEB-INF/jsp/registration.jsp");
        view.forward(req, resp);
    }

}
