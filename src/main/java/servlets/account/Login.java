package servlets.account;

import db.database.Roles;
import db.database.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

@WebServlet("/account")
public class Login extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (checkSession(req, resp)) {
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
        HttpSession session = req.getSession();
        try {
            users = userServ.getUser(users);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        login(users,session);
        resp.sendRedirect("success.html");
    }


}
