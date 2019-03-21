package servlets.account;

import db.database.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (BaseServlet.checkSession(req)) {
            resp.sendRedirect(req.getContextPath() + "/account");
            return;
        }
        if (BaseServlet.checkCookies(req)) {
            resp.sendRedirect(req.getContextPath() + "/account");
            return;
        }
        RequestDispatcher view = req.getRequestDispatcher("login.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (BaseServlet.checkCookies(req)) {
            resp.sendRedirect(req.getContextPath() + "/account");
        }
        String name = req.getParameter("email");
        String password = req.getParameter("psw");
        if (name == null || password == null) {
            req.setAttribute("login", true);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        name.replaceAll("\\s+", "");
        password.replaceAll("\\s+", "");
        if (name.equals("") || password.equals("")) {
            req.setAttribute("login", true);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        password = HashPassword.hash(password);
        User user = new User(name, password);
        try {
            user = userServ.getUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user == null) {
            req.setAttribute("login", true);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        HttpSession session = req.getSession();
        login(user.getId_user(), session);
        if (req.getParameter("cookies") != null) {
            resp.addCookie(new Cookie("id", Integer.toString(user.getId_user())));
            resp.addCookie(new Cookie("password", user.getPassw()));
        }
        resp.sendRedirect(req.getContextPath() + "/account");
    }
}
