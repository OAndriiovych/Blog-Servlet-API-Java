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

@WebServlet("/login")
public class Login extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (BaseServlet.checkSession(req, resp)) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }
        RequestDispatcher view = req.getRequestDispatcher("login.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("email");
        String password = req.getParameter("psw");
        password=HashPassword.hash(password);
        User user = new User(name, password);
        HttpSession session = req.getSession();
        try {
            user = userServ.getUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user.getId_user()==0){
            req.setAttribute("login", true);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        login(user,session);
        resp.sendRedirect(req.getContextPath() + "/");
    }


}
