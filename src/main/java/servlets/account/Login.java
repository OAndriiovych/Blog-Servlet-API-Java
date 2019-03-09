package servlets.account;

import db.database.Roles;
import db.database.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/account")
public class Login extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(checkCookies(req,resp)){
            return;
        }
        RequestDispatcher view = req.getRequestDispatcher("login.html");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("email");
        String password = req.getParameter("psw");
        Users users = new Users(name, password);
        try {
            users = userServ.getUser(users);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (users.getLogin() != null) {
            resp.addCookie(new Cookie("id", Integer.toString(users.getId_user())));
            if (users.getUser_role() == Roles.ADMIN) {
                resp.addCookie(new Cookie("role", Roles.ADMIN.toString()));
            }
        }
        resp.sendRedirect("success.html");
    }

}
